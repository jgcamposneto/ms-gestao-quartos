package br.com.fiap.postech.app.gestaoquarto.domain.entities;

import java.math.BigDecimal;
import java.util.List;

abstract class QuartoPadraoEntity implements QuartoEntity {

    private Long id;
    private PredioEntity predioEntity;
    protected int totalPessoas;
    protected int totalCamasQueenSize;
    protected int totalCamasKingSize;
    protected int totalCamasSolteiro;
    protected List<String> outrosMoveis;
    protected BigDecimal valorDiaria;

    protected String tipoQuarto;

    protected QuartoPadraoEntity(PredioEntity predioEntity) {
        this.predioEntity = predioEntity;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public PredioEntity getPredio() {
        return predioEntity;
    }

    @Override
    public int getTotalPessoas() {
        return totalPessoas;
    }

    @Override
    public int getTotalCamasQueenSize() {
        return totalCamasQueenSize;
    }

    @Override
    public int getTotalCamasKingSize() {
        return totalCamasKingSize;
    }

    @Override
    public int getTotalCamasSolteiro() {
        return totalCamasSolteiro;
    }

    @Override
    public List<String> getOutrosMoveis() {
        return outrosMoveis;
    }

    @Override
    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    @Override
    public void setPredio(PredioEntity predioEntity) {
        this.predioEntity = predioEntity;
    }

    @Override
    public String getTipoQuarto() {
        return tipoQuarto;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
