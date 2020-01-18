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
								${t_dto.getTitle()}
							</td>
						</tr>
						<tr>
							<th>NEWS 내 용</th>
							<td class="th_left"><span class="f_color">
								<textarea name="t_content" class="board_textarea_H270_noBorder">
							${t_dto.getContent()}
							</textarea></span>	
							</td>
						</tr>
						<tr>
							<th>등록자</th>
							<td class="th_left">
								${t_dto.getName()}
							</td>
						</tr>
					</tbody>
					
				</table>
			</div>
			<form  name ="upup">
					<input type ="hidden"  name ="t_work" value = "goup">
					<input type ="hidden"  name ="t_exam_number" value="${t_dto.getExam_number()}">
			</form>
			<form name ="delee">
			<input type ="hidden" name ="t_exam_number" value="${t_dto.getExam_number()}">
			<input type ="hidden" name ="t_work" value="delee">
			</form>
			<div class="btn_wrap">
				<input type="button" onclick="javascript:susal();" value="수정" class="btn_ok" >&nbsp;&nbsp;
				<input type="button" onclick="javascript:delee();" value="삭제" class="btn_ok2" >&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onclick ="javascript:history.back();">
			</div>
		</div>
	</div>
<script>
	
	function delee(){
		var fm = document.delee;
		fm.action ="/track2_webprogram_3차_김성용/Track2_06_ksy_update";
		fm.method ="post";
		fm.submit();
	}
	function susal(){
		var fm = document.upup;
		fm.action ="/track2_webprogram_3차_김성용/Track2_06_ksy_update";
		fm.method ="post";
		fm.submit();
	}
	
 </script>
</body>
</html>



















