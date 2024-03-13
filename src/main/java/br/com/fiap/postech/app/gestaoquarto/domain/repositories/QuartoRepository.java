package br.com.fiap.postech.app.gestaoquarto.domain.repositories;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.Quarto;

import java.util.List;

public interface QuartoRepository {

    public void criarQuarto(Quarto quarto);
    public void apagarQuarto(Long id);
    public Quarto consultarQuarto(Long id);
    public List<Quarto> consultarQuartos();

}
