package br.com.fiap.postech.app.gestaoquarto.data.datasources.impl;

import br.com.fiap.postech.app.gestaoquarto.data.datasources.JpaPredioRepository;
import br.com.fiap.postech.app.gestaoquarto.data.datasources.PredioDatasourcesLocal;
import br.com.fiap.postech.app.gestaoquarto.data.models.PredioModel;

import java.util.Optional;

public class PredioDatasourcesLocalImpl implements PredioDatasourcesLocal {

    final JpaPredioRepository predioRepository;

    public PredioDatasourcesLocalImpl(JpaPredioRepository predioRepository) {
        this.predioRepository = predioRepository;
    }

    @Override
    public PredioModel consultarPredio(Long id) {
        Optional<PredioModel> op = predioRepository.findById(id);
        return op.get();
    }

    @Override
    public PredioModel cadastrarPredio(PredioModel predioModel) {
        return predioRepository.save(predioModel);
    }

}
