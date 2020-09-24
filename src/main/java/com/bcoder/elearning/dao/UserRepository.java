package com.bcoder.elearning.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bcoder.elearning.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User getByUsername(String username);


}
