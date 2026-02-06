package faculdade.notificacoes.gateway.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "events.queues")
public record EventQueuesProperties(
        String sqsNotificarFalha) {
}
