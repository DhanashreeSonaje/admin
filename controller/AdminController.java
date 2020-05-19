package com.example.capstore.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.capstore.Exception.UserAlreadyExistsException;
import com.example.capstore.model.MerchantDetails;
import com.example.capstore.services.AdminService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@GetMapping("/merchant")
	public ResponseEntity<List<MerchantDetails>>getAllMerchants(){
		return new ResponseEntity<List<MerchantDetails>>(adminService.getMerchants(),HttpStatus.OK);
	}
	
	@PostMapping(value = "/merchant/create")
	public ResponseEntity<MerchantDetails> createMerchant(@Valid @RequestBody MerchantDetails merchant) throws MailException, MessagingException, UnsupportedEncodingException, UserAlreadyExistsException {
	
		adminService.sendNotification(merchant);
		return new ResponseEntity<MerchantDetails>(HttpStatus.CREATED);
		   
	}
	
	@GetMapping("/merchant/{merchant}")
	public ResponseEntity<MerchantDetails>verifyMerchantDetails(@PathVariable("merchant") String email){
		return new ResponseEntity<MerchantDetails>(adminService.verifyMerchantDetails(email),HttpStatus.OK);
	}
	
	@PutMapping("/merchant/email/{email}/{approved}")
	public ResponseEntity<MerchantDetails> getApproval(@PathVariable("email") String email, @PathVariable("approved") boolean approved){
		MerchantDetails merchant = adminService.getApproval(email, approved);
		if(merchant==null) {
			return new ResponseEntity("Sorry! Merchant not found!",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MerchantDetails>(merchant, HttpStatus.OK);
	}
}


