package br.com.fiap.postech.app.gestaoquarto.domain.entities;

import java.math.BigDecimal;
import java.util.List;

public interface QuartoEntity {

    Long getId();
    PredioEntity getPredio();
    int getTotalPessoas();
    int getTotalCamasQueenSize();
    int getTotalCamasKingSize();
    int getTotalCamasSolteiro();
    List<String> getOutrosMoveis();
    BigDecimal getValorDiaria();
    void setPredio(PredioEntity predioEntity);
    String getTipoQuarto();
    void setId(Long id);
}
