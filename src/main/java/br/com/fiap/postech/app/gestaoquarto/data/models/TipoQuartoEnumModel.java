package br.com.fiap.postech.app.gestaoquarto.data.models;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.PredioEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.Quarto;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.QuartoSimplesFactory;

public enum TipoQuartoEnumModel {

    SIMPLES{
        @Override
        public Quarto tipoQuarto(PredioEntity predioEntity) {
            return new QuartoSimplesFactory().create(predioEntity);
        }
    };

    public abstract Quarto tipoQuarto(PredioEntity predioEntity);

}
