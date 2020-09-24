package com.bcoder.elearning.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bcoder.elearning.entity.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {
	
	 Tutorial findById(int id);

	List<Tutorial> findByCategoryId(int id);

	@Query("SELECT p FROM Tutorial p WHERE CONCAT(p.name, p.description) LIKE %?1%")
	public List<Tutorial> search(String keyword);
}
