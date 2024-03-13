package br.com.fiap.postech.app.gestaoquarto.data.models;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.Predio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "predio")
@Table(name = "predio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PredioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String localizacao;

    @OneToMany(mappedBy = "predioModel", cascade = CascadeType.ALL)
    private List<QuartoModel> quartos;

    public Predio toPredio(PredioModel predioModel) {
        Predio predio = new Predio();
        predio.setLocalizacao(predioModel.getLocalizacao());
        predio.setId(predioModel.getId());
        return predio;
    }
}