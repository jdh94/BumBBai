<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

		<div class="container">
			<ol class="location">
				<li>HOME</li>
				<li>게시판관리</li>
				<li>공지사항</li>
            </ol>

			<h2 class="h2" id="content">공지사항</h2>
				<form id="searchForm" name="searchForm" method="GET" class="searchCondition">
					<span class="labelWrap">
						<label id="search_option">검색대상</label>
						<select id="search_option" name="search_option">
							<option value="title">제목</option>
							<option value="content">내용</option>
						</select>
					</span>

					<input type="text" id="searchKeyword" name="searchKeyword" title="검색어 입력" placeholder="검색어 입력">
					<input type="button" id="searchBtn" class="btn btn-search" value="검색" >
                    <input type="hidden" name="currpage" id="currpage" value="1" />
                    <input type="hidden" name="displaycnt" id="displaycnt" value="10" />

					<input type="hidden" id="pageno" name="pageno" value="1">
					<input type="hidden" id="display" name="display" value="10">
					<input type="text" style="display:none;">
				</form>


			<div class="table">
				<table id="searchResultTbl" class="tableC">
					<caption class="hidden">평가입력현황 검색결과</caption>
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col" class="title">제목</th>
							<th scope="col">작성일</th>
							<th scope="col">첨부파일</th>
							<th scope="col">조회</th>
						</tr>
					</thead>
					<tbody id="searchResultBody">
						<!-- 수정할 영역 -->
					</tbody>
				</table>
			</div>


			<div class="pageNav">
				<span id="total_count" class="count">전체 30건</span>
				<select id="displayno" class="pagePerView">
					<option value="10">10건씩 보기</option>
					<option value="20">20건씩 보기</option>
					<option value="30">30건씩 보기</option>
					<option value="50">50건씩 보기</option>
					<option value="100">100건씩 보기</option>
				</select>
				<div id="paging" class="paging"></div>
			</div>
				<div class="btnArea">
	          	<c:if test="${_MANAGER_GRADE_ ne '01' }">
					<input type="button" class="btn pri" value="입력" id="addNoticeBtn"/>
				</c:if>
					<input type="button" class="btn" value="엑셀다운로드" id="exportExcel">
				</div>

		</div>

		<input type="hidden" id="manager_grade" value="${_MANAGER_GRADE_}"/>

<script type="application/javascript" src="<c:url value="/js/views/manager/boardmng/boardmng.js"/>"></script>
=======

<html>
    <h1>메인화면</h1>
    <h2>fe be 서버 분리</h2>

</html>

>>>>>>> 331dbf6e7284c3183c8246dd4604096215f5c260
