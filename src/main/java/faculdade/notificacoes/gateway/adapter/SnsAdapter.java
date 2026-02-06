package faculdade.notificacoes.gateway.adapter;

import faculdade.notificacoes.aplication.eventListener.EventoNotificacaoFalhaListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@Service
public class SnsAdapter {
    @Value("${sns.arn}")
    String topicArn;

    private static final Logger logger = LoggerFactory.getLogger(EventoNotificacaoFalhaListener.class);

    private final SnsClient snsClient;

    public SnsAdapter(SnsClient snsClient) {
        this.snsClient = snsClient;
    }

    public void enviarNotificacao(String mensagem) {
        PublishRequest request = PublishRequest.builder()
                .topicArn(topicArn)
                .message(mensagem)
                .build();

        PublishResponse response = snsClient.publish(request);
        logger.info("Mensagem enviada ao SNS: {}", mensagem);

    }
}

