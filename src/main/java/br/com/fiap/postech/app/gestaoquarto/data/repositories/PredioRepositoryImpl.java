package br.com.fiap.postech.app.gestaoquarto.data.repositories;

import br.com.fiap.postech.app.gestaoquarto.data.datasources.PredioDatasourcesLocal;
import br.com.fiap.postech.app.gestaoquarto.data.models.PredioModel;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.Predio;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.PredioRepository;

public class PredioRepositoryImpl implements PredioRepository {

    final PredioDatasourcesLocal predioDatasourcesLocal;

    public PredioRepositoryImpl(PredioDatasourcesLocal predioDatasourcesLocal) {
        this.predioDatasourcesLocal = predioDatasourcesLocal;
    }

    @Override
    public Predio consultarPredio(Long id) {
        PredioModel predioModel = new PredioModel();
        return predioModel.toPredio(predioDatasourcesLocal.consultarPredio(id));
    }
}
