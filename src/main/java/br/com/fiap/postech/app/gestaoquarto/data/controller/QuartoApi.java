package br.com.fiap.postech.app.gestaoquarto.data.controller;

import br.com.fiap.postech.app.gestaoquarto.data.models.QuartoRequestModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Quarto Controller", description = "API para Gestão de Quartos")
public interface QuartoApi {

    @Operation(
            summary = "Cria um novo Quarto",
            description = "Cria um novo Quarto a partir do Prédio onde ele está localizado e do Tipo do Quarto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Quarto criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição não pode ser completada")
    })
    ResponseEntity<?> create(@RequestBody QuartoRequestModel requestModel);

    @Operation(
            summary = "Atualiza um Quarto",
            description = "Atualiza o Prédio e/ou o Tipo do Quarto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Quarto atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição não pode ser completada")
    })
    ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody QuartoRequestModel requestModel);
}
