package br.com.fiap.postech.gestaoquarto.domain.usercases;

import br.com.fiap.postech.gestaoquarto.domain.entities.Quarto;
import br.com.fiap.postech.gestaoquarto.domain.repositories.QuartoRepository;

public class CriarQuarto {

    final QuartoRepository quartoRepository;

    public CriarQuarto(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }

    public void call(Quarto quarto) {
        quartoRepository.criarQuarto(quarto);
    }
}
