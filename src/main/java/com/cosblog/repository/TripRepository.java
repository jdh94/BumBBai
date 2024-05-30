package com.cosblog.repository;

import com.cosblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cosblog.model.Trip;

import java.util.Optional;

public interface TripRepository extends JpaRepository<Trip, Integer> {
    Optional<Trip> findByTripname(String tripname);

    Optional<Trip> findByTripid(long tripId);
}

