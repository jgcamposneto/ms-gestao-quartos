package br.com.fiap.postech.app.gestaoquarto.data.datasources;

import br.com.fiap.postech.app.gestaoquarto.data.models.PredioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPredioRepository extends JpaRepository<PredioModel, Long> {


}
