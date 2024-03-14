package br.com.fiap.postech.app.gestaoquarto.domain.usecases;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.PredioEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.Quarto;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.QuartoRepository;

public class CriarQuartoUseCase {

    final QuartoRepository quartoRepository;
    final ConsultarPredioUseCase consultarPredioUseCase;

    public CriarQuartoUseCase(QuartoRepository quartoRepository, ConsultarPredioUseCase consultarPredioUseCase) {
        this.quartoRepository = quartoRepository;
        this.consultarPredioUseCase = consultarPredioUseCase;
    }

    public void call(Quarto quarto) {
        PredioEntity predioEntity = consultarPredioUseCase.call(quarto.getPredio().getId());
        validarPredio(predioEntity);
        quarto.setPredio(predioEntity);
        quartoRepository.criarQuarto(quarto);
    }

    private static void validarPredio(PredioEntity predioEntity) {
        if(predioEntity == null) {
            throw new RuntimeException("Predio não cadastrado!");
        }
    }
}
