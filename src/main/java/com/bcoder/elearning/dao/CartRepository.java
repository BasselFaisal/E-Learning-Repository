package com.bcoder.elearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcoder.elearning.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	Cart getByUserId(int id);

}
