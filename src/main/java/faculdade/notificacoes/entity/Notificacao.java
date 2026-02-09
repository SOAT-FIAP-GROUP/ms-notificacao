package faculdade.notificacoes.entity;

public record Notificacao(
         String id,

         String usuarioId,

         String email,

         String dataNotificacao
) {
}
