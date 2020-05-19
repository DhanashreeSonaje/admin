package com.example.capstore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capstore.model.Coupon;
import com.example.capstore.model.MerchantDetails;
import com.example.capstore.repository.CouponRepository;
import com.example.capstore.repository.MerchantRepository;

@Service
public class CouponService {

	@Autowired
	CouponRepository couponRepo;
	
	@Autowired
	MerchantRepository merchantRepo;
	
	public void addCoupon(Coupon coupon) {
		couponRepo.save(new Coupon(coupon.getCouponCode(),coupon.getUserId(), coupon.getCouponStartDate(), coupon.getCouponEndDate(), coupon.getCouponAmount(), 
				coupon.getCouponMinOrderAmount(), coupon.getIssuedBy()));
	}
	
	public List<Coupon> getCoupons() {
		List<Coupon> coupon = new ArrayList<>();
		couponRepo.findAll().forEach(coupon::add);

		return coupon;
	}
	
	public Coupon getCouponByCode(String code) { 
	  Coupon coupon = couponRepo.findByCouponCode(code);
     return coupon;
	}

	public Coupon getCouponById(int couponId) throws Exception {
		Coupon coupon = couponRepo.findById(couponId)
				.orElseThrow(() -> new Exception("Account Holder not found for this id : " + couponId));
	    return coupon;
	}
}