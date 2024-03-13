package br.com.fiap.postech.app.gestaoquarto.data.datasources.impl;

import br.com.fiap.postech.app.gestaoquarto.data.datasources.JpaPredioRepository;
import br.com.fiap.postech.app.gestaoquarto.data.datasources.PredioDatasourcesLocal;
import br.com.fiap.postech.app.gestaoquarto.data.models.PredioModel;

public class PredioDatasourcesLocalImpl implements PredioDatasourcesLocal {

    final JpaPredioRepository predioRepository;

    public PredioDatasourcesLocalImpl(JpaPredioRepository predioRepository) {
        this.predioRepository = predioRepository;
    }

    @Override
    public PredioModel consultarPredio(Long id) {
        return predioRepository.findById(id).orElse(null);
    }
}
