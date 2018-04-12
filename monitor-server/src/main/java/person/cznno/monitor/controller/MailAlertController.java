package person.cznno.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import person.cznno.monitor.service.MailAlertService;

import javax.mail.MessagingException;

/**
 * Created by cznno
 * Date: 18-2-26
 */
@RestController
public class MailAlertController {

    private final MailAlertService mailAlertService;

    @Autowired
    public MailAlertController(MailAlertService mailAlertService) {this.mailAlertService = mailAlertService;}

    @PostMapping("/alertMail")
    @Async
    public void foo(@RequestBody String errorCode) throws MessagingException {
        System.out.println("发送邮件");
        mailAlertService.foo(errorCode);
    }
}
