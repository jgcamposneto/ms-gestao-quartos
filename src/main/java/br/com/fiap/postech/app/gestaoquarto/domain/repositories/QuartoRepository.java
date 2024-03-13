package br.com.fiap.postech.app.gestaoquarto.domain.repositories;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.Quarto;

import java.util.List;

public interface QuartoRepository {

    void criarQuarto(Quarto quarto);
    void apagarQuarto(Long id);
    Quarto consultarQuarto(Long id);
    List<Quarto> consultarQuartos();

}
