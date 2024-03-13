package br.com.fiap.postech.gestaoquarto.data.models;

import br.com.fiap.postech.gestaoquarto.domain.entities.Quarto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "quarto")
@Table(name = "quarto")
@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class QuartoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "predio_id")
    private PredioModel predioModel;
    private int totalPessoas;
    private int totalCamasQueenSize;
    private int totalCamasKingSize;
    private int totalCamasSolteiro;
    @ElementCollection
    @CollectionTable(name = "outros_imoveis", joinColumns = @JoinColumn(name = "quarto_id"))
    @Column(name = "outro_imovel")
    protected List<String> outrosMoveis;
    protected BigDecimal valorDiaria;

    public QuartoModel toQuartoModel(Quarto quarto) {
        QuartoModel quartoModel = new QuartoModel();
        quartoModel.setId(quarto.getId());
        quartoModel.setPredioModel(new PredioModel());
        quartoModel.setTotalPessoas(quarto.getTotalPessoas());
        quartoModel.setTotalCamasKingSize(quarto.getTotalCamasKingSize());
        quartoModel.setTotalCamasQueenSize(quarto.getTotalCamasQueenSize());
        quartoModel.setTotalCamasSolteiro(quarto.getTotalCamasSolteiro());
        quartoModel.setOutrosMoveis(quarto.getOutrosMoveis());
        quartoModel.setValorDiaria(quarto.getValorDiaria());
        return  quartoModel;
    }
}
