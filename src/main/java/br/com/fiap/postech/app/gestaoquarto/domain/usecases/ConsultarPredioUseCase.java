package br.com.fiap.postech.app.gestaoquarto.domain.usecases;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.PredioEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.PredioRepository;

public class ConsultarPredioUseCase {

    final PredioRepository predioRepository;

    public ConsultarPredioUseCase(PredioRepository predioRepository) {
        this.predioRepository = predioRepository;
    }

    public PredioEntity call(Long id) {
        return predioRepository.consultarPredio(id);
    }
}
