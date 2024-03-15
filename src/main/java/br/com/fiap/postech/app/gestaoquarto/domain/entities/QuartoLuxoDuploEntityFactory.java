package br.com.fiap.postech.app.gestaoquarto.domain.entities;

public class QuartoLuxoDuploEntityFactory implements QuartoEntityFactory {
    @Override
    public QuartoEntity create(PredioEntity predioEntity) {
        return new QuartoLuxoDuploEntity(predioEntity);
    }

    @Override
    public QuartoEntity create(PredioEntity predioEntity, Long id) {
        QuartoLuxoDuploEntity quartoLuxoDuploEntity = new QuartoLuxoDuploEntity(predioEntity);
        quartoLuxoDuploEntity.setId(id);
        return quartoLuxoDuploEntity;
    }
}
