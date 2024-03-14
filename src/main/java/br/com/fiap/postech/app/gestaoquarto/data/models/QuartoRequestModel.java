package br.com.fiap.postech.app.gestaoquarto.data.models;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.QuartoSimplesFactory;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.PredioEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.Quarto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class QuartoRequestModel {

    @NotNull(message = "Id do prédio não pode ser nulo")
    private Long idPredio;

    @Pattern(regexp = "SIMPLES", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Tipo do quarto não pode ser nulo")
    private TipoQuartoEnumModel tipoQuartoEnumModel;

    public static Quarto toQuarto(QuartoRequestModel requestModel) {
        PredioEntity predioEntity = new PredioEntity();
        predioEntity.setId(requestModel.idPredio);
        return requestModel.tipoQuartoEnumModel.tipoQuarto(predioEntity);
    }

}
