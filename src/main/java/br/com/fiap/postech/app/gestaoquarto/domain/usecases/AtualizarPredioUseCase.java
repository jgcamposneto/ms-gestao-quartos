package br.com.fiap.postech.app.gestaoquarto.domain.usecases;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.PredioEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.PredioRepository;

public class AtualizarPredioUseCase {

    final PredioRepository predioRepository;
    final ConsultarPredioUseCase consultarPredioUseCase;

    public AtualizarPredioUseCase(PredioRepository predioRepository, ConsultarPredioUseCase consultarPredioUseCase) {
        this.predioRepository = predioRepository;
        this.consultarPredioUseCase = consultarPredioUseCase;
    }

    public PredioEntity call(PredioEntity predioEntityParam) {
        PredioEntity predioEntity = consultarPredioUseCase.call(predioEntityParam.getId());
        validarPredio(predioEntity);
        return predioRepository.atualizarPredio(predioEntity);
    }

    private static void validarPredio(PredioEntity predioEntity) {
        if(predioEntity == null) {
            throw new RuntimeException("Predio não cadastrado!");
        }
    }

}
