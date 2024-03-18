package br.com.fiap.postech.app.gestaoquarto.domain.repositories;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.PredioEntity;

public interface PredioRepository {
    PredioEntity consultarPredio(Long id);
    PredioEntity criarPredio(PredioEntity predioEntity);
    PredioEntity atualizarPredio(PredioEntity predioEntity);
}
