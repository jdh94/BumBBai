package com.cosblog.controller.api;

import com.cosblog.dto.InsertTripRequestDto;
import com.cosblog.model.Attendant;
import com.cosblog.repository.service.AttendantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.cosblog.dto.ResponseDto;
import com.cosblog.model.Trip;
import com.cosblog.repository.service.TripService;

@RestController
public class TripApiController {

	@Autowired
	private TripService tripService;

	@Autowired
	private AttendantService attendantService;

	@PostMapping("/api/uploadTrip/insert")
	public long save(@RequestBody InsertTripRequestDto insertTripRequestDto) {
		System.out.println("insert trip");
		System.out.println(insertTripRequestDto);

		long tripId = tripService.insertTrip(insertTripRequestDto);

		return tripId;
	}

	@PostMapping("/api/tripDetail/{tripid}")
	public Trip tripDetailApi(@PathVariable("tripid") long tripid) {

		Trip trip = tripService.getTripDetail(tripid);

		System.out.println("trip api call");
		System.out.println(trip);

		return trip;
	}

//	@DeleteMapping("/api/board/{id}")
//	public ResponseDto<Integer> deleteById(@PathVariable int id){
//		boardService.글삭제하기(id);
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//	}
//
//	@PutMapping("/api/board/{id}")
//	public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board){
//		boardService.글수정하기(id, board);
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//	}
//
//
//	// 데이터를 받을 때 컨트롤러에서 dto를 만들어서 받는게 좋다.
//	// dto 사용하지 않은 이유는! 작은 프로젝트 였기 때문에
//	@PostMapping("/api/board/{boardId}/reply")
//	public ResponseDto<Integer> replySave(@RequestBody ReplySaveRequestDto replySaveRequestDto) { // username, password, email
//
//		boardService.댓글쓰기(replySaveRequestDto);
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//	}
//
//	@DeleteMapping("/api/board/{boardId}/reply/{replyId}")
//	public ResponseDto<Integer> replyDelete(@PathVariable int replyId){
//		boardService.댓글삭제(replyId);
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//	}
}
