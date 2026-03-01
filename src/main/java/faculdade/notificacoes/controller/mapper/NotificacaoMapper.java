package faculdade.notificacoes.controller.mapper;

import faculdade.notificacoes.controller.mapper.dto.eventIn.MensagemEventoDeFalha;
import faculdade.notificacoes.entity.Notificacao;
import faculdade.notificacoes.gateway.entity.NotificacaoEntity;

public class NotificacaoMapper {
    public static Notificacao messageToModel(MensagemEventoDeFalha mensagem) {
        return new Notificacao(
                mensagem.processamentoId(),
                mensagem.username(),
                mensagem.userId(),
                mensagem.email(),
                mensagem.dataNotificacao()
        );
    }

    public static NotificacaoEntity toEntity(Notificacao notificacao) {
        return new NotificacaoEntity(
                notificacao.id(),
                notificacao.usuarioId(),
                notificacao.email(),
                notificacao.dataNotificacao()
        );
    }
}
