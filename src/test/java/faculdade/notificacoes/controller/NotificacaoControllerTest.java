package faculdade.notificacoes.controller;

import faculdade.notificacoes.controller.mapper.NotificacaoMapper;
import faculdade.notificacoes.controller.mapper.dto.eventIn.MensagemEventoDeFalha;
import faculdade.notificacoes.entity.Notificacao;
import faculdade.notificacoes.mocks.MockGenerator;
import faculdade.notificacoes.usecase.INotificacaoUseCase;
import faculdade.notificacoes.usecase.impl.NotificacaoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class NotificacaoControllerTest {

    private NotificacaoController notificacaoController;
    private INotificacaoUseCase notificacaoUseCase;

    @BeforeEach
    void setUp() {
        notificacaoUseCase = mock(NotificacaoUseCase.class);
        notificacaoController = new NotificacaoController(notificacaoUseCase);
    }


    @Test
    void deveProcessarMensagemComSucesso() {
        MensagemEventoDeFalha request = MockGenerator.gerarMensagemEventoFalha();
        Notificacao map = NotificacaoMapper.messageToModel(request);

        notificacaoController.gerenciarNotificacao(request);

        verify(notificacaoUseCase, times(1)).processarNotificacao(map);
    }
}
