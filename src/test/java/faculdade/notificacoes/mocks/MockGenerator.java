package faculdade.notificacoes.mocks;


import faculdade.notificacoes.controller.mapper.dto.eventIn.MensagemEventoDeFalha;
import faculdade.notificacoes.entity.Notificacao;

import java.time.LocalDateTime;
import java.util.UUID;

public class MockGenerator {

    public static Notificacao gerarNotificacao() {
        return new Notificacao(
                UUID.randomUUID().toString(),
                "Maria Garcia",
                UUID.randomUUID().toString(),
                "maria03garcia@gmail.com",
                LocalDateTime.now().toString()
        );
    }

    public static MensagemEventoDeFalha gerarMensagemEventoFalha() {
        return new MensagemEventoDeFalha(
                UUID.randomUUID().toString(),
                "Maria Garcia",
                UUID.randomUUID().toString(),
                "maria03garcia@gmail.com",
                LocalDateTime.now().toString()
        );
    }

}
