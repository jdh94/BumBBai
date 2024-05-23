package com.cosblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosblog.model.Trip;

public interface MainRepository extends JpaRepository<Trip, Integer> {
	
}

