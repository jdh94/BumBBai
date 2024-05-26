package com.cosblog.repository;

import com.cosblog.model.Attendant;
import com.cosblog.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendantRepository extends JpaRepository<Attendant, Integer> {
	
}

