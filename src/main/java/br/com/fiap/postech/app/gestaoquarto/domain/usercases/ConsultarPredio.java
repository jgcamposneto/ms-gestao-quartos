package br.com.fiap.postech.app.gestaoquarto.domain.usercases;

import br.com.fiap.postech.app.gestaoquarto.domain.repositories.PredioRepository;

public class ConsultarPredio {

    final PredioRepository predioRepository;

    public ConsultarPredio(PredioRepository predioRepository) {
        this.predioRepository = predioRepository;
    }

    public void call(Long id) {
        predioRepository.consultarPredio(id);
    }
}
