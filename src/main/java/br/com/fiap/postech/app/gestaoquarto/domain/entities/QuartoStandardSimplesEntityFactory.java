package br.com.fiap.postech.app.gestaoquarto.domain.entities;

public class QuartoStandardSimplesEntityFactory implements QuartoEntityFactory {
    @Override
    public QuartoEntity create(PredioEntity predioEntity) {
        return new QuartoStandardSimplesEntity(predioEntity);
    }
}
