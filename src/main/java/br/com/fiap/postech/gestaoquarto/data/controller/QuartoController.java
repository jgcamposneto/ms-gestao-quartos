package br.com.fiap.postech.gestaoquarto.data.controller;

import br.com.fiap.postech.gestaoquarto.domain.usercases.CriarQuarto;
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

    public QuartoController(CriarQuarto criarQuarto) {
        this.criarQuarto = criarQuarto;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody QuartoRequestModel requestModel) {

        try {
            criarQuarto.call(QuartoRequestModel.toAlbum(requestModel));

            return new ResponseEntity<>(new QuartoResponseModel(HttpStatus.OK.value(), HttpStatus.OK.name()),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
