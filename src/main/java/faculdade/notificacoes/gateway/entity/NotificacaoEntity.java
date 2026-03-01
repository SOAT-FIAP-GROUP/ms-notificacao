package faculdade.notificacoes.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class NotificacaoEntity {

    private String id;

    private String usuarioId;

    private String email;

    private String dataNotificacao;

    @DynamoDbPartitionKey
    public String getId() {
        return this.id;
    }
}
