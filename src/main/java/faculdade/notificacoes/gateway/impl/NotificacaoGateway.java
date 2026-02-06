package faculdade.notificacoes.gateway.impl;

import faculdade.notificacoes.controller.mapper.NotificacaoMapper;
import faculdade.notificacoes.entity.Notificacao;
import faculdade.notificacoes.gateway.INotificacaoGateway;
import faculdade.notificacoes.gateway.adapter.SnsAdapter;
import faculdade.notificacoes.gateway.persistence.INotificacaoRepository;

public class NotificacaoGateway implements INotificacaoGateway {
    private final INotificacaoRepository notificacaoRepository;
    private final SnsAdapter snsAdapter;

    public NotificacaoGateway(INotificacaoRepository notificacaoRepository, SnsAdapter snsAdapter) {
        this.notificacaoRepository = notificacaoRepository;
        this.snsAdapter = snsAdapter;
    }

    @Override
    public void salvarNotificacao(Notificacao notificacao) {
        notificacaoRepository.save(NotificacaoMapper.toEntity(notificacao));
    }

    @Override
    public void enviarMensagemParaSns(Notificacao notificacao) {
        snsAdapter.enviarNotificacao(notificacao.toString());
    }

    @Override
    public void removerNotificacao(String notificacaoId) {
        notificacaoRepository.remove(notificacaoId);
    }
}
