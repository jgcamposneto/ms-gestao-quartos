package br.com.fiap.postech.app.gestaoquarto.domain.usecases;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.QuartoEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.QuartoRepository;

import java.util.List;

public class ConsultarQuartosUseCase {
    final QuartoRepository quartoRepository;

    public ConsultarQuartosUseCase(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }

    public List<QuartoEntity> call() {
        return quartoRepository.consultarQuartos();
    }

}
