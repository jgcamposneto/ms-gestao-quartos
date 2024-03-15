package br.com.fiap.postech.app.gestaoquarto.data.repositories;

import br.com.fiap.postech.app.gestaoquarto.data.datasources.PredioDatasourcesLocal;
import br.com.fiap.postech.app.gestaoquarto.data.datasources.QuartoDatasourcesLocal;
import br.com.fiap.postech.app.gestaoquarto.data.models.PredioModel;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.QuartoEntity;
import br.com.fiap.postech.app.gestaoquarto.data.models.QuartoModel;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.QuartoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class QuartoRepositoryImpl implements QuartoRepository {

    final QuartoDatasourcesLocal quartoDatasourcesLocal;
    final PredioDatasourcesLocal predioDatasourcesLocal;

    public QuartoRepositoryImpl(QuartoDatasourcesLocal quartoDatasourcesLocal, PredioDatasourcesLocal predioDatasourcesLocal) {
        this.quartoDatasourcesLocal = quartoDatasourcesLocal;
        this.predioDatasourcesLocal = predioDatasourcesLocal;
    }

    @Override
    public QuartoEntity criarQuarto(QuartoEntity quartoEntity) {
        PredioModel predioModel = predioDatasourcesLocal.consultarPredio(quartoEntity.getPredio().getId());
        QuartoModel quartoModel = QuartoModel.toQuartoModel(quartoEntity);
        quartoModel.setPredioModel(predioModel);
        QuartoModel quartoModelCriado = quartoDatasourcesLocal.criarQuarto(quartoModel);
        quartoEntity.setId(quartoModelCriado.getId());
        return quartoEntity;
    }

    @Override
    public void apagarQuarto(Long id) {
        quartoDatasourcesLocal.apagarQuarto(id);
    }

    @Override
    public QuartoEntity consultarQuarto(Long id) {
        return QuartoModel.toQuartoEntity(quartoDatasourcesLocal.consultarQuarto(id));
    }

    @Override
    public List<QuartoEntity> consultarQuartos() {
        return quartoDatasourcesLocal.consultarQuartos()
                .stream()
                .map(QuartoModel::toQuartoEntity)
                .collect(Collectors.toList());
    }

    @Override
    public QuartoEntity atualizarQuarto(QuartoEntity quartoEntity) {
        PredioModel predioModel = predioDatasourcesLocal.consultarPredio(quartoEntity.getPredio().getId());
        QuartoModel quartoModel = QuartoModel.toQuartoModel(quartoEntity);
        quartoModel.setPredioModel(predioModel);
        quartoDatasourcesLocal.atualizarQuarto(quartoModel);
        return quartoEntity;
    }
}
