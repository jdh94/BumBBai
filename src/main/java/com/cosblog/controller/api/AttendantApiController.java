package com.cosblog.controller.api;

import com.cosblog.dto.ResponseDto;
import com.cosblog.model.Attendant;
import com.cosblog.model.Trip;
import com.cosblog.repository.service.AttendantService;
import com.cosblog.repository.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendantApiController {

	@Autowired
	private AttendantService AttendantService;

	@PostMapping("/api/uploadAttendant/insert")
	public ResponseDto<Integer> save(@RequestBody Attendant attendant) {
		System.out.println("insert Attendant");
		AttendantService.insertAttendant(attendant);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
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
