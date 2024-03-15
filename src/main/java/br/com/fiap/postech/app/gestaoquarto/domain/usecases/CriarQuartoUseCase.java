package br.com.fiap.postech.app.gestaoquarto.domain.usecases;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.PredioEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.QuartoEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.QuartoRepository;

public class CriarQuartoUseCase {

    final QuartoRepository quartoRepository;
    final ConsultarPredioUseCase consultarPredioUseCase;

    public CriarQuartoUseCase(QuartoRepository quartoRepository, ConsultarPredioUseCase consultarPredioUseCase) {
        this.quartoRepository = quartoRepository;
        this.consultarPredioUseCase = consultarPredioUseCase;
    }

    public QuartoEntity call(QuartoEntity quartoEntity) {
        PredioEntity predioEntity = consultarPredioUseCase.call(quartoEntity.getPredio().getId());
        validarPredio(predioEntity);
        quartoEntity.setPredio(predioEntity);
        return quartoRepository.criarQuarto(quartoEntity);
    }

    private static void validarPredio(PredioEntity predioEntity) {
        if(predioEntity == null) {
            throw new RuntimeException("Predio não cadastrado!");
        }
    }
}
