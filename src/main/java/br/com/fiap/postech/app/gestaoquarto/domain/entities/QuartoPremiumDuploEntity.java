package br.com.fiap.postech.app.gestaoquarto.domain.entities;

import java.math.BigDecimal;

public class QuartoPremiumDuploEntity extends QuartoPadraoEntity {

    private static final int TOTAL_PESSOAS = 4;
    private static final int TOTAL_CAMAS_QUEEN_SIZE = 0;
    private static final int TOTAL_CAMAS_KING_SIZE = 2;
    private static final int TOTAL_CAMAS_SOLTEIRO = 0;
    private static final BigDecimal VALOR_DIARIA = new BigDecimal("950.00");

    protected QuartoPremiumDuploEntity(PredioEntity predioEntity) {
        super(predioEntity);
        super.totalPessoas = TOTAL_PESSOAS;
        super.totalCamasQueenSize = TOTAL_CAMAS_QUEEN_SIZE;
        super.totalCamasKingSize = TOTAL_CAMAS_KING_SIZE;
        super.totalCamasSolteiro = TOTAL_CAMAS_SOLTEIRO;
        super.valorDiaria = VALOR_DIARIA;
    }
}
