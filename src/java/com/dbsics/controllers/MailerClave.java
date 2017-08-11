/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.faces.context.FacesContext;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailerClave {
    //metodo para enviar email

    public static void send(String para, String sujeto, String mensaje) throws UnsupportedEncodingException {
        String ruta;
        //clave real de acceso a la cuenta que va a enviar el email 
        final String user = "ivduque@gmail.com";//cambiará en consecuencia al servidor utilizado
        final String pass = "davinci77";

//1st paso) Obtener el objeto de sesión
// propiedades de conexion con el servidor smtp(servidor de correo) 
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com"); // envia 
        props.setProperty("mail.smtp.starttls.enable", "true");//starttls es un protocolo de comunicacion segura(cifra los datos enviados)
        props.setProperty("mail.smtp.port", "25");//587- 443
        props.setProperty("mail.smtp.starttls.required", "false");
        props.setProperty("mail.smtp.auth", "true");//
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

//2nd paso)compose message
        try {
//     ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//sicspage//resources//imgs//logo.jpg");  
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource("c:/img/logo.jpg")));
            adjunto.setFileName("logo.jpg");

            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);
            MimeMultipart multiparte = new MimeMultipart();
            multiparte.addBodyPart(texto);
            multiparte.addBodyPart(adjunto);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user, "Recuperación credenciales SICS"));
            InternetAddress[] destinatarios = {
                new InternetAddress(para),
                new InternetAddress("ivduque@gmail.com"),};

            message.setRecipients(Message.RecipientType.TO, destinatarios);
            message.setSubject(sujeto);
            message.setContent(multiparte, "text/html; charset=utf-8");

            //3rd paso)send message
            Transport.send(message);

            System.out.println("Terminado : Correo enviado satisfactoriamente");

        } catch (MessagingException e) {
            System.out.println("error al envir email:" + e);
            throw new RuntimeException(e);
        }

    }
}
