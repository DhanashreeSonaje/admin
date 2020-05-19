package com.example.capstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.capstore.model.MerchantDetails;

@Repository
public interface MerchantRepository extends JpaRepository<MerchantDetails, Integer> {
	public MerchantDetails findByeMail(String email);
}
