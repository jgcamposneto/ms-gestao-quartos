package br.com.fiap.postech.app.gestaoquarto.data.controller;

import br.com.fiap.postech.app.gestaoquarto.data.models.QuartoRequestModel;
import br.com.fiap.postech.app.gestaoquarto.data.models.QuartoResponseModel;
import br.com.fiap.postech.app.gestaoquarto.domain.usercases.ConsultarPredio;
import br.com.fiap.postech.app.gestaoquarto.domain.usercases.CriarQuarto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quartos")
public class QuartoController {

    final CriarQuarto criarQuarto;
    final ConsultarPredio consultarPredio;

    QuartoController(CriarQuarto criarQuarto, ConsultarPredio consultarPredio) {
        this.criarQuarto = criarQuarto;
        this.consultarPredio = consultarPredio;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody QuartoRequestModel requestModel) {

        try {
            criarQuarto.call(QuartoRequestModel.toQuarto(requestModel));

            return new ResponseEntity<>(new QuartoResponseModel(HttpStatus.OK.value(), HttpStatus.OK.name()),
                    HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
