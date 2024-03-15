package br.com.fiap.postech.app.gestaoquarto.domain.entities;

public class QuartoStandardSimplesEntityFactory implements QuartoEntityFactory {
    @Override
    public QuartoEntity create(PredioEntity predioEntity) {
        return new QuartoStandardSimplesEntity(predioEntity);
    }

    @Override
    public QuartoEntity create(PredioEntity predioEntity, Long id) {
        QuartoStandardSimplesEntity quartoStandardSimplesEntity = new QuartoStandardSimplesEntity(predioEntity);
        quartoStandardSimplesEntity.setId(id);
        return quartoStandardSimplesEntity;
    }
}
