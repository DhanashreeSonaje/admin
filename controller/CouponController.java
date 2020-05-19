package com.example.capstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.capstore.model.Coupon;
import com.example.capstore.services.CouponService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CouponController {

	@Autowired
	CouponService couponService;
	
	@GetMapping("/coupons")
	public ResponseEntity<List<Coupon>>getAllAccounts(){
		//couponService.getAllAccounts();
		return new ResponseEntity<List<Coupon>>(couponService.getCoupons(),HttpStatus.OK);
	}
	
	@PutMapping("/coupons/Id/{couponId}")
	public ResponseEntity<Coupon> getAccountById(@PathVariable("couponId") int couponId) throws Exception{
		Coupon account= couponService.getCouponById(couponId);
		if(account==null) {
			return new ResponseEntity("Sorry! Coupon not found!",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Coupon>(account, HttpStatus.OK);
	}
	
	@PutMapping("/coupons/Code/{couponCode}")
	public ResponseEntity<Coupon> getAccount(@PathVariable("couponCode") String couponCode){
		Coupon account= couponService.getCouponByCode(couponCode);
		if(account==null) {
			return new ResponseEntity("Sorry! Coupon not found!",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Coupon>(account, HttpStatus.OK);
	}
	
	@PostMapping(value = "/coupons/create")
	public ResponseEntity<Coupon> addCoupon(@Valid @RequestBody Coupon coupon) {
	
		 couponService.addCoupon(coupon);
		return new ResponseEntity<Coupon>(HttpStatus.CREATED);
		   
	}
	
	
}


