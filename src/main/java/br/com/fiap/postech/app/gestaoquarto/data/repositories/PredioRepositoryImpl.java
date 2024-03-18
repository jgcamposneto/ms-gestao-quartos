package br.com.fiap.postech.app.gestaoquarto.data.repositories;

import br.com.fiap.postech.app.gestaoquarto.data.datasources.PredioDatasourcesLocal;
import br.com.fiap.postech.app.gestaoquarto.data.models.PredioModel;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.PredioEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.PredioRepository;

public class PredioRepositoryImpl implements PredioRepository {

    final PredioDatasourcesLocal predioDatasourcesLocal;

    public PredioRepositoryImpl(PredioDatasourcesLocal predioDatasourcesLocal) {
        this.predioDatasourcesLocal = predioDatasourcesLocal;
    }

    @Override
    public PredioEntity consultarPredio(Long id) {
        return PredioModel.toPredioEntity(predioDatasourcesLocal.consultarPredio(id));
    }

    @Override
    public PredioEntity criarPredio(PredioEntity predioEntity) {
        PredioModel predioModel = PredioModel.toPredioModel(predioEntity);
        PredioModel predioSaved = predioDatasourcesLocal.cadastrarPredio(predioModel);
        return PredioModel.toPredioEntity(predioSaved);
    }

    @Override
    public PredioEntity atualizarPredio(PredioEntity predioEntity) {
        PredioModel predioModel = predioDatasourcesLocal.consultarPredio(predioEntity.getId());
        predioModel.setLocalizacao(predioEntity.getLocalizacao());
        return PredioModel.toPredioEntity(predioModel);
    }
}
