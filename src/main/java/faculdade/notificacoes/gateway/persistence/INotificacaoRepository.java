package faculdade.notificacoes.gateway.persistence;

import faculdade.notificacoes.gateway.entity.NotificacaoEntity;

public interface INotificacaoRepository {
    void save(NotificacaoEntity notificacao);

    void remove(String notificacaoId);
}