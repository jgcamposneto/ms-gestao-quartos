package br.com.fiap.postech.app.core.configurations;

import br.com.fiap.postech.app.gestaoquarto.data.datasources.JpaPredioRepository;
import br.com.fiap.postech.app.gestaoquarto.data.models.PredioModel;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    final JpaPredioRepository jpaPredioRepository;

    public DataLoader(JpaPredioRepository jpaPredioRepository) {
        this.jpaPredioRepository = jpaPredioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        PredioModel predioModel1 = new PredioModel();
        predioModel1.setLocalizacao("Centro");
        predioModel1.setLocalizacao("Periferia");
        predioModel1.setLocalizacao("Orla");
        jpaPredioRepository.save(predioModel1);
    }
}
