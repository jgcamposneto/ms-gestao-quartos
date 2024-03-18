package br.com.fiap.postech.app.gestaoquarto.data.models;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.PredioEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PredioRequestModel {

    @NotBlank(message = "Localização do prédio não pode ser nula")
    private String localizacao;

    public static PredioEntity toPredioEntity(PredioRequestModel predioRequestModel) {
        PredioEntity predioEntity = new PredioEntity();
        predioEntity.setLocalizacao(predioRequestModel.getLocalizacao());
        return predioEntity;
    }

}
