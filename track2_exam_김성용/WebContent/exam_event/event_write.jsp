<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ page import="common.CommonUtil" %>
<%
		String today = CommonUtil.getToday();
%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--
	******************************************** 
		title : track2 수련생 성명	
	******************************************** 
 -->	
	<title>track2 김성용</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="/css/common.css" rel="stylesheet">
	<link href="/css/layout.css" rel="stylesheet" >	
</head>
<body>
	<div class="container">
<!--
	******************************************** 
		성명 : track2 수련생 성명	
	******************************************** 
 -->	
		<div class="leftmargin">
			<h1>성명 : track2_김성용</h1>
		</div>		
		<div class="write_wrap">
		
			<div class="board_list">
				<form name="list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Event 제목</th>
							<td class="th_left">
								<input name="t_title"  class="input_100Per" type="text">
							</td>
						</tr>
						<tr>
							<th>Event 기간</th>
							<td class="th_left">
								<input type="date" value="Year-Month-Day" min="<%=today%>" name="t_start_date" class="input_100px">
								~
								<input type="date" value="Year-Month-Day" min="<%=today%>" name="t_end_date" class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td class="th_left">
								<textarea name="t_contents"></textarea>
								<input type="hidden" value="w" name="t_work">
							</td>
						</tr>
					</tbody>
				</table>
				</form>
			</div>
				
			<div class="btn_wrap">
				<input type="button" value="저장" class="btn_ok" onClick="write123();">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기" class="btn_reset" >&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onClick="javascript:history.back();">
			</div>
		</div>
	</div>
</body>
 <script>
	function write123(){
		var fm = document.list;
			if(fm.t_title.value==""){
				alert("제목을 입력하세요");
				fm.t_title.focus();
				return;
			}	
			if(fm.t_start_date.value==""){
				alert("시작날짜 입력하세요");
				fm.t_start_date.focus();
				return;
			}
			if(fm.t_end_date.value==""){
				alert("종료날짜 입력하세요");
				fm.t_end_date.focus();
				return;
			}
			if(fm.t_end_date.value < fm.t_start_date.value){
				alert("종료날짜를 다시 확인해주세요");
				fm.t_colseDate.focus();
				return;
			}		
			if(fm.t_contents.value==""){
				alert("내용을 입력하세요");
				fm.t_contents.focus();
				return;
			}
			
		fm.action ="/examUpdate";
		fm.method ="post";
		fm.submit();
	}
 </script>
</html>



















