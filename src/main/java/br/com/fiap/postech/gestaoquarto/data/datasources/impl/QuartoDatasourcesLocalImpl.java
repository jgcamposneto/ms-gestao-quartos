package br.com.fiap.postech.gestaoquarto.data.datasources.impl;

import br.com.fiap.postech.gestaoquarto.data.datasources.JpaQuartoRepository;
import br.com.fiap.postech.gestaoquarto.data.datasources.QuartoDatasourcesLocal;
import br.com.fiap.postech.gestaoquarto.data.models.QuartoModel;

import java.util.List;

public class QuartoDatasourcesLocalImpl implements QuartoDatasourcesLocal {

    final JpaQuartoRepository jpaQuartoRepository;

    public QuartoDatasourcesLocalImpl(JpaQuartoRepository jpaQuartoRepository) {
        this.jpaQuartoRepository = jpaQuartoRepository;
    }

    @Override
    public void criarQuarto(QuartoModel quartoModel) {
        jpaQuartoRepository.save(quartoModel);
    }

    @Override
    public void apagarQuarto(Long id) {

    }

    @Override
    public QuartoModel consultarQuarto(Long id) {
        return null;
    }

    @Override
    public List<QuartoModel> consultarQuartos() {
        return null;
    }
}
