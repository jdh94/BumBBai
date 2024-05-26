document.addEventListener("DOMContentLoaded", function() {
	document.getElementById("addMemberBtn").addEventListener('click', function(event) {
		let memberName = document.getElementById("memberName").value;
		let memberList = document.getElementById("memberList");
		
		let tmpHtml = document.createElement("span");
		tmpHtml.innerText = memberName;
		
		memberList.append(tmpHtml);
    });
    
	document.getElementById("addTripBtn").addEventListener('click', function(event) {
		let tripName = document.getElementById("tripName").value;
		let memberList = document.getElementById("memberList").childNodes;
		
		let paramMem = [];
		memberList.forEach((data) => {
			paramMem.push(data.innerText);
		})
		
		let dataObject = {
			"tripname" : tripName,
			"attendantname" : paramMem
		};

		// ajax 전송
	    let xhr = new XMLHttpRequest();
	    xhr.open('POST', '/api/uploadTrip/insert', true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(JSON.stringify(dataObject));
	    xhr.onload = () => {
			if(xhr.status == 200){
				console.log(xhr.response);
			}else{
				console.log(xhr.response);
			}
		}

//        $.ajax({
//            // 회원가입 수행요청
//            type: "POST",
//            url: "/api/uploadTrip/insert",
//            data: JSON.stringify(dataObject), // http body데이터
//            contentType: "application/json; charset=utf-8", // body데이터가 어떤 타입인지(MIME)
//            dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든것이 String(버퍼로 오기 때문) 생긴게 json이라면 javascript오브젝트로 변경
//        }).done(function(resp) {
//            alert("글쓰기가 완료되었습니다.");
//            // console.log(resp);
//            location.href = "/";
//        }).fail(function(error) {
//            alert(JSON.stringify(error));
//        }); // ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 inser요청

	    
//        xhr.open("POST", "/api/uploadTrip/insert?" + jsonParamSerialize(dataObject), true);
//		xhr.setRequestHeader("ajax-request", "true");
//	    xhr.send();
//	    xhr.onload = () => {
//			if(xhr.status == 200){
//				console.log(xhr.response);
//			}else{
//				console.log(xhr.response);
//			}
//		}

	});
    
});

