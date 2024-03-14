package br.com.fiap.postech.app.gestaoquarto.data.models;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.PredioEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.QuartoEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.QuartoStandardSimplesEntityFactory;

public enum TipoQuartoEnumModel {

    SIMPLES{
        @Override
        public QuartoEntity tipoQuarto(PredioEntity predioEntity) {
            return new QuartoStandardSimplesEntityFactory().create(predioEntity);
        }
    };

    public abstract QuartoEntity tipoQuarto(PredioEntity predioEntity);

}
