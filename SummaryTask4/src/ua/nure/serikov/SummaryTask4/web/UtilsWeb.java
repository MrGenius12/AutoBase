package ua.nure.serikov.SummaryTask4.web;

import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Properties;

/**
 *AutoBase
 *
 * @author Serikov Eugene
 */
public class UtilsWeb {

    private static final Logger LOG = Logger.getLogger(UtilsWeb.class);
    private static final String USERNAME = "autobase2018@gmail.com";
    private static final String PASSWORD = "autobase";
    public static final String SUBJECT_NEW_TRIP = "New trip in system";

    public static void removeUnwantedAttributeOkMessageFromSession(HttpSession session, HttpServletRequest request) {
        request.setAttribute("okMessage", session.getAttribute("okMessage"));
        session.removeAttribute("okMessage");
        LOG.trace("remove Unwanted Attribute OkMessage From Session");
    }

    public static void sendMail(String message, String subject, List<String> emails) {

        Message msg = new MimeMessage(getSession());

        for (String mail : emails) {
            try {            	
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));                
                msg.setSubject(subject);                
                msg.setText(message);                
                Transport.send(msg);               
            } catch (MessagingException e) {            	
                LOG.error("Mail not send from: " + mail);
            }
        }
    }

    private static Session getSession() {
        Session session = Session.getDefaultInstance(getProperties(), new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
        return session;
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");//587
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");//587
        return properties;
    }
}
