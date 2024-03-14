package br.com.fiap.postech.app.gestaoquarto.domain.entities;

public class QuartoLuxoSimplesEntityFactory implements QuartoEntityFactory {
    @Override
    public QuartoEntity create(PredioEntity predioEntity) {
        return new QuartoLuxoSimplesEntity(predioEntity);
    }
}
