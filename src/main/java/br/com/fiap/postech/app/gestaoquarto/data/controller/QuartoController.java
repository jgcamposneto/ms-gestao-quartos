package br.com.fiap.postech.app.gestaoquarto.data.controller;

import br.com.fiap.postech.app.gestaoquarto.data.models.QuartoRequestModel;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.QuartoEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.usecases.AtualizarQuartoUseCase;
import br.com.fiap.postech.app.gestaoquarto.domain.usecases.ConsultarPredioUseCase;
import br.com.fiap.postech.app.gestaoquarto.domain.usecases.ConsultarQuartoUseCase;
import br.com.fiap.postech.app.gestaoquarto.domain.usecases.CriarQuartoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quartos")
public class QuartoController implements QuartoApi{

    final CriarQuartoUseCase criarQuartoUseCase;
    final AtualizarQuartoUseCase atualizarQuartoUseCase;
    final ConsultarQuartoUseCase consultarQuartoUseCase;
    final ConsultarPredioUseCase consultarPredioUseCase;

    QuartoController(CriarQuartoUseCase criarQuartoUseCase,
                     AtualizarQuartoUseCase atualizarQuartoUseCase, ConsultarQuartoUseCase consultarQuartoUseCase,
                     ConsultarPredioUseCase consultarPredioUseCase) {
        this.criarQuartoUseCase = criarQuartoUseCase;
        this.atualizarQuartoUseCase = atualizarQuartoUseCase;
        this.consultarQuartoUseCase = consultarQuartoUseCase;
        this.consultarPredioUseCase = consultarPredioUseCase;
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createQuarto(@RequestBody QuartoRequestModel requestModel) {
        try {
            QuartoEntity quartoEntityCriado = criarQuartoUseCase.call(QuartoRequestModel.toQuartoEntity(requestModel));
            return ResponseEntity.status(HttpStatus.CREATED).body(quartoEntityCriado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> updateQuarto(@PathVariable Long id, @RequestBody QuartoRequestModel requestModel) {
        try {
            QuartoEntity quartoEntityCriado = atualizarQuartoUseCase.call(QuartoRequestModel.toQuartoEntity(requestModel), id);
            return ResponseEntity.status(HttpStatus.OK).body(quartoEntityCriado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getQuarto(Long id) {
        try {
            QuartoEntity quartoEntityConsultado = consultarQuartoUseCase.call(id);
            return ResponseEntity.status(HttpStatus.OK).body(quartoEntityConsultado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
