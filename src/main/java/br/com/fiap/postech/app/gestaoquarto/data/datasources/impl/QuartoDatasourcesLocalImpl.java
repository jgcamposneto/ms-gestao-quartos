package br.com.fiap.postech.app.gestaoquarto.data.datasources.impl;

import br.com.fiap.postech.app.gestaoquarto.data.datasources.JpaQuartoRepository;
import br.com.fiap.postech.app.gestaoquarto.data.datasources.QuartoDatasourcesLocal;
import br.com.fiap.postech.app.gestaoquarto.data.models.QuartoModel;

import java.util.List;
import java.util.Optional;

public class QuartoDatasourcesLocalImpl implements QuartoDatasourcesLocal {

    final JpaQuartoRepository jpaQuartoRepository;

    public QuartoDatasourcesLocalImpl(JpaQuartoRepository jpaQuartoRepository) {
        this.jpaQuartoRepository = jpaQuartoRepository;
    }

    @Override
    public QuartoModel criarQuarto(QuartoModel quartoModel) {
        return jpaQuartoRepository.save(quartoModel);
    }

    @Override
    public void apagarQuarto(Long id) {
        jpaQuartoRepository.deleteById(id);
    }

    @Override
    public QuartoModel consultarQuarto(Long id) {
        Optional<QuartoModel> op = jpaQuartoRepository.findById(id);
        return op.get();
    }

    @Override
    public List<QuartoModel> consultarQuartos() {
        return jpaQuartoRepository.findAll();
    }

    @Override
    public QuartoModel atualizarQuarto(QuartoModel quartoModel) {
        return jpaQuartoRepository.save(quartoModel);
    }
}
