package servlet.exam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonUtil;
import dao.Exam_DAO;

/**
 * Servlet implementation class examWrite
 */
@WebServlet("/examUpdate")
public class examUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public examUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String work = request.getParameter("t_work");
		Exam_DAO dao = new Exam_DAO();
		String exam_number = "";
		String title ="";
		String content ="";
		String reg_date ="";
		String start_date ="";
		String end_date ="";
		String name ="";
		String query ="";
		String msg ="";
		String url ="";
		int result =0;
		if(work.equals("w")) {
			exam_number =dao.getExam_number();
			title = request.getParameter("t_title");     
			content = request.getParameter("t_contents");     
			reg_date = CommonUtil.getToday();
			start_date =request.getParameter("t_start_date");
			end_date =request.getParameter("t_end_date");
			name ="김성용";      
			query =	" insert into a06_exam_김성용(exam_number,title,content,reg_date,start_date,end_date,name) "+
					" values('"+exam_number+"','"+title+"','"+content+"','"+reg_date+"','"+start_date+"','"+end_date+"','"+name+"') ";
			result =dao.update(query);
			if(result>0) {
				msg = "글쓰기가 완료 되었습니다.";
				url = "/examList";
			} else {
				msg = "글쓰기가 성공되지 못했습니다";
				url = "/examGoWrite";
			}
		} else if(work.equals("d")) {
			exam_number = request.getParameter("t_exam_number");
			query = " delete from a06_exam_김성용  where exam_number = '"+exam_number+"' ";
			if(result>0) {
				msg = "삭제 완료 되었습니다.";
				url = "/examList";
			} else {
				msg = "삭제실패";
				url = "/examList";
			}
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		RequestDispatcher rdq = request.getRequestDispatcher("/exam_event/view_messageAlert.jsp");
		rdq.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
