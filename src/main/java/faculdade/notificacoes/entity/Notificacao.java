package faculdade.notificacoes.entity;

public record Notificacao(
         String id,

         String nomeUsuario,

         String usuarioId,

         String email,

         String dataNotificacao
) {
}
