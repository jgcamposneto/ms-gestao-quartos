package br.com.fiap.postech.app.gestaoquarto.data.models;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.QuartoSimplesFactory;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.Predio;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.Quarto;

public class QuartoRequestModel {
    public static Quarto toAlbum(QuartoRequestModel requestModel) {
        return new QuartoSimplesFactory().create(new Predio());
    }
}
