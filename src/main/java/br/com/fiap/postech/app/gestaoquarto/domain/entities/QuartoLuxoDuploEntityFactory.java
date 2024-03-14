package br.com.fiap.postech.app.gestaoquarto.domain.entities;

public class QuartoLuxoDuploEntityFactory implements QuartoEntityFactory {
    @Override
    public QuartoEntity create(PredioEntity predioEntity) {
        return new QuartoLuxoDuploEntity(predioEntity);
    }
}
