/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Util;

import FunctionLayer.User;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.ByteArrayDataSource;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 *
 * @author mwn
 */
public class Mail {

    private final String HOST_NAME = "smtp.googlemail.com";
    private final int SMTP_PORT = 465;
    private final String SENDER_EMAIL = "mcmfog@gmail.com";
    private final String SENDER_PASS = "Fog123456";

    private User user;
    private byte[] pdf;

    public Mail(User user, byte[] pdf) {
        this.user = user;
        this.pdf = pdf;
    }

    public void sendEmailWithAttachtment() throws EmailException {
        try {
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName(HOST_NAME);
            email.setSmtpPort(SMTP_PORT);
            email.setAuthenticator(new DefaultAuthenticator(SENDER_EMAIL, SENDER_PASS));
            email.setSSLOnConnect(true);
            email.addTo(user.getEmail(), user.getName());
            email.setFrom(SENDER_EMAIL, "MCM FogSemesterProjekt");
            email.setSubject("Carport stykliste");
            email.setMsg("Her er en pdf, hvor du kan se din bestilte carport");
            email.attach(new ByteArrayDataSource(pdf, "application/pdf"), "stykliste.pdf", "Description of some file");
            email.send();
        } catch (IOException ex) {
            throw new EmailException("Failed to send Email: " + ex);
        }
    }
}
