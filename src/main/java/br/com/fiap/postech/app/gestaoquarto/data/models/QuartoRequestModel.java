package br.com.fiap.postech.app.gestaoquarto.data.models;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.QuartoEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.PredioEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class QuartoRequestModel {

    @NotNull(message = "Id do prédio não pode ser nulo")
    private Long idPredio;

    @Pattern(
            regexp = "STANDARD_SIMPLES|STANDARD_DUPLO|LUXO_SIMPLES|LUXO_DUPLO|PREMIUM_SIMPLES|PREMIUM_DUPLO",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Tipo do quarto não pode ser nulo")
    private TipoQuartoEnumRequestModel tipoQuartoEnumRequestModel;

    public static QuartoEntity toQuartoEntity(QuartoRequestModel requestModel) {
        PredioEntity predioEntity = new PredioEntity();
        predioEntity.setId(requestModel.idPredio);
        return requestModel.tipoQuartoEnumRequestModel.tipoQuarto(predioEntity);
    }

}
