package com.BumBBai.Repository;

import com.BumBBai.Model.SystemLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//DAO
//DI 자동으로 bean등록이 된다.
@Repository // 생략가능
public interface MainRepository extends JpaRepository<SystemLog, Integer> {

}


