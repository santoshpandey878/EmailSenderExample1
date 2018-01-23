package com.sp.sender;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail 
{ 
    public static void send(String to, String sub, 
                         String msg, final String user,final String pass)
    { 
     //create an instance of Properties Class   
     Properties props = new Properties();
     
     /* Specifies the IP address of your default mail server
     	   for e.g if you are using gmail server as an email sever
           you will pass smtp.gmail.com as value of mail.smtp host. 
           As shown here in the code. 
           Change accordingly, if your email id is not a gmail id
        */
     // w/o SSL
     
     //props.put("mail.smtp.host", "smtp.gmail.com");
    // props.put("mail.smtp.host", "smtp.oceaneering.com");
    // props.put("mail.smtp.host", "198.54.171.155");
     //below mentioned mail.smtp.port is optional
    // props.put("mail.smtp.port", "587");		
   //  props.put("mail.smtp.auth", "true");
  //   props.put("mail.smtp.starttls.enable", "true");
     
   // for gmail host 
     // via SSL
     // port 465 for SSL and port 587 for TLS
 /*    	props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
*/		
		
		
     	props.put("mail.smtp.host", "smtp.oceaneering.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");	
		
    // for other host we need to changes host and port
     
     
		//props.put("mail.smtp.debug", "true");
     
     /* Pass Properties object(props) and Authenticator object   
           for authentication to Session instance 
        */

    Session session = Session.getInstance(props,new javax.mail.Authenticator()
    {
  	  protected PasswordAuthentication getPasswordAuthentication() 
  	  {
  	 	 return new PasswordAuthentication("spandeygfg2@oceaneering.com","tyueaighhtnrdgdq");
  	  }
   });
    session.setDebug(true);
   try
   {
 
 	/* Create an instance of MimeMessage, 
 	      it accept MIME types and headers 
 	   */
 
    MimeMessage message = new MimeMessage(session);
       message.setFrom(new InternetAddress(user));
       message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
       message.setSubject(sub);
       message.setText(msg);

       /* Transport class is used to deliver the message to the recipients */
       
       Transport.send(message);
 
 
    }
    catch(Exception e)
    {
    	 e.printStackTrace();
    }
  }  
}
