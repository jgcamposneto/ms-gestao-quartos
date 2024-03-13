package br.com.fiap.postech.app.gestaoquarto.data.repositories;

import br.com.fiap.postech.app.gestaoquarto.data.datasources.PredioDatasourcesLocal;
import br.com.fiap.postech.app.gestaoquarto.data.datasources.QuartoDatasourcesLocal;
import br.com.fiap.postech.app.gestaoquarto.data.models.PredioModel;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.Quarto;
import br.com.fiap.postech.app.gestaoquarto.data.models.QuartoModel;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.QuartoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class QuartoRepositoryImpl implements QuartoRepository {

    final QuartoDatasourcesLocal quartoDatasourcesLocal;
    final PredioDatasourcesLocal predioDatasourcesLocal;

    public QuartoRepositoryImpl(QuartoDatasourcesLocal quartoDatasourcesLocal, PredioDatasourcesLocal predioDatasourcesLocal) {
        this.quartoDatasourcesLocal = quartoDatasourcesLocal;
        this.predioDatasourcesLocal = predioDatasourcesLocal;
    }

    @Override
    public void criarQuarto(Quarto quarto) {
        PredioModel predioModel = predioDatasourcesLocal.consultarPredio(quarto.getPredio().getId());
        QuartoModel quartoModel = QuartoModel.toQuartoModel(quarto);
        quartoModel.setPredioModel(predioModel);
        quartoDatasourcesLocal.criarQuarto(quartoModel);
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
