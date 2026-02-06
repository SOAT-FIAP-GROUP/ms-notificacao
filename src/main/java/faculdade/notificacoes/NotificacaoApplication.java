package faculdade.notificacoes;

import faculdade.notificacoes.gateway.entity.EventQueuesProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(EventQueuesProperties.class)
public class NotificacaoApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificacaoApplication.class, args);
    }
}
