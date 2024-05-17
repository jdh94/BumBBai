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
			"tripName" : tripName,
			"memberList" : paramMem
		};
		
		// ajax 전송
	    let xhr = new XMLHttpRequest();
	    xhr.open('POST', '/api/uploadTrip/insert', true);
		xhr.setRequestHeader("ajax-request", "true");
	    xhr.send();	    
	    xhr.onload = () => {
			if(xhr.status == 200){
				console.log(xhr.response);
			}else{
				console.log(xhr.response);
			}
		}
	    
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

