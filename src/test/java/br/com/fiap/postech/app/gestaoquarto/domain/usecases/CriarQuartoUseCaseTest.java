package br.com.fiap.postech.app.gestaoquarto.domain.usecases;

import br.com.fiap.postech.app.gestaoquarto.domain.entities.PredioEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.QuartoEntity;
import br.com.fiap.postech.app.gestaoquarto.domain.entities.QuartoLuxoDuploEntityFactory;
import br.com.fiap.postech.app.gestaoquarto.domain.repositories.QuartoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CriarQuartoUseCaseTest {

    private CriarQuartoUseCase criarQuartoUseCase;
    private QuartoRepository quartoRepository;
    private ConsultarPredioUseCase consultarPredioUseCase;

    @BeforeEach
    public void setUp() {
        quartoRepository = mock(QuartoRepository.class);
        consultarPredioUseCase = mock(ConsultarPredioUseCase.class);
        criarQuartoUseCase = new CriarQuartoUseCase(quartoRepository, consultarPredioUseCase);
    }

    @Test
    public void testDeveCriarQuarto() {
        PredioEntity predioEntity = new PredioEntity();
        predioEntity.setId(1L);
        QuartoEntity quartoEntity = new QuartoLuxoDuploEntityFactory().create(predioEntity);


        // Configurando o comportamento esperado dos mocks
        when(consultarPredioUseCase.call(1L)).thenReturn(predioEntity);
        when(quartoRepository.criarQuarto(quartoEntity)).thenReturn(quartoEntity);

        // Executando o método que será testado
        QuartoEntity result = criarQuartoUseCase.call(quartoEntity);

        // Verificando se os métodos dos mocks foram chamados corretamente
        verify(consultarPredioUseCase, times(1)).call(1L);
        verify(quartoRepository, times(1)).criarQuarto(quartoEntity);

        // Verificando se o resultado retornado é o esperado
        Assertions.assertEquals(quartoEntity, result);
    }

    @Test
    public void testNaoDeveCriarQuarto_QuandoPredioNaoCadastrado() {
        PredioEntity predioEntity = null;
        QuartoEntity quartoEntity = new QuartoLuxoDuploEntityFactory().create(predioEntity);

        // Configurando o comportamento esperado do mock de ConsultarPredioUseCase
        when(consultarPredioUseCase.call(anyLong())).thenReturn(null);

        // Executando o método que será testado e verificando se uma exceção é lançada
        Assertions.assertThrows(RuntimeException.class, () -> {
            criarQuartoUseCase.call(quartoEntity);
            // Verificando se o método de ConsultarPredioUseCase foi chamado corretamente
            verify(consultarPredioUseCase, times(1)).call(anyLong());

            // Verificando se o método de criarQuarto não foi chamado
            verify(quartoRepository, never()).criarQuarto(quartoEntity);
        });
    }
}
