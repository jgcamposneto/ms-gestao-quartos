package br.com.fiap.postech.app.gestaoquarto.data.models;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.*;
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
    @CollectionTable(name = "outros_moveis", joinColumns = @JoinColumn(name = "quarto_id"))
    @Column(name = "outro_movel")
    protected List<String> outrosMoveis;

    protected BigDecimal valorDiaria;

    private String tipoQuarto;

    public static QuartoModel toQuartoModel(QuartoEntity quartoEntity) {
        QuartoModel quartoModel = new QuartoModel();
        quartoModel.setId(quartoEntity.getId());
        quartoModel.setTotalPessoas(quartoEntity.getTotalPessoas());
        quartoModel.setTotalCamasKingSize(quartoEntity.getTotalCamasKingSize());
        quartoModel.setTotalCamasQueenSize(quartoEntity.getTotalCamasQueenSize());
        quartoModel.setTotalCamasSolteiro(quartoEntity.getTotalCamasSolteiro());
        quartoModel.setOutrosMoveis(quartoEntity.getOutrosMoveis());
        quartoModel.setValorDiaria(quartoEntity.getValorDiaria());
        quartoModel.setTipoQuarto(quartoEntity.getTipoQuarto());
        return quartoModel;
    }

    public static QuartoEntity toQuartoEntity(QuartoModel quartoModel) {
        PredioEntity predioEntity = new PredioEntity();
        predioEntity.setId(quartoModel.getPredioModel().getId());
        predioEntity.setLocalizacao(quartoModel.getPredioModel().getLocalizacao());

        if (quartoModel.getTipoQuarto().equals("STANDARD_SIMPLES")) {
            return new QuartoStandardSimplesEntityFactory().create(predioEntity);
        } else if (quartoModel.getTipoQuarto().equals("STANDARD_DUPLO")) {
            return new QuartoStandardDuploEntityFactory().create(predioEntity);
        } else if (quartoModel.getTipoQuarto().equals("LUXO_SIMPLES")) {
            return new QuartoLuxoSimplesEntityFactory().create(predioEntity);
        } else if (quartoModel.getTipoQuarto().equals("LUXO_DUPLO")) {
            return new QuartoLuxoDuploEntityFactory().create(predioEntity);
        } else if (quartoModel.getTipoQuarto().equals("PREMIUM_SIMPLES")) {
            return new QuartoPremiumSimplesEntityFactory().create(predioEntity);
        } else if (quartoModel.getTipoQuarto().equals("PREMIUM_DUPLO")) {
            return new QuartoPremiumDuploEntityFactory().create(predioEntity);
        } else {
            throw new IllegalArgumentException("Tipo de quarto não reconhecido: " + quartoModel.getTipoQuarto());
        }
    }

}
