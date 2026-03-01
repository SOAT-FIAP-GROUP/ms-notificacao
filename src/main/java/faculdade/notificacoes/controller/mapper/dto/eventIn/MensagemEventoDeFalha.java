package faculdade.notificacoes.controller.mapper.dto.eventIn;

public record MensagemEventoDeFalha(
         String processamentoId,

         String username,

         String userId,

         String email,

         String dataNotificacao
) {
}
