package com.Fintech.CoPro.service;

import java.io.UnsupportedEncodingException;


import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Fintech.CoPro.domain.User;
import com.Fintech.CoPro.repository.UserRepository;

//import org.springframework.mail.javamail;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import net.bytebuddy.utility.RandomString;

@Service
public class VerficationService {

	@Autowired
	private UserRepository userRepo;
		
	//@Autowired
	//private PasswordEncoder passwordEncoder;
		
    @ Autowired
    private JavaMailSender mailSender;

	
	


	public void sendVerificationEmail(User user/*,String siteURL*/) 
    	throws UnsupportedEncodingException,MessagingException{
		    // TODO Auto-generated method stub
			 	String subject ="please verify your registeration";
				String senderName ="payteam";
				String mailContent="<p>Dear "+user.getUsername() + ",</p>";
				mailContent += "<p>please click the lin; below to verfy to your registeration: </p>";
				String verifyURL=/*siteURL +*/"http://localhost:1010/Co-Pro/SignUp/Verify?code="+user.getVerficationCode();
				mailContent += "<h3><a href=\""+verifyURL+"\">VERIFY</a></h3>";
				mailContent += "<p>Thank you<br>the pay team</p>";
				MimeMessage message =mailSender.createMimeMessage();
				MimeMessageHelper helper =new MimeMessageHelper(message);
				helper.setFrom("yy3161452@gmail.com",senderName);
				helper.setTo(user.getUsername());
				helper.setSubject(subject);
				helper.setText(mailContent, true);
				mailSender.send(message);
				userRepo.save(user);
	}
	public String verfiy(String Verfication_code) {
		User user;
		try {
			  user =userRepo.findByVerficationCode(Verfication_code);
			}
	   catch (Exception ex) {
			             return "can not verfication";///"Name not found"
			                }
		// when user enter incorrect verfication " hacker " :(
		if(user==null) {
				      System.out.println("no");
			          return "invaild Email Address";
		               }
		// when user signup and click verify for the second time and third time ......
		if(user.isEnable()) {
		                	return " you have already verified ";	
		                         }
		// when user signup and click verify for the first time (:
		 else   {
			 
			//System.out.println("yessssssssss");
			user.setEnable(true);
			userRepo.save(user);
			//user.clear();
			return " Congratulations! your account is verfied";
		}
		
		
	}
	
		
	}
	
	

