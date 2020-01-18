<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--
	******************************************** 
		title : track2 WebProgram 3차 수련생 성명	
	******************************************** 
 -->	
	<title>track2 WebProgram 3차  홍길동</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="/track2_webprogram_3차_김성용/css/common.css" rel="stylesheet">
	<link href="/track2_webprogram_3차_김성용/css/layout.css" rel="stylesheet">	
</head>
<body>
	
	<div class="container">
<!--
	******************************************** 
		성명 : track2 WebProgram 3차 수련생 성명	
	******************************************** 
 -->	
		<div class="leftmargin">
			<h1 class="t_tit">성명 :track2 WebProgram 3차 김성용</h1>
		</div>		
		<form name ="list">
		<div class="search_wrap">
			<div class="record_group">
				<p>총게시글 : <span>2</span>건</p>
			</div>
			<div class="search_group">
				<select class="select" name ="t_sel">
				<option value="title" <c:if test="${t_selValue == 'title'}">out.print("selected"); </c:if>>제목</option>
				<option value="content" <c:if test="${t_selValue eq 'content'}">out.print("selected");</c:if>>내용</option>
				</select>
				<input class ="search_word" type="text" value="${t_txtValue}" name="t_search" >
				<button class="btn_search" onClick="formSearch()"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</div>
		</div>
		</form>
	</div>
	<div class="board_list">
		<table class="board_table">
			<colgroup>
				<col width="8%">
				<col width="*">
				<col width="10%">
				<col width="10%">
				<col width="8%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
		
		<c:if test="${t_dtos.size() >0}">	
		<c:forEach items="${t_dtos}" var="dto">
				<tr>
					<td align="center"><a href="javascript:view('${dto.getExam_number()}');">${dto.getExam_number()}</a></td>
					<td class="title"><a href="javascript:view('${dto.getExam_number()}');">${dto.getTitle()}</a></td>
					<td align="center">${dto.getName()}</td>
					<td align="center">${dto.getReg_date()}</td>
					<td align="center">${dto.getHit()}</td>
				</tr>
				</c:forEach>
		</c:if>	
		<c:if test="${t_dtos.size() <0}">	
				<tr>
					<td colspan="6">등록된 내용이 없습니다</td>
				</tr>
		</c:if>
			</tbody>
		<form name ="vvv">
			<input type="hidden" name="t_exam_number">
			<input type="hidden" name="t_work" value="gov">
		</form>
		</table>
		<form name ="gow">
		<input type ="hidden" name="t_work" value="gow">
		</form>
		<div class="paging">
			<a href="javascript:write()" class="write">글쓰기</a>
		</div>
	
	</div>
 </body>
   <script>
	function write(){
		var fm = document.gow;
		fm.action ="/track2_webprogram_3차_김성용/Track2_06_ksy_update";
		fm.method ="post";
		fm.submit();
	}
	function formSearch(){
		var fm = document.list;
		fm.action ="/track2_webprogram_3차_김성용/Track2_06_ksy";
		fm.method ="post";
		fm.submit();
	}
	function view(no){
		var fm = document.vvv;
		fm.t_exam_number.value = no;
		fm.action ="/track2_webprogram_3차_김성용/Track2_06_ksy_update";
		fm.method ="post";
		fm.submit();
	}
 </script>

</html>


