package br.com.fiap.postech.app.gestaoquarto.domain.entities;

public class QuartoStandardDuploEntityFactory implements QuartoEntityFactory {
    @Override
    public QuartoEntity create(PredioEntity predioEntity) {
        return new QuartoStandardDuploEntity(predioEntity);
    }
}
