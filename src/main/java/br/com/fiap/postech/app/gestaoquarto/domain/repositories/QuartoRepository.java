package br.com.fiap.postech.app.gestaoquarto.domain.repositories;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.QuartoEntity;

import java.util.List;

public interface QuartoRepository {

    void criarQuarto(QuartoEntity quartoEntity);
    void apagarQuarto(Long id);
    QuartoEntity consultarQuarto(Long id);
    List<QuartoEntity> consultarQuartos();

}
