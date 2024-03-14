package br.com.fiap.postech.app.gestaoquarto.domain.usecases;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.PredioEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.Quarto;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.PredioRepository;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.QuartoRepository;

public class CriarQuartoUseCase {

    final QuartoRepository quartoRepository;
    final PredioRepository predioRepository;

    public CriarQuartoUseCase(QuartoRepository quartoRepository, PredioRepository predioRepository) {
        this.quartoRepository = quartoRepository;
        this.predioRepository = predioRepository;
    }

    public void call(Quarto quarto) {
        PredioEntity predioEntity = predioRepository.consultarPredio(quarto.getPredio().getId());
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
