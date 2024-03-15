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

        return switch (quartoModel.getTipoQuarto()) {
            case "STANDARD_SIMPLES" -> new QuartoStandardSimplesEntityFactory().create(predioEntity, quartoModel.getId());
            case "STANDARD_DUPLO" -> new QuartoStandardDuploEntityFactory().create(predioEntity, quartoModel.getId());
            case "LUXO_SIMPLES" -> new QuartoLuxoSimplesEntityFactory().create(predioEntity, quartoModel.getId());
            case "LUXO_DUPLO" -> new QuartoLuxoDuploEntityFactory().create(predioEntity, quartoModel.getId());
            case "PREMIUM_SIMPLES" -> new QuartoPremiumSimplesEntityFactory().create(predioEntity, quartoModel.getId());
            case "PREMIUM_DUPLO" -> new QuartoPremiumDuploEntityFactory().create(predioEntity, quartoModel.getId());
            default ->
                    throw new IllegalArgumentException("Tipo de quarto não reconhecido: " + quartoModel.getTipoQuarto());
        };
    }

}
