package faculdade.notificacoes.usecase;

import faculdade.notificacoes.entity.Notificacao;
import faculdade.notificacoes.gateway.INotificacaoGateway;
import faculdade.notificacoes.mocks.MockGenerator;
import faculdade.notificacoes.usecase.impl.NotificacaoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mail.MailAuthenticationException;

import static org.mockito.Mockito.*;

public class NotificacaoUseCaseTest {

    private INotificacaoGateway gateway;
    private NotificacaoUseCase notificacaoUseCase;

    @BeforeEach
    void setup() {
        gateway = mock(INotificacaoGateway.class);
        notificacaoUseCase = new NotificacaoUseCase(gateway);
    }

    @Test
    void deveProcessarNotificacaoCorretamente() {
        Notificacao request = MockGenerator.gerarNotificacao();

        notificacaoUseCase.processarNotificacao(request);

        verify(gateway, times(1)).salvarNotificacao(request);
        verify(gateway, times(1)).enviarEmail(request);
        verify(gateway, times(0)).removerNotificacao(request.id());
    }

    @Test
    void deveReverterSagaNotificacao() {

        Notificacao request = MockGenerator.gerarNotificacao();

        doThrow(MailAuthenticationException.class).when(gateway).enviarEmail(request);

        notificacaoUseCase.processarNotificacao(request);

        verify(gateway).removerNotificacao(request.id());
    }
}
