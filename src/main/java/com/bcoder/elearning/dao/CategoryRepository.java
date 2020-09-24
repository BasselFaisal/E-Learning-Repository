package com.bcoder.elearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcoder.elearning.entity.TutorialCategory;

public interface CategoryRepository extends JpaRepository<TutorialCategory, Integer> {

	TutorialCategory findById(int id);
	
}
