package com.mbtiHarmony.demo.ServiceImpl;

import com.mbtiHarmony.demo.Dao.BoardMngDAO;
import com.mbtiHarmony.demo.Service.BoardMngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardMngServiceImpl implements BoardMngService{
	@Autowired
	private BoardMngDAO boardmngDAO;

	@Override
	public void addVisitLog() throws Exception {
		this.boardmngDAO.updateVisitor();
	}

}


















