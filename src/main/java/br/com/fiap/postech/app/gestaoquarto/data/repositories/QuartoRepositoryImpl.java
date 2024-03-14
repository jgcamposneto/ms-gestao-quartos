package br.com.fiap.postech.app.gestaoquarto.data.repositories;

import br.com.fiap.postech.app.gestaoquarto.data.datasources.PredioDatasourcesLocal;
import br.com.fiap.postech.app.gestaoquarto.data.datasources.QuartoDatasourcesLocal;
import br.com.fiap.postech.app.gestaoquarto.data.models.PredioModel;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.QuartoEntity;
import br.com.fiap.postech.app.gestaoquarto.data.models.QuartoModel;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.QuartoRepository;

import java.util.List;

public class QuartoRepositoryImpl implements QuartoRepository {

    final QuartoDatasourcesLocal quartoDatasourcesLocal;
    final PredioDatasourcesLocal predioDatasourcesLocal;

    public QuartoRepositoryImpl(QuartoDatasourcesLocal quartoDatasourcesLocal, PredioDatasourcesLocal predioDatasourcesLocal) {
        this.quartoDatasourcesLocal = quartoDatasourcesLocal;
        this.predioDatasourcesLocal = predioDatasourcesLocal;
    }

    @Override
    public void criarQuarto(QuartoEntity quartoEntity) {
        PredioModel predioModel = predioDatasourcesLocal.consultarPredio(quartoEntity.getPredio().getId());
        QuartoModel quartoModel = QuartoModel.toQuartoModel(quartoEntity);
        quartoModel.setPredioModel(predioModel);
        quartoDatasourcesLocal.criarQuarto(quartoModel);
    }

    @Override
    public void apagarQuarto(Long id) {

    }

    @Override
    public QuartoEntity consultarQuarto(Long id) {
        return null;
    }

    @Override
    public List<QuartoEntity> consultarQuartos() {
        return null;
    }
}
