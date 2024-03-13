package br.com.fiap.postech.gestaoquarto.domain.entities;

import java.math.BigDecimal;
import java.util.List;

public interface Quarto {

    Long getId();
    Predio getPredio();
    int getTotalPessoas();
    int getTotalCamasQueenSize();
    int getTotalCamasKingSize();
    int getTotalCamasSolteiro();
    List<String> getOutrosMoveis();
    BigDecimal getValorDiaria();

}
