package br.com.fiap.postech.app.gestaoquarto.domain.entities;

public class QuartoPremiumDuploEntityFactory implements QuartoEntityFactory {
    @Override
    public QuartoEntity create(PredioEntity predioEntity) {
        return new QuartoPremiumDuploEntity(predioEntity);
    }
}