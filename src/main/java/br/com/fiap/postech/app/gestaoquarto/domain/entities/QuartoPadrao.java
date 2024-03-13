package br.com.fiap.postech.app.gestaoquarto.domain.entities;

import java.math.BigDecimal;
import java.util.List;

abstract class QuartoPadrao implements Quarto {

    private Long id;
    private Predio predio;
    protected int totalPessoas;
    protected int totalCamasQueenSize;
    protected int totalCamasKingSize;
    protected int totalCamasSolteiro;
    protected List<String> outrosImoveis;
    protected BigDecimal valorDiaria;

    protected QuartoPadrao(Predio predio) {
        this.predio = predio;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Predio getPredio() {
        return predio;
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
        return outrosImoveis;
    }

    @Override
    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }
}
