package faculdade.notificacoes.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;

@Configuration
public class SnsConfig {
    @Value("${aws.region}")
    private String region;

    @Value("${aws.sns.endpoint}")
    private String endpoint;

    @Bean
    public SnsClient snsClient() {
        var builder = SnsClient.builder()
                .region(Region.of(this.region))
                .credentialsProvider(DefaultCredentialsProvider.create());

        if (endpoint != null && !endpoint.isBlank()) {
            builder.endpointOverride(java.net.URI.create(endpoint));
        }

        return builder.build();
    }
}
