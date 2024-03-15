package br.com.fiap.postech.app.gestaoquarto.domain.usecases;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.QuartoEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.QuartoRepository;

public class ConsultarQuartoUseCase {

    final QuartoRepository quartoRepository;

    public ConsultarQuartoUseCase(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }

    public QuartoEntity call(Long id) {
        return quartoRepository.consultarQuarto(id);
    }

}
