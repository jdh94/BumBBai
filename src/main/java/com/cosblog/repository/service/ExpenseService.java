package com.cosblog.repository.service;

import com.cosblog.model.Expense;
import com.cosblog.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//스프링이 컴포넌트 스캔을 통해서  Bean에 등록해줌. IoC를 해준다.
@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Transactional
	public void insertExpense(Expense expense) {
		expenseRepository.save(expense);
	}

//	@Transactional(readOnly = true)
//	public Page<Board> 글목록(Pageable pageable){
//		return boardRepository.findAll(pageable);
//	}
//
//	@Transactional(readOnly = true)
//	public Board 글상세보기(int id) {
//		return boardRepository.findById(id)
//			.orElseThrow(()->{
//				return new IllegalArgumentException("글 상세보기 실패:아이디를 찾을 수 없습니다.");
//			});
//	}
//
//	@Transactional
//	public void 글삭제하기(int id) {
//		boardRepository.deleteById(id);
//	}
//
//	@Transactional
//	public void 글수정하기(int id, Board requestBoard) {
//		Board board = boardRepository.findById(id)
//			.orElseThrow(()->{
//				return new IllegalArgumentException("글 찾기 실패:아이디를 찾을 수 없습니다.");
//			}); // 영속화 완료
//		board.setTitle(requestBoard.getTitle());
//		board.setContent(requestBoard.getContent());
//		//해당 함수로 종료수(Service가 종료될 때) 트랜잭션이 종료됩니다. 이때 더티체킹 - 자동업데이트가 flush
//	}
//
//	@Transactional
//	public void 댓글쓰기(ReplySaveRequestDto replySaveRequestDto) {
//
//
//
//		replyRepository.mSave(replySaveRequestDto.getUserId(), replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
//	}
//
//	@Transactional
//	public void 댓글삭제(int replyId) {
//		replyRepository.deleteById(replyId);
//	}
}
