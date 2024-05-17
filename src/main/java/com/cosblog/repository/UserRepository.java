package com.cosblog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosblog.model.User;

//DAO
//DI 자동으로 bean등록이 된다.
//@Repository // 생략가능
public interface UserRepository extends JpaRepository<User, Integer> {
	
	// 네이밍 쿼리 SELECT * FROM user WHERE username = 1?;
	Optional<User> findByUsername(String username);
}

// JPA Naming 쿼리
// User findByUsernameAndPassword(String username, String password);

