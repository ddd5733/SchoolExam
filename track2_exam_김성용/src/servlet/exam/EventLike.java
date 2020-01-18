package servlet.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Exam_DAO;

/**
 * Servlet implementation class EventLike
 */
@WebServlet("/EventLike")
public class EventLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventLike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Exam_DAO dao = new Exam_DAO();
		String no = request.getParameter("no");
		String query = " update a06_EXAM_김성용 "+
					   " set likecount = likecount+1 "+
					   " where exam_number = '"+no+"' ";
		int result = dao.update(query);
		String answer ="";
		String likePlus = "";
		if(result >0) {
			likePlus = dao.getLikeCount(no);
			System.out.println(likePlus);
		} else {
			answer = "좋아요를 누르지 못함";
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(likePlus);
		//서블릿(자바)안에서 body를 만드는 매소드
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
