<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--
	******************************************** 
		title : track2 WebProgram 3차 수련생 성명	
	******************************************** 
 -->	
	<title>track2 WebProgram 3차 홍길동</title>
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
			<form name ="up">
		<div class="leftmargin">
			<h1 class="t_tit">성명 : track2 WebProgram 3차 김성용</h1>
		</div>		
		<div class="write_wrap">
		
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
				
						<tr>
							<th>NEWS 제 목</th>
							<td class="th_left">
								<input name="t_title"  class="input_800px" value="${t_dto.getTitle()}" type="text">
							</td>
						</tr>
						<tr>
							<th>NEWS 내 용</th>
							<td class="th_left">
								<textarea name="t_content">
								${t_dto.getContent()}							
								</textarea>
							</td>
						</tr>
						<tr>
							<th>등록자</th>
							<td class="th_left">
								<input name="t_name"  value="${t_dto.getName()}" class="input_100px" type="text">
							</td>
						</tr>
				<input type ="hidden" name ="t_work" value="up">
					
					</tbody>
				</table>
			</div>
			<div class="btn_wrap">
				<input type="button" value="수정 저장" class="btn_ok" onclick ="javascript:su();">&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onclick ="javascript:history.back();">
			</div>
		</div>
	</div>
	</form>
	<script>
	function su(){
		var fm = document.up;
		fm.action ="/track2_webprogram_3차_김성용/Track2_06_ksy";
		fm.method ="post";
		fm.submit();
	}
	</script>
</body>
</html>



















