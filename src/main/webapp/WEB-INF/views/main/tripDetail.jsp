<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
    <div id="tripObject">${trip}</div>
    <div id="tripId">${trip.tripid}</div>

	<h1>여행계획 결재내역 추가 페이지</h1>
	<div>
	<label>여행이름</label>
	<span id="tripName"></span>
	</div
	<div>
    <label>멤버명</label>
	<span id="attendantName"></span>
	</div>

    <div>
	<button id="addExpenseBtn">결재내역추가</button>
	<label>결재내역</label>
	<tr id="expanseList">
	</tr>
	</div>

    <div>
	<button id="expenseDetailBtn">결재내역상세보기</button>
	</div>

    <div>
	<button id="updateTripBtn  ">여행수정</button>
	</div>
</div>

<script src="/js/tripDetail.js"></script>
<script src="/js/common.js"></script>



