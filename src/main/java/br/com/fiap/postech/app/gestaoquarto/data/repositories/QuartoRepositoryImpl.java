package br.com.fiap.postech.app.gestaoquarto.data.repositories;

import br.com.fiap.postech.app.gestaoquarto.data.datasources.QuartoDatasourcesLocal;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.Quarto;
import br.com.fiap.postech.app.gestaoquarto.data.models.QuartoModel;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.QuartoRepository;

import java.util.List;

public class QuartoRepositoryImpl implements QuartoRepository {

    final QuartoDatasourcesLocal quartoDatasourcesLocal;

    public QuartoRepositoryImpl(QuartoDatasourcesLocal quartoDatasourcesLocal) {
        this.quartoDatasourcesLocal = quartoDatasourcesLocal;
    }

    @Override
    public void criarQuarto(Quarto quarto) {
        QuartoModel quartoModel = new QuartoModel();
        quartoDatasourcesLocal.criarQuarto(quartoModel.toQuartoModel(quarto));
    }

    @Override
    public void apagarQuarto(Long id) {

    }

    @Override
    public Quarto consultarQuarto(Long id) {
        return null;
    }

    @Override
    public List<Quarto> consultarQuartos() {
        return null;
    }
}
