package br.com.fiap.postech.gestaoquarto.data.datasources;

import br.com.fiap.postech.gestaoquarto.domain.entities.QuartoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaQuartoRepository extends JpaRepository<QuartoModel, Long> {
}
