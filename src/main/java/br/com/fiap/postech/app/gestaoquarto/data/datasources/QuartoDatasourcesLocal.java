package br.com.fiap.postech.app.gestaoquarto.data.datasources;

import br.com.fiap.postech.app.gestaoquarto.data.models.QuartoModel;

import java.util.List;

public interface QuartoDatasourcesLocal {

    void criarQuarto(QuartoModel quartoModel);
    void apagarQuarto(Long id);
    QuartoModel consultarQuarto(Long id);
    List<QuartoModel> consultarQuartos();
}
