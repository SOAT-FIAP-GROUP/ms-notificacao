package faculdade.notificacoes.usecase;

import faculdade.notificacoes.entity.Notificacao;

public interface INotificacaoUseCase {
    void processarNotificacao(Notificacao notificacao);
}
