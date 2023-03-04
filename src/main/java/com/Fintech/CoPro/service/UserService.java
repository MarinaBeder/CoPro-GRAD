package com.Fintech.CoPro.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Fintech.CoPro.domain.BankInfo;
import com.Fintech.CoPro.domain.Message;
import com.Fintech.CoPro.domain.User;
import com.Fintech.CoPro.repository.BankInfoRepository;
import com.Fintech.CoPro.repository.MessageRepository;
import com.Fintech.CoPro.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepo;
	@Autowired
	BankInfoRepository bankRepo;
	@Autowired
	VerficationService verficationService;
	@Autowired
	MessageRepository messageRepo;
  
     public String findNationalCardInfo(User user) {
    	 BankInfo IdCardInfo;
    	 try {
    		 
    	IdCardInfo = bankRepo.findByNationalId(user.getNationalId());
       /// User userNumberCardBank = userRepo.findByNumberCardBank(user.getNumberCardBank());
    	System.out.println("IdCardInfo.getNumberCardBank()"+IdCardInfo.getNumberCardBank());
    	System.out.println("user.getNumberCardBank()"+user.getNumberCardBank());
    	if(IdCardInfo.getNumberCardBank()==user.getNumberCardBank()) {
   		 return "this card and national id is vaild";
   		 
   	 }
   	 else { 
   		 return "this card is invaild";

   		 }}
    	catch (Exception ex){
    		return "this national Id doesn't exist" ;
    	} 
    	
    	 
    	
     }

	public String findNumberCardInfo(Long cardNumber, User user) {
	 	 BankInfo CardInfo;

	 	
	    	
	 			CardInfo = bankRepo.findByNumberCardBank(cardNumber);
	 			/// User userNumberCardBank = userRepo.findByNumberCardBank(user.getNumberCardBank());
	 		    if(CardInfo.getRequestPasswordCardBank()>=3) {
	 		    	return "this account is blocked contact with our services";
	 		  
	 		    }	
	 			 System.out.println("IdCardInfo.getNumberCardBank()"+CardInfo.getNumberCardBank());
	 		   	 System.out.println("user.getEndDateCard()"+user.getEndDateCard());
	 		   	 System.out.println("CardInfo.getEndDateCard()"+CardInfo.getEndDateCard());
	 		   	 System.out.println("user.getPasswordCardBank()"+user.getPasswordCardBank());
	 		   	// System.out.println("user.getEndDateCard()==CardInfo.getEndDateCard()"+CardInfo.getEndDateCard()==user.getEndDateCard());

	 		    	if(CardInfo.getEndDateCard()==user.getEndDateCard()) {
	 		    		if(CardInfo.getPasswordCardBank() != user.getPasswordCardBank()) {
	 		    			CardInfo.setRequestPasswordCardBank(CardInfo.getRequestPasswordCardBank()+1);
                  System.out.println(CardInfo.getRequestPasswordCardBank());
                  bankRepo.save(CardInfo);
	 		   		   return "try again to return password";
	 		   		  
	 		   		 
	 		   	 }
	 		    		else {
	 		    			CardInfo.setRequestPasswordCardBank(0);
	 		                  System.out.println(CardInfo.getRequestPasswordCardBank());
	 		                  bankRepo.save(CardInfo);
	 		    			return "correct password ";
	 		    		}}
	 		   	
	 		   		 return "invaild ibfo about end of visa";

	 		   		 
	}
	public String SaveInfoUser(Long cardNumber, User user) {
     BankInfo CardInfo;



	CardInfo = bankRepo.findByNumberCardBank(cardNumber);
	/// User userNumberCardBank = userRepo.findByNumberCardBank(user.getNumberCardBank());
if(CardInfo.getRequestPasswordCardBank()>=3) {
	return "this account is blocked contact with our services";
  
    }	
	 
String encodePassword=passwordEncoder.encode(user.getPassword());
user.setPassword(encodePassword);
 userRepo.save(user);
 return "congratulation ypu are register ";
	}
	
	
	
	
	public Message usernamePassword(User user) {
		Optional<User> userFromApp = java.util.Optional.empty();

	 	
    	try {
		userFromApp = userRepo.findByUsername(user.getUsername());
			/// User userNumberCardBank = userRepo.findByNumberCardBank(user.getNumberCardBank());
    	}
    	catch(Exception ex){
    		return messageRepo.findByMessageNumber("5");
    		//invaild username from catch
    		
    	}
    	if(userFromApp.isPresent()) {
		    	return  messageRepo.findByMessageNumber("6");
		  //invaild username
		    }	
		    String encodePassword=passwordEncoder.encode(user.getPassword());
	    	 user.setPassword(encodePassword);
	       userRepo.save(user);
		    return  messageRepo.findByMessageNumber("7");
		   // vaild username and pasword
	}
	
	
	   public User SignUpUser(User user) {
	    	
	    	 String encodePassword=passwordEncoder.encode(user.getPassword());
	    	 user.setPassword(encodePassword);
	    			 userRepo.save(user);
	    	    	 return user;

	    	  }
}
