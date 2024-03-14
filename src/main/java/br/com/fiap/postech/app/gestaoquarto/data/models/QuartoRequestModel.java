package br.com.fiap.postech.app.gestaoquarto.data.models;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.QuartoSimplesFactory;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.PredioEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.Quarto;
import lombok.Data;

@Data
public class QuartoRequestModel {

    private Long idPredio;

    public static Quarto toQuarto(QuartoRequestModel requestModel) {
        PredioEntity predioEntity = new PredioEntity();
        predioEntity.setId(requestModel.idPredio);
        return new QuartoSimplesFactory().create(predioEntity);
    }

}
