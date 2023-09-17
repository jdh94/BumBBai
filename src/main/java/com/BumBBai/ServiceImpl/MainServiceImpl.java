package com.BumBBai.ServiceImpl;

import com.BumBBai.Repository.MainRepository;
import com.BumBBai.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class MainServiceImpl implements MainService {
	@Autowired
	private MainRepository mainRepository;

	@Override
	@Transactional
	public void addVisitLog(){
		mainRepository.count();
	}

	@Transactional
	public String addTripPlan(Map<String, Object> params){
		return "tripName";
	}



}


















