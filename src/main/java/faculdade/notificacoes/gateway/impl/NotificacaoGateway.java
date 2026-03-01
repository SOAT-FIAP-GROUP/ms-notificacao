package faculdade.notificacoes.gateway.impl;

import faculdade.notificacoes.controller.mapper.NotificacaoMapper;
import faculdade.notificacoes.entity.Notificacao;
import faculdade.notificacoes.gateway.INotificacaoGateway;
import faculdade.notificacoes.gateway.persistence.INotificacaoRepository;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


public class NotificacaoGateway implements INotificacaoGateway {
    private final INotificacaoRepository notificacaoRepository;
    private final MailSender mailSender;
    private final SimpleMailMessage templateMessage;

    public NotificacaoGateway(INotificacaoRepository notificacaoRepository, MailSender mailSender, SimpleMailMessage templateMessage) {
        this.notificacaoRepository = notificacaoRepository;
        this.mailSender = mailSender;
        this.templateMessage = templateMessage;
    }

    @Override
    public void salvarNotificacao(Notificacao notificacao) {
        notificacaoRepository.save(NotificacaoMapper.toEntity(notificacao));
    }

    @Override
    public void enviarEmail(Notificacao notificacao) {
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo(notificacao.email());
        msg.setText(notificacao.nomeUsuario()  + ",\n Ouve uma falha no processamento do vídeo");
        try {
            this.mailSender.send(msg);
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void removerNotificacao(String notificacaoId) {
        notificacaoRepository.remove(notificacaoId);
    }
}
