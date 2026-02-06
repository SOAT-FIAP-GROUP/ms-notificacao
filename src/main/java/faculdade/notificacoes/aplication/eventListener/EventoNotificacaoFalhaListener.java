package faculdade.notificacoes.aplication.eventListener;


import faculdade.notificacoes.controller.NotificacaoController;
import faculdade.notificacoes.controller.mapper.dto.eventIn.MensagemEventoDeFalha;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EventoNotificacaoFalhaListener {

    private final NotificacaoController notificacaoController;
    private static final Logger logger = LoggerFactory.getLogger(EventoNotificacaoFalhaListener.class);

    public EventoNotificacaoFalhaListener(NotificacaoController notificacaoController) {
        this.notificacaoController = notificacaoController;
    }

    @SqsListener("${events.queues.sqs-notificar-falha}")
    public void receberNotificacaoDeFalha(MensagemEventoDeFalha mensagem) {
        logger.info("Mensagem recebida: {}", mensagem);
        notificacaoController.gerenciarNotificacao(mensagem);
    }
}