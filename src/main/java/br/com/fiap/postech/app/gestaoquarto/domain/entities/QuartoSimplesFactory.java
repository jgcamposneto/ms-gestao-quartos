package br.com.fiap.postech.app.gestaoquarto.domain.entities;

public class QuartoSimplesFactory implements QuartoFactory {
    @Override
    public Quarto create(Predio predio) {
        return new QuartoSimples(predio);
    }
}