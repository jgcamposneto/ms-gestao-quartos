package br.com.fiap.postech.app.gestaoquarto.domain.usercases;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.Predio;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.Quarto;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.PredioRepository;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.QuartoRepository;

public class CriarQuarto {

    final QuartoRepository quartoRepository;
    final PredioRepository predioRepository;

    public CriarQuarto(QuartoRepository quartoRepository, PredioRepository predioRepository) {
        this.quartoRepository = quartoRepository;
        this.predioRepository = predioRepository;
    }

    public void call(Quarto quarto) {
        Predio predio = predioRepository.consultarPredio(quarto.getPredio().getId());
        if(predio == null) {
            throw new RuntimeException("Predio não cadastrado!");
        }
        quarto.setPredio(predio);
        quartoRepository.criarQuarto(quarto);
    }
}
