package br.com.fiap.postech.app.gestaoquarto.data.controller;

import br.com.fiap.postech.app.gestaoquarto.data.models.PredioRequestModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Predio Controller", description = "API para Gestão de Predios dos Quartos")
public interface PredioApi {

    @Operation(
            summary = "Cria um novo Predio",
            description = "Cria um novo Predio a partir da sua localização")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Prédio criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição não pode ser completada")
    })
    ResponseEntity<?> createPredio(@RequestBody PredioRequestModel predioRequestModel);

    @Operation(
            summary = "Atualiza um Prédio",
            description = "Atualiza a localização de um Prédio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prédio atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição não pode ser completada")
    })
    ResponseEntity<?> updatePredio(@PathVariable(name = "id") Long id, @RequestBody PredioRequestModel predioRequestModel);

    @Operation(
            summary = "Consulta um Prédio",
            description = "Consulta um Prédio pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prédio localizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição não pode ser completada")
    })
    ResponseEntity<?> getPredio(@PathVariable(name = "id") Long id);

    @Operation(
            summary = "Consulta de Prédios",
            description = "Consulta todos os Prédios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prédio localizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição não pode ser completada")
    })
    ResponseEntity<?> getPredios();

    @Operation(
            summary = "Apaga o Prédio",
            description = "Apaga o Prédio com o Id informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prédio apagado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição não pode ser completada")
    })
    ResponseEntity<?> deletePredio(@PathVariable(name = "id") Long id);

}
