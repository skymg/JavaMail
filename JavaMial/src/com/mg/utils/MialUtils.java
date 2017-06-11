package com.mg.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 邮件发送工具类
 * 
 * @author sky_mg 2017年6月11日下午1:28:42 TODO
 */
public class MialUtils {
	/**
	 * 发送邮件的方法
	 * 
	 * @param to:给谁发送邮件
	 * @param code:邮件激活码
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public static void sendMail(String to, String code) throws AddressException, MessagingException {
		// 1.创建邮件连接服务器
		Properties properties = new Properties();
		//properties.setProperty("host", value);
		
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				//发送邮件的服务器 用户名和密码
				return new PasswordAuthentication("service@store.com", "123");
			}
		
		});
		// 2.创建邮件对象
		Message message = new MimeMessage(session);
		//2.1 设置发件人
		message.setFrom(new InternetAddress("service@store.com"));
		//2.2设置收件人
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		//2.3设置邮件主题
		message.setSubject("来自store网站的激活邮件");
		//2.4 设置邮件正文
		message.setContent("<h1>来自store网站的激活邮件,请点击连接激活:</h1><h3><a href='http://localhost:8080/JavaMial/ActiveServlet?code="+code+"'>http://localhost:8080/JavaMial/ActiveServlet?code="+code+"</a></h3>", "text/html;charset=UTF-8");
		// 3.发送一封激活邮件
		Transport.send(message);
	}
}
