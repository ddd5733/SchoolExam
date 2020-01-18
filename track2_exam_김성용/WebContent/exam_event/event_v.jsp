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
	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
 
<script type="text/javascript" language="javascript">
 
    $(document).ready(function(){
    	$("#btnOK").click(function(){  
    	      
    	    var urlLocation="/EventLike";  
    	    var params="no="+ $('#t_no').val();
		        $.ajax({
		            type : "post",
		            url : urlLocation,
		            data: params,
		            dataType : "text",
		            error : function(){
		                alert('통신실패!!');
		            },
		            success : function(data){
		                alert("통신데이터 값 : " + data);
	                	$("#divLike").html(data);
		            }
		             
		        });
    	 });
 
    });
 
</script>
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
			<div class="likebox">
				Likes:<span id="divLike">
					${t_dto.getLikecount()}
				</span>
				<input type="button" id="btnOK"  value="👍"/>
				<input type="hidden" id="t_no" value="${t_dto.getExam_number()}"/>
			</div>
		</div>		
		<div class="write_wrap">
		
			<div class="board_list">
				<form name="list">
				<input type="hidden" value="${t_dto.getExam_number()}" name="t_exam_number">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Event 제목</th>
							<td class="th_left">
								<h3>${t_dto.getTitle()}</h3><br>
							</td>
						</tr>
						<tr>
						<th>Event 등록날짜</th>
							<td class="th_left">
								<h3>${t_dto.getReg_date()}</h3><br>
							</td>
						</tr>
						<tr>
							<th>Event 기간</th>
							<td class="th_left">
								<p>${t_dto.getStart_date()}</p>
								~
								<p>${t_dto.getEnd_date()}</p>
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td class="th_left">
								<textarea readonly>${t_dto.getContent()}</textarea>
								<input type="hidden" value="d" name="t_work">
							</td>
						</tr>
					</tbody>
				</table>
				</form>
			</div>
			<form name="mo">
			<input type="hidden" value="${dto.getExam_number()}" name="t_exam_number">
			</form>
				
			<div class="btn_wrap">
				<input type="button" value="삭제" class="btn_ok" onClick="write123();">&nbsp;&nbsp;
				<input type="reset" value="수정" class="btn_reset" onClick="momo();" >&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onClick="javascript:history.back();">
			</div>
		</div>
	</div>
</body>
 <script>
	function write123(){
		var yn = confirm("정말 삭제 하시겠습니까?");
		if(yn==true){
			var fm = document.list;
			fm.action ="/examUpdate";
			fm.method ="post";
			fm.submit();
		}
	}
	function momo(){
		var fm = document.mo;
		fm.action ="/examGoU";
		fm.method ="post";
		fm.submit();
	}
 </script>
</html>



















