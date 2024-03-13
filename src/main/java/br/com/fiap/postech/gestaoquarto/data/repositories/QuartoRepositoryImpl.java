package br.com.fiap.postech.gestaoquarto.data.repositories;

import br.com.fiap.postech.gestaoquarto.data.datasources.QuartoDatasourcesLocal;
import br.com.fiap.postech.gestaoquarto.domain.entities.Quarto;
import br.com.fiap.postech.gestaoquarto.domain.entities.QuartoModel;
import br.com.fiap.postech.gestaoquarto.domain.repositories.QuartoRepository;

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
