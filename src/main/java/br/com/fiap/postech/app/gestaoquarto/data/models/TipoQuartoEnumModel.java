package br.com.fiap.postech.app.gestaoquarto.data.models;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.*;

public enum TipoQuartoEnumModel {

    STANDARD_SIMPLES{
        @Override
        public QuartoEntity tipoQuarto(PredioEntity predioEntity) {
            return new QuartoStandardSimplesEntityFactory().create(predioEntity);
        }
    },
    STANDARD_DUPLO{
        @Override
        public QuartoEntity tipoQuarto(PredioEntity predioEntity) {
            return new QuartoStandardDuploEntityFactory().create(predioEntity);
        }
    },
    LUXO_SIMPLES{
        @Override
        public QuartoEntity tipoQuarto(PredioEntity predioEntity) {
            return new QuartoLuxoSimplesEntityFactory().create(predioEntity);
        }
    },
    LUXO_DUPLO{
        @Override
        public QuartoEntity tipoQuarto(PredioEntity predioEntity) {
            return new QuartoLuxoDuploEntityFactory().create(predioEntity);
        }
    },
    PREMIUM_SIMPLES{
        @Override
        public QuartoEntity tipoQuarto(PredioEntity predioEntity) {
            return new QuartoPremiumSimplesEntityFactory().create(predioEntity);
        }
    },
    PREMIUM_DUPLO{
        @Override
        public QuartoEntity tipoQuarto(PredioEntity predioEntity) {
            return new QuartoPremiumDuploEntityFactory().create(predioEntity);
        }
    };

    public abstract QuartoEntity tipoQuarto(PredioEntity predioEntity);

}
