package faculdade.notificacoes.gateway;

import faculdade.notificacoes.entity.Notificacao;

public interface INotificacaoGateway {
    void salvarNotificacao(Notificacao notificacao);
    void enviarEmail(Notificacao notificacao);
    void removerNotificacao(String notificacaoId);
}
