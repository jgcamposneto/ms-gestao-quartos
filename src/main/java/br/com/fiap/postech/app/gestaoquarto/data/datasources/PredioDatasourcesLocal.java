package br.com.fiap.postech.app.gestaoquarto.data.datasources;

import br.com.fiap.postech.app.gestaoquarto.data.models.PredioModel;

public interface PredioDatasourcesLocal {

    PredioModel consultarPredio(Long id);

}
