package br.com.fiap.postech.app.gestaoquarto.domain.entities;

public class QuartoStandardDuploEntityFactory implements QuartoEntityFactory {
    @Override
    public QuartoEntity create(PredioEntity predioEntity) {
        return new QuartoStandardDuploEntity(predioEntity);
    }

    @Override
    public QuartoEntity create(PredioEntity predioEntity, Long id) {
        QuartoStandardDuploEntity quartoStandardDuploEntity = new QuartoStandardDuploEntity(predioEntity);
        quartoStandardDuploEntity.setId(id);
        return quartoStandardDuploEntity;
    }
}
