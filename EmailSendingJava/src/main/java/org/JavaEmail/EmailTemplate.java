package org.JavaEmail;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailTemplate
{
    public static void main(String[] args)
    {
        try
        {
            String from = "nairanshul.9790@gmail.com";
            String toAddress = "anshulnair.9790@gmail.com";
            String messageType = "Java demo email send attempt success!";
            sendingMailWithoutAttachment(from,toAddress,messageType);
        }
        catch(MessagingException e)
        {
            e.printStackTrace();
        }

    }
    public static void sendingMailWithoutAttachment(String from,String toAddress,String messageBody) throws MessagingException
    {
        Properties properties = System.getProperties();
        /*
        // needing below prop to connect with email service provider
        //1 host name
        //2 port number
        //3 ssl layer
        //4 authentication
        */
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("nairanshul.9790@gmail.com",Constant.PASSWORD);
            }
        });

        //1.Compose the mail

        MimeMessage m = new MimeMessage(session);
        m.setFrom(from);
        m.addRecipients(Message.RecipientType.TO,toAddress);
        m.setSubject("Email Java send demo");
        m.setText(messageBody);

        //2.send mail

        Transport.send(m);

        System.out.println("Email sent successfully!");



    }


}