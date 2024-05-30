package com.cosblog.repository.service;

import com.cosblog.dto.InsertTripRequestDto;
import com.cosblog.model.Attendant;
import com.cosblog.repository.AttendantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosblog.model.Trip;
import com.cosblog.repository.TripRepository;

import java.util.ArrayList;
import java.util.List;


//스프링이 컴포넌트 스캔을 통해서  Bean에 등록해줌. IoC를 해준다.
@Service
public class TripService {

	@Autowired
	private TripRepository tripRepository;
	@Autowired
	private AttendantRepository attendantRepository;

	@Transactional
	public Long insertTrip(InsertTripRequestDto insertTripRequestDto) {

		Trip trip = new Trip();
		trip.setTripname(insertTripRequestDto.getTripname());

		tripRepository.save(trip);

		Trip tr = tripRepository.findByTripid(trip.getTripid()).orElse(null);
		long trId = tr.getTripid();

		// list 형태로 저장
		// 참여자 저장
		ArrayList<String> arrayList = insertTripRequestDto.getAttendantname();
		ArrayList<Attendant> attendantList = new ArrayList<>();
		arrayList.forEach( atd -> {
			Attendant attendant = new Attendant();
			attendant.setAttendantname(atd);
			attendant.setTripid(trId);
			attendantList.add(attendant);
		});

		attendantRepository.saveAll(attendantList);

		return trId;
	}
	
	@Transactional(readOnly = true)
	public Trip getTripDetail(long tripid){
		return tripRepository.findByTripid(tripid).orElse(null);
	}
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
