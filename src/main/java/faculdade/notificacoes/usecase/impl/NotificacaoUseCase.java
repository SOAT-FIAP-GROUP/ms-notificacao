package faculdade.notificacoes.usecase.impl;

import faculdade.notificacoes.entity.Notificacao;
import faculdade.notificacoes.entity.enums.SagaSteps;
import faculdade.notificacoes.gateway.INotificacaoGateway;
import faculdade.notificacoes.usecase.INotificacaoUseCase;

public class NotificacaoUseCase implements INotificacaoUseCase {
    private final INotificacaoGateway notificacaoGateway;

    public NotificacaoUseCase(INotificacaoGateway notificacaoGateway) {
        this.notificacaoGateway = notificacaoGateway;
    }

    @Override
    public void processarNotificacao(Notificacao notificacao) {
        SagaSteps step = null;
        try {
            notificacaoGateway.salvarNotificacao(notificacao);
            step = SagaSteps.NOTIFICACAO_SALVA;
            notificacaoGateway.enviarEmail(notificacao);
        }
        catch (Exception e){
            reverterSagaNotificacao(step, notificacao);
        }
    }

    private void reverterSagaNotificacao(SagaSteps step, Notificacao notificacao){
        if (step == SagaSteps.NOTIFICACAO_SALVA) {
            notificacaoGateway.removerNotificacao(notificacao.id());
        }
    }
}
