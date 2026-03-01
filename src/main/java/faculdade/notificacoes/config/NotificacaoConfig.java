package faculdade.notificacoes.config;

import faculdade.notificacoes.aplication.eventListener.EventoNotificacaoFalhaListener;
import faculdade.notificacoes.controller.NotificacaoController;
import faculdade.notificacoes.gateway.INotificacaoGateway;
import faculdade.notificacoes.gateway.impl.NotificacaoGateway;
import faculdade.notificacoes.gateway.impl.NotificacaoRepository;
import faculdade.notificacoes.gateway.persistence.INotificacaoRepository;
import faculdade.notificacoes.usecase.INotificacaoUseCase;
import faculdade.notificacoes.usecase.impl.NotificacaoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;

@Configuration
public class NotificacaoConfig {

    @Bean
    EventoNotificacaoFalhaListener eventoNotificacaoFalhaListener(NotificacaoController notificacaoController) {
        return new EventoNotificacaoFalhaListener(notificacaoController);
    }

    @Bean
    NotificacaoController notificacaoController(INotificacaoUseCase notificacaoUseCase) {
        return new NotificacaoController(notificacaoUseCase);
    }

    @Bean
    NotificacaoUseCase notificacaoUseCase(INotificacaoGateway notificacaoGateway) {
        return new NotificacaoUseCase(notificacaoGateway);
    }

    @Bean
    NotificacaoGateway notificacaoGateway(INotificacaoRepository notificacaoRepository, MailSender mailSender, SimpleMailMessage simpleMailMessage) {
        return new NotificacaoGateway(
                notificacaoRepository,
                mailSender,
                simpleMailMessage);
    }

    @Bean
    NotificacaoRepository notificacaoRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        return new NotificacaoRepository(dynamoDbEnhancedClient);
    }
}
