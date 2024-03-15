package br.com.fiap.postech.app.gestaoquarto.domain.entities;

import java.math.BigDecimal;
import java.util.List;

public class QuartoLuxoSimplesEntity extends QuartoPadraoEntity {

    private static final int TOTAL_PESSOAS = 2;
    private static final int TOTAL_CAMAS_QUEEN_SIZE = 0;
    private static final int TOTAL_CAMAS_KING_SIZE = 1;
    private static final int TOTAL_CAMAS_SOLTEIRO = 0;
    private static final BigDecimal VALOR_DIARIA = new BigDecimal("550.00");
    private static final List<String> OUTROS_MOVEIS =
            List.of("1 x Sofá",
                    "1 x Poltronas",
                    "1 x Frigobar",
                    "1 x TV Led 54 pols.",
                    "1 x Mesa de Escritório",
                    "1 x Cadeira de Escritório");

    protected QuartoLuxoSimplesEntity(PredioEntity predioEntity) {
        super(predioEntity);
        super.totalPessoas = TOTAL_PESSOAS;
        super.totalCamasQueenSize = TOTAL_CAMAS_QUEEN_SIZE;
        super.totalCamasKingSize = TOTAL_CAMAS_KING_SIZE;
        super.totalCamasSolteiro = TOTAL_CAMAS_SOLTEIRO;
        super.valorDiaria = VALOR_DIARIA;
        super.tipoQuarto = "LUXO_SIMPLES";
        super.outrosMoveis = OUTROS_MOVEIS;
    }
}
