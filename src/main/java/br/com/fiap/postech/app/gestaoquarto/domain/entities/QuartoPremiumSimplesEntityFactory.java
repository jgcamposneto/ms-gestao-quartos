package br.com.fiap.postech.app.gestaoquarto.domain.entities;

public class QuartoPremiumSimplesEntityFactory implements QuartoEntityFactory {
    @Override
    public QuartoEntity create(PredioEntity predioEntity) {
        return new QuartoPremiumSimplesEntity(predioEntity);
    }
}
