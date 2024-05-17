document.addEventListener("DOMContentLoaded", function() {
	document.getElementById("uploadTripBtn").addEventListener('click', function(event) {
		location.href = '/main/uploadTrip';
//        event.preventDefault();
    });
//   	document.getElementById("searchKeyword").addEventListener("keydown", function(event) {
//        if(event.keyCode === 13) {
//        	searchSubmitStatus();
//        }
//    });
//   	document.getElementById("displayno").addEventListener("change", function(event) {
//	    searchSubmitStatus();
//   	});
//
//	// allCheck , userCheck : name값
//	checkBoxManager = new checkBoxMng("allCheck", "collectorchk");
//	checkBoxManager.checkBoxAllCheck();
//	
//	paging = new CSPaging('paging', 'displaycnt', 'currpage', searchOrder, 0);
//    paging.init();
//
//    // 시작시 목록 출력
//    searchSubmitStatus();
//
//	document.getElementById("exportExcel").addEventListener("click", getExcelExport);
//	if(document.getElementById("manager_grade").value !== '01'){
//		document.getElementById("collectRunBtn").addEventListener("click", collectRun);
//		document.getElementById("addCllctorBtn").addEventListener("click", addCllctorDlgPop);
//		document.getElementById("deletechnlBtn").addEventListener("click", deleteChnlById);
//	}
//	
//	// 달력 출력
//	setDatePicker();
});
