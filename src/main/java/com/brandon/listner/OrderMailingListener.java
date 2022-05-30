package com.brandon.listner;

import com.brandon.dto.SendMailDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;


@Component
@RequiredArgsConstructor
public class OrderMailingListener {

    private final JavaMailSender mailSender;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "FOR_ORDER_COMPLETE_QUEUE")
    public void receiveOrderMailing(final String message) throws IOException {
        System.out.println(message);

        SendMailDto dto = objectMapper.readValue(message, SendMailDto.class);

        sendMail(dto.getEmailAddress(), dto.getSubject(), dto.getMessage());

    }

    @RabbitListener(queues = "FOR_ORDERED_COMPLETE_QUEUE")
    public void receiveOrderedMailing(final String message) throws IOException {
        System.out.println(message);

        SendMailDto dto = objectMapper.readValue(message, SendMailDto.class);

        sendMail(dto.getEmailAddress(), dto.getSubject(), dto.getMessage());


    }

    public void sendMail(String emailAddress,  String subject, String message ){
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo("dmdjqn21wb@naver.com");
            //simpleMailMessage.setTo(emailAddress);
            simpleMailMessage.setFrom("dmdjqn@gmail.com");
            simpleMailMessage.setText(message);
            simpleMailMessage.setSubject(subject);
            mailSender.send(simpleMailMessage);
        } catch (MailParseException e) {
            e.printStackTrace();
        } catch (MailAuthenticationException e) {
            e.printStackTrace();
        } catch (MailSendException e) {
            e.printStackTrace();
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
}
