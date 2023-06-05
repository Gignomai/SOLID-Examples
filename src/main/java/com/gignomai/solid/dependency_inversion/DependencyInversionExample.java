package com.gignomai.solid.dependency_inversion;


class SmtpClient {
    void sendEmail(String from, String to, String subject, String text) {
        System.out.printf("Send SMTP email\n from: %s\n to: %s\n subject: %s\n text: %s\n", from, to, subject, text);
    }
}

class EmailService {
    SmtpClient smtpClient = new SmtpClient();

    public void send(String from, String to, String subject, String text) {
        smtpClient.sendEmail(from, to, subject, text);
    }
}


interface MailClient {
    void sendEmail(String from, String to, String subject, String text);
}

class ImapMailClient implements MailClient {
    @Override
    public void sendEmail(String from, String to, String subject, String text) {
        System.out.printf("Send IMAP email\n from: %s\n to: %s\n subject: %s\n text: %s\n", from, to, subject, text);
    }
}

class EmailNotification {

    MailClient mailClient;

    public EmailNotification(MailClient mailClient) {
        this.mailClient = mailClient;
    }

    public void send(String from, String to, String subject, String text) {
        mailClient.sendEmail(from, to, subject, text);
    }
}

public class DependencyInversionExample {

    // Depend upon abstractions, not concretions
    // High-level modules should not depend on low-level modules. Both should depend on abstractions.
    // Abstractions should not depend on details. Details should depend on abstractions
    public static void main(String[] args) {
        //Coupled non-compliant version, EmailService knows too much about SmtpClient
        EmailService emailService = new EmailService();
        emailService.send("me", "you", "this", "is the content");

        //Compliant version with dependencies inverted
        EmailNotification emailNotification = new EmailNotification(new ImapMailClient());
        emailNotification.send("me", "you", "this", "is the content");
    }
}
