package servlet.exam;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Exam_DAO;
import dto.Exam_DTO;

/**
 * Servlet implementation class examList
 */
@WebServlet("/examList")
public class examList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public examList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Exam_DAO dao = new Exam_DAO();
		String selValue = request.getParameter("t_sel");
		String txtValue = request.getParameter("t_search");
		if(selValue == null){
				selValue = "title";
				txtValue = "";
		}
		ArrayList<Exam_DTO> dtos = dao.getExamLsit(selValue,txtValue);
		request.setAttribute("t_selValue",selValue);
		request.setAttribute("t_txtValue",txtValue);
		request.setAttribute("t_dtos",dtos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/exam_event/event_list.jsp");
	 	dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
