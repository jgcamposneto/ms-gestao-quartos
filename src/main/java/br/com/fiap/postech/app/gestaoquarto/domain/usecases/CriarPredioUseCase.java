package br.com.fiap.postech.app.gestaoquarto.domain.usecases;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.PredioEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.PredioRepository;

public class CriarPredioUseCase {

    final PredioRepository predioRepository;
    final ConsultarPredioUseCase consultarPredioUseCase;

    public CriarPredioUseCase(PredioRepository predioRepository, ConsultarPredioUseCase consultarPredioUseCase) {
        this.predioRepository = predioRepository;
        this.consultarPredioUseCase = consultarPredioUseCase;
    }

    public PredioEntity call(PredioEntity predioEntity) {
        return predioRepository.criarPredio(predioEntity);
    }

 }
