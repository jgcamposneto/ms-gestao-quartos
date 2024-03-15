package br.com.fiap.postech.app.gestaoquarto.domain.entities;

public class QuartoPremiumDuploEntityFactory implements QuartoEntityFactory {
    @Override
    public QuartoEntity create(PredioEntity predioEntity) {
        return new QuartoPremiumDuploEntity(predioEntity);
    }

    @Override
    public QuartoEntity create(PredioEntity predioEntity, Long id) {
        QuartoPremiumDuploEntity quartoPremiumDuploEntity = new QuartoPremiumDuploEntity(predioEntity);
        quartoPremiumDuploEntity.setId(id);
        return quartoPremiumDuploEntity;
    }
}