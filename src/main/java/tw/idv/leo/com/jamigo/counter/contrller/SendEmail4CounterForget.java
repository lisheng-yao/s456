package tw.idv.leo.com.jamigo.counter.contrller;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import tw.idv.leo.com.jamigo.counter.model.Counter;

@Component
public class SendEmail4CounterForget {

	public void sendMail(Counter counter) {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");

			final String myGmail = "jamigo.contact@gmail.com";
			final String myGmail_password = "xtnmxghelweuykcs";
			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myGmail, myGmail_password);
				}
			});

			String pw = counter.getCounterPassword();
			String email = counter.getCounterEmail();

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myGmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Jamigo櫃位忘記密碼");// 標題
			message.setText("這是您的密碼 ：" + pw );// 內容

			Transport.send(message);
//			mailSender.send(message);
			System.out.println("傳送成功!");
		} catch (MessagingException e) {
			System.out.println("傳送失敗!");
			e.printStackTrace();
		}
	}
}
