package br.com.fiap.postech.gestaoquarto.domain.entities;

public class QuartoSimplesFactory implements QuartoFactory {
    @Override
    public Quarto create(Predio predio) {
        return new QuartoSimples(predio);
    }
}
