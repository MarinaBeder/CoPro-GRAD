package com.Fintech.CoPro.controller;

import java.io.UnsupportedEncodingException;


import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fintech.CoPro.domain.BankInfo;
import com.Fintech.CoPro.domain.Message;
import com.Fintech.CoPro.domain.User;
import com.Fintech.CoPro.service.UserService;
import com.Fintech.CoPro.service.VerficationService;
import com.Fintech.CoPro.util.Utility;

@RestController
@RequestMapping("Co-Pro/SignUp")
public class SignUpController {
	@Autowired
	private UserService userService;
	@Autowired
	VerficationService verficationService;
	
	//this for user register for the first page {national id and card number}
	@PostMapping("/IdCardInfo")
	public ResponseEntity<?> registerNationalCardNumber(@RequestBody User user/*,HttpServletRequest request*/)
	{
		      String message = userService.findNationalCardInfo(user);
				return ResponseEntity.ok(message);
	}/**/
	
	//this for user register for the first page {End Visa and Card Password}
    @PostMapping("/VisaInfo/{cardNumber}")
    public ResponseEntity<?> registerEndVisaPassword(@PathVariable Long cardNumber,@RequestBody User user/*,HttpServletRequest request*/)
	  {
		  String message = userService.findNumberCardInfo(cardNumber, user);
			return ResponseEntity.ok(message);
	   }
	//this for user register for the first page {username and Password}

	@PostMapping("/userInfo")

	public ResponseEntity<?> registerUsernamePassword(/*@PathVariable Long cardNumber,*/@RequestBody User user/*,HttpServletRequest request*/)
	{
		  Message message = userService.usernamePassword(/*cardNumber,*/ user);
			return ResponseEntity.ok(message);
		}
	
	//this for save all info of user

	@PostMapping("/SaveInfoUser")

	public ResponseEntity<?> registerInfoUser(@RequestBody User user/*,HttpServletRequest request*/)
	{
		  User message = userService.SignUpUser(user);
		// JSONObject json = new JSONObject(message);  
				  
			return ResponseEntity.ok( user);
	}
	/*
	
	try {
		test = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	// String s=buff.toString();
	//This code is to read test in form "JSONObject" to extract specfic"field" like username
	//JSONObject obj = new JSONObject(test.toString());
	obj = new JSONObject(test.toString());
	System.out.println("request form: "+request) ;
	//System.out.println("request form b: "+buff.lines());
	System.out.println("request form t: "+test) ;
	//JSONObject obj = new JSONObject(test2.toString()); //type string
	System.out.println("request form: "+test.toString()) ;
	System.out.println("request in the form of object"+obj) ;
	System.out.println("extract 'username' from requset "+obj.getString("username")) ;
 System.out.println(" test is of type  "+((Object)test).getClass().getSimpleName()) ;//type string
 System.out.println(" obj is of type  "+((Object)obj).getClass().getSimpleName()) ;//type string
String username =obj.getString("username");*/
	
	
	/*
	  @PostMapping("")
	 public ResponseEntity<?> registerPost(@RequestBody User user/*,HttpServletRequest request)
		
			/*{
		      user = userService.SignUpUser(user);
		return ResponseEntity.ok("ok");
				
			}
			*/
	// public ResponseEntity<?> registerPost(@RequestBody User user/*,HttpServletRequest request*/)
		
	//		{
		//      user = userService.SignUpUser(user);
			//	return ResponseEntity.ok("ok"/*user*/);
				
			//}
	
			


}
