package br.com.fiap.postech.gestaoquarto.data.datasources;

import br.com.fiap.postech.gestaoquarto.domain.entities.QuartoModel;

import java.util.List;

public interface QuartoDatasourcesLocal {

    public void criarQuarto(QuartoModel quartoModel);
    public void apagarQuarto(Long id);
    public QuartoModel consultarQuarto(Long id);
    public List<QuartoModel> consultarQuartos();
}
