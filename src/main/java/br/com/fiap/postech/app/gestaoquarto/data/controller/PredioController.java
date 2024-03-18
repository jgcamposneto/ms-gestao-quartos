package br.com.fiap.postech.app.gestaoquarto.data.controller;

import br.com.fiap.postech.app.gestaoquarto.data.models.PredioModel;
import br.com.fiap.postech.app.gestaoquarto.data.models.QuartoRequestModel;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.PredioEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.QuartoEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.PredioRepository;
import br.com.fiap.postech.app.gestaoquarto.domain.usecases.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("predio")
public class PredioController {
    final CriarPredioUseCase criarPredioUseCase;
    final AtualizarPredioUseCase atualizarPredioUseCase;

    PredioController(CriarPredioUseCase criarPredioUseCase,
                     AtualizarPredioUseCase atualizarPredioUseCase) {
        this.criarPredioUseCase = criarPredioUseCase;
        this.atualizarPredioUseCase = atualizarPredioUseCase;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createQuarto(@RequestBody PredioModel requestModel) {
        try {
            PredioModel model = new PredioModel();
            return ResponseEntity.status(HttpStatus.CREATED).body(criarPredioUseCase.call(model.toPredio(requestModel)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateQuarto(@PathVariable Long id, @RequestBody PredioModel requestModel) {
        try {
            PredioModel model = new PredioModel();
            return ResponseEntity.status(HttpStatus.OK).body(atualizarPredioUseCase.call(model.toPredio(requestModel)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuarto(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getQuartos() {
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteQuarto(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().build();
    }

}
