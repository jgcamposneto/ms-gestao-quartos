package br.com.fiap.postech.gestaoquarto.data.models;

import br.com.fiap.postech.gestaoquarto.domain.entities.Predio;
import br.com.fiap.postech.gestaoquarto.domain.entities.Quarto;
import br.com.fiap.postech.gestaoquarto.domain.entities.QuartoSimplesFactory;

public class QuartoRequestModel {
    public static Quarto toAlbum(QuartoRequestModel requestModel) {
        return new QuartoSimplesFactory().create(new Predio());
    }
}
