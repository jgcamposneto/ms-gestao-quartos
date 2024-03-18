package br.com.fiap.postech.app.gestaoquarto.data.controller;

import br.com.fiap.postech.app.gestaoquarto.data.models.PredioModel;
import br.com.fiap.postech.app.gestaoquarto.data.models.PredioRequestModel;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.PredioEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.usecases.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("predios")
public class PredioController implements PredioApi {
    final CriarPredioUseCase criarPredioUseCase;
    final AtualizarPredioUseCase atualizarPredioUseCase;
    final ConsultarPredioUseCase consultarPredioUseCase;

    PredioController(CriarPredioUseCase criarPredioUseCase,
                     AtualizarPredioUseCase atualizarPredioUseCase,
                     ConsultarPredioUseCase consultarPredioUseCase) {
        this.criarPredioUseCase = criarPredioUseCase;
        this.atualizarPredioUseCase = atualizarPredioUseCase;
        this.consultarPredioUseCase = consultarPredioUseCase;
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createPredio(@RequestBody PredioRequestModel predioRequestModel) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(criarPredioUseCase.call(PredioRequestModel.toPredioEntity(predioRequestModel)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePredio(@PathVariable(name = "id") Long id, @RequestBody PredioRequestModel predioRequestModel) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(atualizarPredioUseCase.call(PredioRequestModel.toPredioEntity(predioRequestModel)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getPredio(@PathVariable(name = "id") Long id) {
        try {
            PredioEntity predioEntityConsultado = consultarPredioUseCase.call(id);
            return ResponseEntity.status(HttpStatus.OK).body(predioEntityConsultado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<?> getPredios() {
        return ResponseEntity.ok().build();
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePredio(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().build();
    }

}
