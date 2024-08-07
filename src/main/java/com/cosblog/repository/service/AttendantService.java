package com.cosblog.repository.service;

import com.cosblog.model.Attendant;
import com.cosblog.model.Trip;
import com.cosblog.repository.AttendantRepository;
import com.cosblog.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//스프링이 컴포넌트 스캔을 통해서  Bean에 등록해줌. IoC를 해준다.
@Service
public class AttendantService {
	
	@Autowired
	private AttendantRepository AttendantRepository;

	@Transactional
	public void insertAttendant(Attendant attendant) {
		AttendantRepository.save(attendant);
	}
	
//	@Transactional(readOnly = true)
//	public Page<Board> boardList(Pageable pageable){
//		return boardRepository.findAll(pageable);
//	}
//	
//	@Transactional(readOnly = true)
//	public Board boardInfo(int id) {
//		return boardRepository.findById(id)
//			.orElseThrow(()->{
//				return new IllegalArgumentException("글 상세보기 실패:아이디를 찾을 수 없습니다.");
//			});
//	}
//	
//	@Transactional
//	public void boardDelete(int id) {
//		boardRepository.deleteById(id);
//	}
//	
//	@Transactional
//	public void boardUpdate(int id, Board requestBoard) {
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
//	public void replyWrite(ReplySaveRequestDto replySaveRequestDto) {
//
//		
//		
//		replyRepository.mSave(replySaveRequestDto.getUserId(), replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
//	}
//	
//	@Transactional
//	public void replyDelete(int replyId) {
//		replyRepository.deleteById(replyId);
//	}
}
