package br.com.fiap.postech.app.gestaoquarto.data.controller;

import br.com.fiap.postech.app.gestaoquarto.data.models.QuartoRequestModel;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.QuartoEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.usecases.AtualizarQuartoUseCase;
import br.com.fiap.postech.app.gestaoquarto.domain.usecases.ConsultarPredioUseCase;
import br.com.fiap.postech.app.gestaoquarto.domain.usecases.CriarQuartoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quartos")
public class QuartoController implements QuartoApi{

    final CriarQuartoUseCase criarQuarto;
    final AtualizarQuartoUseCase atualizarQuarto;
    final ConsultarPredioUseCase consultarPredioUseCase;

    QuartoController(CriarQuartoUseCase criarQuarto,
                     AtualizarQuartoUseCase atualizarQuarto,
                     ConsultarPredioUseCase consultarPredioUseCase) {
        this.criarQuarto = criarQuarto;
        this.atualizarQuarto = atualizarQuarto;
        this.consultarPredioUseCase = consultarPredioUseCase;
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody QuartoRequestModel requestModel) {
        try {
            QuartoEntity quartoEntityCriado = criarQuarto.call(QuartoRequestModel.toQuartoEntity(requestModel));
            return ResponseEntity.status(HttpStatus.CREATED).body(quartoEntityCriado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody QuartoRequestModel requestModel) {
        try {
            QuartoEntity quartoEntityCriado = atualizarQuarto.call(QuartoRequestModel.toQuartoEntity(requestModel), id);
            return ResponseEntity.status(HttpStatus.OK).body(quartoEntityCriado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
