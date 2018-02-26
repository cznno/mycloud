package person.cznno.monitor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;

/**
 * Created by cznno
 * Date: 18-2-26
 */
@Service
@Slf4j
public class MailAlertService {

    private final JavaMailSender mailSender;

    @Value("${config.mail.sendfrom}")
    private String sendFrom;
    @Value("${ops.mail}")
    private String[] sendTo;

    @Autowired
    public MailAlertService(JavaMailSender mailSender) {this.mailSender = mailSender;}

    public String foo(String errorCode) throws MessagingException {
        log.info("send alert mail to ops: ");
        Arrays.stream(sendTo).forEach(log::info);
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(sendFrom);
        helper.setTo(sendTo);
        helper.setSubject("服务错误告警");
        helper.setText(errorCode);

        mailSender.send(mimeMessage);
        return ("发送完了");
    }
}
