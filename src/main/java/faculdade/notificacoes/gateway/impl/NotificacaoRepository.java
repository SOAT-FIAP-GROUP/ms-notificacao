package faculdade.notificacoes.gateway.impl;

import faculdade.notificacoes.gateway.entity.NotificacaoEntity;
import faculdade.notificacoes.gateway.persistence.INotificacaoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.*;

@Repository
public class NotificacaoRepository implements INotificacaoRepository {
    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;
    private DynamoDbTable<NotificacaoEntity> notificacaoTable;

    public NotificacaoRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.dynamoDbEnhancedClient = dynamoDbEnhancedClient;
    }

    @PostConstruct
    public void init() {
        notificacaoTable = dynamoDbEnhancedClient.table("Notificacao", TableSchema.fromBean(NotificacaoEntity.class));
    }

    @Override
    public void save(NotificacaoEntity notificacao) {
        notificacaoTable.putItem(r -> r
                .item(notificacao)
                .conditionExpression(
                        Expression.builder()
                                .expression("attribute_not_exists(notificacaoId)")
                                .build()));
    }

    @Override
    public void remove(String notificacaoId) {
        notificacaoTable.deleteItem(Key.builder().
                partitionValue(notificacaoId
                ).build()
        );
    }
}
