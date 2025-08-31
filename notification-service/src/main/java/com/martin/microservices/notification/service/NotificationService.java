package com.martin.microservices.notification.service;

import com.martin.microservices.order.event.OrderPlacedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

// PASO 40
@Service
@RequiredArgsConstructor
@Slf4j // permiter el uso de log.info, log.error, etc.
public class NotificationService {

    // Responsable de enviar emails
    private final JavaMailSender javaMailSender;

    @KafkaListener(topics = "order-placed")
    public void listen(OrderPlacedEvent orderPlacedEvent){
        log.info("Received message for order-placed topic: {}", orderPlacedEvent);

        String firstName = orderPlacedEvent.getFirstName() != null ? orderPlacedEvent.getFirstName().toString() : "";
        String lastName = orderPlacedEvent.getLastName() != null ? orderPlacedEvent.toString() : "";
        String email = orderPlacedEvent.getEmail() != null ? orderPlacedEvent.getEmail().toString() : "";


        // Formamos el MAIL
        MimeMessagePreparator messagePreparator = mimeMessage -> { // creamos un objeto de tipo MimeMessagePreparator
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage); // estructura de mail
            messageHelper.setFrom("springshop@email.com");
            messageHelper.setTo(orderPlacedEvent.getEmail().toString());
            messageHelper.setSubject(String.format("Your Order with OrderNumber %s is placed successfully", orderPlacedEvent.getOrderNumber()));
            messageHelper.setText(String.format("""
                            Hi %s,%s

                            Your order with order number %s is now placed successfully.
                            
                            Best Regards
                            Spring Shop
                            """,
                    firstName,lastName,email));
        };
        try {
            javaMailSender.send(messagePreparator); // tratamos de enviar el mail
            log.info("Order Notifcation email sent!!");
        } catch (MailException e) {
            log.error("Exception occurred when sending mail", e);
            throw new RuntimeException("Exception occurred when sending mail to springshop@email.com", e);
        }
    }
}

