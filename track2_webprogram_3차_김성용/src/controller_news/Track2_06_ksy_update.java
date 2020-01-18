package controller_news;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonUtil;
import dao.Exam_DAO;
import dto.Exam_DTO;

/**
 * Servlet implementation class Track2_06_ksy_update
 */
@WebServlet("/Track2_06_ksy_update")
public class Track2_06_ksy_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Track2_06_ksy_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = null;
		Exam_DAO dao = new Exam_DAO();
		String work = request.getParameter("t_work");
		String query ="";
		int result =0;
		String exam_number ="";
		String title ="";
		String content = "";
		String reg_date ="";
		String name="";
		String url="";
		String msg="";
		if(work.equals("gow")) {
			dispatcher = request.getRequestDispatcher("/news/news_write.jsp");
			dispatcher.forward(request,response);
		} else if(work.equals("gos")) {
			exam_number = dao.getExam_number();
			 title = request.getParameter("t_title");
			 content = request.getParameter("t_content");
			 reg_date = CommonUtil.getToday();
			 name = request.getParameter("t_name");
			 query = 	" insert into a06_exam_김성용(exam_number,title,content,reg_date,name) "+
						" values('"+exam_number+"','"+title+"','"+content+"','"+reg_date+"','"+name+"') ";
			 result = dao.update(query);
			 if(result>0) {
				 url= "/track2_webprogram_3차_김성용/Track2_06_ksy";
				 msg= "등록성공";
			 }else {
				 String where = "gow";
				 request.setAttribute("t_work", where);
				 url= "/track2_webprogram_3차_김성용/Track2_06_ksy_update";
				 msg= "등록실패";
			 }
				 request.setAttribute("t_url", url);
				 request.setAttribute("t_msg", msg);
				dispatcher = request.getRequestDispatcher("/news/view_messageAlert3.jsp");
				dispatcher.forward(request,response);
		} else if(work.equals("gov")) {
			exam_number = request.getParameter("t_exam_number");
			Exam_DTO dto = dao.getExamView(exam_number);
			int a = dao.upHit(exam_number);
			request.setAttribute("t_dto",dto);
			dispatcher = request.getRequestDispatcher("/news/news_view.jsp");
			dispatcher.forward(request,response);
		} else if(work.equals("delee")) {
			exam_number = request.getParameter("t_exam_number");
			 query = 	" delete form a06_exam_김성용 "+
					 	" where exam_number = '"+exam_number+"' ";
			 result = dao.update(query);
			if(result>0) {
				 url= "/track2_webprogram_3차_김성용/Track2_06_ksy";
				 msg= "삭제성공";
			 }else {
				 url= "/track2_webprogram_3차_김성용/Track2_06_ksy";
				 msg= "삭제실패";
			 }
			dispatcher = request.getRequestDispatcher("/news/view_messageAlert3.jsp");
			dispatcher.forward(request,response);
		} else if(work.equals("goup")) {
			System.out.println("123123");
			exam_number = request.getParameter("t_exam_number");
			Exam_DTO dto = dao.getExamView(exam_number);
			request.setAttribute("t_dto",dto);
			dispatcher = request.getRequestDispatcher("/news/news_update.jsp");
			dispatcher.forward(request,response);
		} else if(work.equals("up")) {
			exam_number = request.getParameter("t_exam_number");
			 title = request.getParameter("t_title");
			 content = request.getParameter("t_content");
			 reg_date = CommonUtil.getToday();
			 name = request.getParameter("t_name");
			query = 	" update a06_exam_김성용  set "+
						" title = '"+title+"' "+
						" content = '"+content+"' "+
						" name = '"+name+"' "+
					 	" where exam_number = '"+exam_number+"' ";
			 result = dao.update(query);
			if(result>0) {
				 url= "/track2_webprogram_3차_김성용/Track2_06_ksy";
				 msg= "수정성공";
			 }else {
				 url= "/track2_webprogram_3차_김성용/Track2_06_ksy";
				 msg= "수정실패";
			 }
			dispatcher = request.getRequestDispatcher("/news/view_messageAlert3.jsp");
			dispatcher.forward(request,response);
			
		}
	
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
