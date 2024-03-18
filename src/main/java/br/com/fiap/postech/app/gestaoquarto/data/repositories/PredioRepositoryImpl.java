package br.com.fiap.postech.app.gestaoquarto.data.repositories;

import br.com.fiap.postech.app.gestaoquarto.data.datasources.PredioDatasourcesLocal;
import br.com.fiap.postech.app.gestaoquarto.data.datasources.QuartoDatasourcesLocal;
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
        PredioModel predioModel = predioDatasourcesLocal.consultarPredio(id);
        if (predioModel != null) {
            return predioModel.toPredio(predioDatasourcesLocal.consultarPredio(id));
        }
        return null;
    }

    @Override
    public PredioEntity criarPredio(PredioEntity predioEntity) {
        PredioModel predioModel = PredioModel.toModel(predioEntity);
        PredioModel predioSaved = predioDatasourcesLocal.cadastrarPredio(predioModel);
        return predioSaved.toPredio(predioSaved);
    }

    @Override
    public PredioEntity atualizarPredio(PredioEntity predioEntity) {
        PredioModel predioModel = predioDatasourcesLocal.consultarPredio(predioEntity.getId());
        predioModel.setLocalizacao(predioEntity.getLocalizacao());
        return predioModel.toPredio(predioModel);
    }
}
