package faculdade.notificacoes.gateway;

import faculdade.notificacoes.entity.Notificacao;
import faculdade.notificacoes.gateway.entity.NotificacaoEntity;

public interface INotificacaoGateway {
    void salvarNotificacao(Notificacao notificacao);
    void enviarMensagemParaSns(Notificacao notificacao);
    void removerNotificacao(String notificacaoId);
}
