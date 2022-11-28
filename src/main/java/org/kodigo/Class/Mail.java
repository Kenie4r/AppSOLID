package org.kodigo.Class;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class Mail {
    @Getter @Setter
    private String port;
    @Getter @Setter
    private String host;
    @Getter @Setter
    private boolean enable;
    @Getter @Setter
    private boolean auth;

    @Getter @Setter
    private String user;
    @Getter @Setter
    private String pass;

    @Getter @Setter
    private String addressee;

    public Mail(Casa c){
        this.auth=true;
        this.host="smtp.titan.email";
        this.port="587";
        this.enable=true;
        this.user="TI@fhope.net";
        this.pass = "Tifhope2022$$";
        this.addressee=c.getPropietario().getMail();
    }



    public Session crearsesion(){
        Session session = Session.getInstance(crearPropiedades(),
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, pass);
                    }
                });

        return session;
    }

    public Properties crearPropiedades(){
        Properties props = new Properties();
        props.put("mail.smtp.auth", this.auth);
        props.put("mail.smtp.starttls.enable", this.enable);
        props.put("mail.smtp.host", this.host);
        props.put("mail.smtp.port", this.port);
        return props;
    }

    public void sendemail(String body) {


        try {
            Message message = new MimeMessage(crearsesion());
            message.setFrom(new InternetAddress(getUser()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(this.addressee));
            message.setSubject("Recibo");
            message.setContent(body, "text/html");
            Transport.send(message);


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
