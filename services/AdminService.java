package com.example.capstore.services;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.capstore.Exception.UserAlreadyExistsException;
import com.example.capstore.model.MerchantDetails;
import com.example.capstore.repository.MerchantRepository;

@Service
public class AdminService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	MerchantRepository merchantRepo;
	
	@Autowired
	public AdminService(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;
	}
	
	public void sendNotification(MerchantDetails merchant) throws MailException, MessagingException, UnsupportedEncodingException, UserAlreadyExistsException	{
		
		MerchantDetails exist = merchantRepo.findByeMail(merchant.geteMail());
		
		if(exist==null) {
			merchantRepo.save(new MerchantDetails(merchant.getName(), merchant.getUsername(), merchant.getPassword(), merchant.geteMail(), merchant.getRole(), 
					merchant.isActive(), merchant.getSecurityQuestion(), merchant.getSecurityAnswer(), merchant.getPhoneNumber(), merchant.getPhoneNumber(), 
					merchant.getAlternateEmail(), merchant.getProducts(), merchant.getAddresses(), merchant.getpF(), merchant.getCoupons(), merchant.isApproved(), 
					merchant.getRating()));
			
			
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo("dsonaje6@gmail.com");
			
			String url = "http://localhost:4200/verifyMerchant/"+merchant.geteMail();
			
			helper.setSubject("Your Approval");
			  helper.setText("<html><body><h1>Merchant Registration!</h1><br>" +
			  merchant+"<br><button type='submit'>"
			  		+ "<a href="+url+">Show Details</a></button>" + "<br><body></html>", true);
			  
			  javaMailSender.send(message);
		}
		else {
			throw new UserAlreadyExistsException("Merchant exists with this email id!!!");
		}
	}
	
	public MerchantDetails verifyMerchantDetails(String email) {
		return merchantRepo.findByeMail(email);
	}


	public MerchantDetails getApproval(String email, boolean approved) {
		MerchantDetails merchant = merchantRepo.findByeMail(email);
		merchant.setApproved(approved);
		merchantRepo.save(merchant);
		return merchant;
	}
	
	public List<MerchantDetails> getMerchants() {
		List<MerchantDetails> merchant = new ArrayList<>();
		merchantRepo.findAll().forEach(merchant::add);

		return merchant;
	}
}
