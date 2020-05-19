package com.example.capstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.capstore.model.Coupon;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Integer> {

	public Coupon findByCouponCode(String code);
}

