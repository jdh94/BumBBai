let index = {
	init: function() {
		$("#btn-save").on("click", () => { // function(){}대신 ()->{}를 사용하는 것은 this를 바인딩 하기 위해서
			this.save();
		});
		$("#btn-update").on("click", () => { // function(){}대신 ()->{}를 사용하는 것은 this를 바인딩 하기 위해서
			this.update();
		});
	},

	save: function() {
		//alert("user의 save함수 호출됨");
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};

		// console.log(data);

		// ajax호출시 default가 비동기 호출
		//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
		//ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트를 변환해준다.
		$.ajax({
			// insertUser 수행요청
			type: "POST",
			url: "/auth/joinProc",
			data: JSON.stringify(data), // http body데이터
			contentType: "application/json; charset=utf-8", // body데이터가 어떤 타입인지(MIME)
			dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든것이 String(버퍼로 오기 때문) 생긴게 json이라면 javascript오브젝트로 변경
		}).done(function(resp) {
			if(resp.status === 500){
				alert("회원가입에 실패하였습니다.");
			}else{
			alert("회원가입이 완료되었습니다.");
			// console.log(resp);
			location.href = "/";
			}
		}).fail(function(error) {
			alert(JSON.stringify(error));
		}); // ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 inser요청

	},
	
	update: function() {
		//alert("user의 save함수 호출됨");
		let data = {
			id : $("#id").val(),
			
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};

		// console.log(data);

		// ajax호출시 default가 비동기 호출
		//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
		//ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트를 변환해준다.
		$.ajax({
			// insertUser 수행요청
			type: "PUT",
			url: "/user",
			data: JSON.stringify(data), // http body데이터
			contentType: "application/json; charset=utf-8", // body데이터가 어떤 타입인지(MIME)
			dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든것이 String(버퍼로 오기 때문) 생긴게 json이라면 javascript오브젝트로 변경
		}).done(function(resp) {
			alert("회원수정이 완료되었습니다.");
			// console.log(resp);
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		}); // ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 inser요청

	},

}

index.init();
