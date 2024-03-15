package br.com.fiap.postech.app.gestaoquarto.domain.usecases;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.*;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.QuartoRepository;

public class AtualizarQuartoUseCase {

    final QuartoRepository quartoRepository;
    final ConsultarQuartoUseCase consultarQuartoUseCase;
    final ConsultarPredioUseCase consultarPredioUseCase;

    public AtualizarQuartoUseCase(QuartoRepository quartoRepository, ConsultarQuartoUseCase consultarQuartoUseCase, ConsultarPredioUseCase consultarPredioUseCase) {
        this.quartoRepository = quartoRepository;
        this.consultarQuartoUseCase = consultarQuartoUseCase;
        this.consultarPredioUseCase = consultarPredioUseCase;
    }

    public QuartoEntity call(QuartoEntity quartoEntityParam, Long id) {
        PredioEntity predioEntity = consultarPredioUseCase.call(quartoEntityParam.getPredio().getId());
        validarPredio(predioEntity);
        QuartoEntity quartoEntityExistente = consultarQuartoUseCase.call(id);
        validarQuarto(quartoEntityExistente);
        QuartoEntity quartoEntityAtualizado = escolherTipoQuarto(quartoEntityParam.getTipoQuarto(), predioEntity);
        quartoEntityAtualizado.setId(id);
        return quartoRepository.atualizarQuarto(quartoEntityAtualizado);
    }

    private QuartoEntity escolherTipoQuarto(String tipoQuarto, PredioEntity predioEntity) {
        switch (tipoQuarto) {
            case "STANDARD_SIMPLES":
                return new QuartoStandardSimplesEntityFactory().create(predioEntity);
            case "STANDARD_DUPLO":
                return new QuartoStandardDuploEntityFactory().create(predioEntity);
            case "LUXO_SIMPLES":
                return new QuartoLuxoSimplesEntityFactory().create(predioEntity);
            case "LUXO_DUPLO":
                return new QuartoLuxoDuploEntityFactory().create(predioEntity);
            case "PREMIUM_SIMPLES":
                return new QuartoPremiumSimplesEntityFactory().create(predioEntity);
            case "PREMIUM_DUPLO":
                return new QuartoPremiumDuploEntityFactory().create(predioEntity);
            default:
                throw new IllegalArgumentException("Tipo de quarto não reconhecido: " + tipoQuarto);
        }
    }

    private static void validarQuarto(QuartoEntity quartoEntity) {
        if(quartoEntity == null) {
            throw new RuntimeException("Quarto não cadastrado!");
        }
    }

    private static void validarPredio(PredioEntity predioEntity) {
        if(predioEntity == null) {
            throw new RuntimeException("Predio não cadastrado!");
        }
    }
}
