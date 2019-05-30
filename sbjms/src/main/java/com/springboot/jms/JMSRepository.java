package com.springboot.jms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JMSRepository extends JpaRepository<PostEntity, Integer>{
	
}
