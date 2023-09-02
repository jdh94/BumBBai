package com.mbtiHarmony.demo.ServiceImpl;

import com.mbtiHarmony.demo.Repository.MainRepository;
import com.mbtiHarmony.demo.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MainServiceImpl implements MainService {
	@Autowired
	private MainRepository mainRepository;

	@Override
	@Transactional
	public void addVisitLog(){
		mainRepository.count();
	}

}


















