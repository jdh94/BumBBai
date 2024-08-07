let index = {
	init: function() {
		$("#btn-save").on("click", () => { // function(){}대신 ()->{}를 사용하는 것은 this를 바인딩 하기 위해서
			this.save();
		});
		$("#btn-delete").on("click", () => { // function(){}대신 ()->{}를 사용하는 것은 this를 바인딩 하기 위해서
			this.deleteById();
		});
		$("#btn-update").on("click", () => { // function(){}대신 ()->{}를 사용하는 것은 this를 바인딩 하기 위해서
			this.update();
		});
		$("#btn-reply-save").on("click", () => { // function(){}대신 ()->{}를 사용하는 것은 this를 바인딩 하기 위해서
			this.replySave();
		});
	},

	save: function() {
		//alert("user의 save함수 호출됨");
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};

		// console.log(data);

		// ajax호출시 default가 비동기 호출
		//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
		//ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트를 변환해준다.
		$.ajax({
			// insertUser 수행요청
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data), // http body데이터
			contentType: "application/json; charset=utf-8", // body데이터가 어떤 타입인지(MIME)
			dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든것이 String(버퍼로 오기 때문) 생긴게 json이라면 javascript오브젝트로 변경
		}).done(function(resp) {
			alert("글쓰기가 완료되었습니다.");
			// console.log(resp);
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		}); // ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 inser요청

	},

	deleteById: function() {
		let id = $("#id").text();

		$.ajax({
			// insertUser 수행요청
			type: "DELETE",
			url: "/api/board/" + id,
			dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든것이 String(버퍼로 오기 때문) 생긴게 json이라면 javascript오브젝트로 변경
		}).done(function(resp) {
			alert("삭제가 완료되었습니다.");
			// console.log(resp);
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		}); // ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 inser요청

	},

	update: function() {
		let id = $("#id").val();
		//alert("user의 save함수 호출됨");
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};

		// console.log(data);

		// ajax호출시 default가 비동기 호출
		//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
		//ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트를 변환해준다.
		$.ajax({
			// insertUser 수행요청
			type: "PUT",
			url: "/api/board/" + id,
			data: JSON.stringify(data), // http body데이터
			contentType: "application/json; charset=utf-8", // body데이터가 어떤 타입인지(MIME)
			dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든것이 String(버퍼로 오기 때문) 생긴게 json이라면 javascript오브젝트로 변경
		}).done(function(resp) {
			alert("글수정이 완료되었습니다.");
			// console.log(resp);
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		}); // ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 inser요청

	},
	
	replySave: function() {
		//alert("user의 save함수 호출됨");
		let data = {
			userId: $("#userId").val(),
			boardId: $("#boardId").val(),
			content: $("#reply-content").val()
		};
		// console.log(data);

		// ajax호출시 default가 비동기 호출
		//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
		//ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트를 변환해준다.
		$.ajax({
			// insertUser 수행요청
			type: "POST",
			url: `/api/board/${data.boardId}/reply`,
			data: JSON.stringify(data), // http body데이터
			contentType: "application/json; charset=utf-8", // body데이터가 어떤 타입인지(MIME)
			dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든것이 String(버퍼로 오기 때문) 생긴게 json이라면 javascript오브젝트로 변경
		}).done(function(resp) {
			alert("댓글 작성이 완료되었습니다.");
			// console.log(resp);
			location.href = `/board/${data.boardId}`;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		}); // ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 inser요청

	},


	replyDelete: function(boardId, replyId) {
		//alert("user의 save함수 호출됨");
		$.ajax({
			// insertUser 수행요청
			type: "DELETE",
			url: `/api/board/${boardId}/reply/${replyId}`,
			dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든것이 String(버퍼로 오기 때문) 생긴게 json이라면 javascript오브젝트로 변경
		}).done(function(resp) {
			alert("댓글 삭제 성공");
			// console.log(resp);
			location.href = `/board/${boardId}`;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		}); // ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 inser요청

	}
}

index.init();
