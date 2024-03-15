package br.com.fiap.postech.app.gestaoquarto.domain.entities;

interface QuartoEntityFactory {

    QuartoEntity create(PredioEntity predioEntity);
    QuartoEntity create(PredioEntity predioEntity, Long id);
}
