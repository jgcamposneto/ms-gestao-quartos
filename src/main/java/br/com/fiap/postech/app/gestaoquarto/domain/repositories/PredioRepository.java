package br.com.fiap.postech.app.gestaoquarto.domain.repositories;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.Predio;

public interface PredioRepository {

    Predio consultarPredio(Long id);

}
