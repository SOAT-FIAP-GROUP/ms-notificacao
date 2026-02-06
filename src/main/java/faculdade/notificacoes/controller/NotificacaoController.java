package faculdade.notificacoes.controller;

import faculdade.notificacoes.controller.mapper.NotificacaoMapper;
import faculdade.notificacoes.controller.mapper.dto.eventIn.MensagemEventoDeFalha;
import faculdade.notificacoes.usecase.INotificacaoUseCase;

public class NotificacaoController {
    private final INotificacaoUseCase notificacaoUseCase;

    public NotificacaoController(INotificacaoUseCase notificacaoUseCase) {
        this.notificacaoUseCase = notificacaoUseCase;
    }

    public void gerenciarNotificacao(MensagemEventoDeFalha mensagem){
        notificacaoUseCase.processarNotificacao(NotificacaoMapper.messageToModel(mensagem));
    }
}
