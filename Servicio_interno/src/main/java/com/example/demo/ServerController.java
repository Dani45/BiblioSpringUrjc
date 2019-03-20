package com.example.demo;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ServerController {

    @Autowired
	private JavaMailSender javaMailSender;

    private final String usrname = "bibliospringurjc@gmail.com";
	@PostMapping(value="/mail/")
	public ResponseEntity<Boolean> sendMail(@RequestBody Email mail) {
		String name = mail.getUserName();
		String email = mail.getUserMail();
		
		System.out.println("Datos correctamente recibidos!");
		System.out.println("Message received from web : " + mail);
		try {
			// Get a Properties object
			

		        MimeMessage message = javaMailSender.createMimeMessage();
				MimeMessageHelper helper;
				
				helper = new MimeMessageHelper(message,true);
				
				message.setFrom(new InternetAddress(usrname));
				helper.setTo(email); //Indicamos donde se dirige el email (TO)
				helper.setSubject("Welcome to our web");
				helper.setText("Su cuenta se ha realizado con exito para el correo " + email + " podra acceder a nuestros servicios de compra con el usuario y contraseña que haya metido, que lo disfrute " +name+ "!");
				
				javaMailSender.send(message);
			System.out.println("correo enviado con exito");
		} catch (MessagingException e) {
			 System.out.println("e="+e);
	            e.printStackTrace();
	            throw new RuntimeException(e);
		}
		// se notifica el correcto envío
		return new ResponseEntity <Boolean> (true, HttpStatus.OK);
	}

}
