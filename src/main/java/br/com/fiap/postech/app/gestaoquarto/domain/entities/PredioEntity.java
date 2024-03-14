package br.com.fiap.postech.app.gestaoquarto.domain.entities;

import java.util.List;

public class PredioEntity {

    private Long id;
    private String localizacao;
    private List<QuartoEntity> quartoEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public List<QuartoEntity> getQuartos() {
        return quartoEntities;
    }

    public void setQuartos(List<QuartoEntity> quartoEntities) {
        this.quartoEntities = quartoEntities;
    }
}
