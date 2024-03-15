package br.com.fiap.postech.app.gestaoquarto.domain.usecases;

import br.com.fiap.postech.app.gestaoquarto.domain.repositories.QuartoRepository;

public class ApagarQuartoUseCase {

    final QuartoRepository quartoRepository;

    public ApagarQuartoUseCase(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }

    public void call(Long id) {
        quartoRepository.apagarQuarto(id);
    }
}
