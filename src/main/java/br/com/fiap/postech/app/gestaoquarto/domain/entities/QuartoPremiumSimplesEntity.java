package br.com.fiap.postech.app.gestaoquarto.domain.entities;

import java.math.BigDecimal;

public class QuartoPremiumSimplesEntity extends QuartoPadraoEntity {

    private static final int TOTAL_PESSOAS = 2;
    private static final int TOTAL_CAMAS_QUEEN_SIZE = 0;
    private static final int TOTAL_CAMAS_KING_SIZE = 1;
    private static final int TOTAL_CAMAS_SOLTEIRO = 0;
    private static final BigDecimal VALOR_DIARIA = new BigDecimal("850.00");

    protected QuartoPremiumSimplesEntity(PredioEntity predioEntity) {
        super(predioEntity);
        super.totalPessoas = TOTAL_PESSOAS;
        super.totalCamasQueenSize = TOTAL_CAMAS_QUEEN_SIZE;
        super.totalCamasKingSize = TOTAL_CAMAS_KING_SIZE;
        super.totalCamasSolteiro = TOTAL_CAMAS_SOLTEIRO;
        super.valorDiaria = VALOR_DIARIA;
    }
}
