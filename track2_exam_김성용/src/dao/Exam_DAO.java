package dao;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import common.*;
import dto.Exam_DTO;

public class Exam_DAO {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection 		   con    = null;
	PreparedStatement  ps 	  = null;
	ResultSet 		   rs 	  = null;

	//홈에 리스트 띄워주기
	
	public ArrayList<Exam_DTO> getHomeNotice(){
	ArrayList<Exam_DTO> dtos = new ArrayList<Exam_DTO>();
	String query =	" SELECT  exam_number, substr(title,0,10),substr(content,0,15), to_char(reg_date, 'yyyy-MM-dd'), "+
					" to_char(start_date, 'yyyy-MM-dd'), to_char(end_date, 'yyyy-MM-dd'), name, hit "+
					" FROM a06_EXAM_김성용 "+
					" ORDER BY exam_number desc ";
	
	
	try {
		con = common.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
	while(rs.next()) {
		String exam_number = rs.getString(1);
		String title = rs.getString(2);
		String content = rs.getString(3);
		String reg_date = rs.getString(4);
		String start_date = rs.getString(5);
		String end_date = rs.getString(6);
		String name = rs.getString(7);
		int hit = rs.getInt(8);
		int likecount = rs.getInt(9);
		
		Exam_DTO dto = new Exam_DTO(exam_number,title,content,reg_date,start_date,end_date,name,hit,likecount);
		
		dtos.add(dto);
	}
	
		}catch(SQLException se) {
			System.out.println("SQLException getHomeNotice():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception getHomeNotice():"+e.getMessage());
		}finally {
			try {
				common.close(con, ps, rs);
			}catch (Exception e) {
				System.out.println("getHomeNotice() close"+e.getMessage());
			}
		}
	
	return dtos;
}
	
	
	
	
	
	
	
	//업데이트문
	
		
	public int update(String query){
	int result =0; 

		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println("SQLException insertNotice():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception insertNotice():"+e.getMessage());
		}finally {
			try {
				common.close(con, ps, rs);
			}catch (Exception e) {
				System.out.println("insertNotice() close"+e.getMessage());
			}
		}
		
		return result;
	}
	
	
	
	
	//조회수 올려주기
	public int noticeHit(String noti_no){ //조회수 증가
		int result = 0;
		String query = " update A06_TRACK2_HOME_NOTICE set hit = hit+1 where notice_no ='"+noti_no+"' ";
		try {
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("SQLException noticeHit():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception noticeHit():"+e.getMessage());
		} finally {
			try {
				common.close(con,ps,rs);
			}catch(Exception e) {
				System.out.println("noticeHit() close:"+e.getMessage());
			}
		}
		return result;		
	}
	


	
	
	public Exam_DTO getExamView(String exam_num){ //상세조회
		Exam_DTO dto = null;
		String query =  " SELECT  exam_number, substr(title,0,10),substr(content,0,15), to_char(reg_date, 'yyyy-MM-dd'), "+
						" to_char(start_date, 'yyyy-MM-dd'), to_char(end_date, 'yyyy-MM-dd'), name, hit,likecount "+
						" FROM a06_EXAM_김성용 "+
					    " where exam_number = '"+exam_num+"' ";
		try {
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String exam_number = rs.getString(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String reg_date = rs.getString(4);
				String start_date = rs.getString(5);
				String end_date = rs.getString(6);
				String name = rs.getString(7);
				int hit = rs.getInt(8);
				int likecount = rs.getInt(9);
				
				dto = new Exam_DTO(exam_number,title,content,reg_date,start_date,end_date,name,hit,likecount);
			}
		}catch(SQLException se) {
			System.out.println("SQLException getExamView():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception getExamView():"+e.getMessage());
		} finally {
			try {
				common.close(con,ps,rs);
			}catch(Exception e) {
				System.out.println("getExamView() close:"+e.getMessage());
			}
		}
		return dto;
	}
	
	
	// 목록 조회

public ArrayList<Exam_DTO> getExamLsit(String selValue, String txtValue){
	ArrayList<Exam_DTO> dtos = new ArrayList<Exam_DTO>();
	String query =	" SELECT  exam_number, substr(title,0,10),substr(content,0,15), to_char(reg_date, 'yyyy-MM-dd'), "+
					" to_char(start_date, 'yyyy-MM-dd'), to_char(end_date, 'yyyy-MM-dd'), name, hit, likecount "+
					" FROM a06_EXAM_김성용 "+
					" where "+selValue+" like '%"+txtValue+"%' "+
					" order by exam_number desc ";
	try { 
		con = common.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
	while(rs.next()) {
		String exam_number = rs.getString(1);
		String title = rs.getString(2);
		String content = rs.getString(3);
		String reg_date = rs.getString(4);
		String start_date = rs.getString(5);
		String end_date = rs.getString(6);
		String name = rs.getString(7);
		int hit = rs.getInt(8);
		int likecount = rs.getInt(9);
		
		Exam_DTO dto = new Exam_DTO(exam_number,title,content,reg_date,start_date,end_date,name,hit,likecount);
		
		dtos.add(dto);
	}
		
		}catch(SQLException se) {
			System.out.println("SQLException getExamLsit():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception getExamLsit():"+e.getMessage());
		}finally {
			try {
				common.close(con, ps, rs);
			}catch (Exception e) {
				System.out.println("getExamLsit() close"+e.getMessage());
			}
		}
	System.out.println(query);
	return dtos;
}


	
	
	//공지사항등록
	
	
	public int insertNotice(String notice_no, String title,
							String content, String reg_id, String reg_date){
	int result =0;
	String query=   " insert into a06_track2_web_notice(notice_no,title,content,reg_id,reg_date) "+
					" values('"+notice_no+"','"+title+"','"+content+"','"+reg_id+"','"+reg_date+"') ";

		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println("SQLException insertNotice():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception insertNotice():"+e.getMessage());
		}finally {
			try {
				common.close(con, ps, rs);
			}catch (Exception e) {
				System.out.println("insertNotice() close"+e.getMessage());
			}
		}
		
		return result;
	}
	
	
	public String getMaxNo() {
		String query = " select max(exam_number) from a06_exam_김성용 ";
		String result = null;
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				result = rs.getString(1);
			}
			
		}catch(SQLException se) {
			System.out.println("SQLException getMaxid():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception getMaxid():"+e.getMessage());
		}finally {
			try {
				common.close(con, ps, rs);
			}catch (Exception e) {
				System.out.println("getMemberList() close"+e.getMessage());
			}
		}
		
		return result;
	}
	
	
	
	public String getExam_number() {
		String exam_number = getMaxNo();
		System.out.println("11111111111"+exam_number);
		if(exam_number == null) {
			exam_number = "N0001";
		} else {
			String cut = exam_number.substring(1,5);
			int number = Integer.parseInt(cut);
			System.out.println(number);
			number++;
			System.out.println(number);
			String r = CommonUtil.getLPad(Integer.toString(number), 4, "0");
			exam_number = "N"+r;
			System.out.println("2222222222"+exam_number);
		}
		
		return exam_number;
	}



	public String getLikeCount(String no) {
		String query = " select likecount from a06_exam_김성용 "+
						" where exam_number = '"+no+"' ";
		String result = null;
		
		try {
			con = common.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				result = rs.getString(1);
			}
			
		}catch(SQLException se) {
			System.out.println("SQLException getLikeCount():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception getLikeCount():"+e.getMessage());
		}finally {
			try {
				common.close(con, ps, rs);
			}catch (Exception e) {
				System.out.println("getLikeCount() close"+e.getMessage());
			}
		}
		
		return result;
	}
	





}
