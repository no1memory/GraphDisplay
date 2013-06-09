package graphDisplay.makeData;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MakeDataServlet
 */
@WebServlet("/MakeDataServlet")
public class MakeDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeDataServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dataNum = 0;
		
		request.setCharacterEncoding("Shift_JIS");
		response.setContentType("text/html; charset=Shift_JIS");
		dataNum = Integer.parseInt(request.getParameter("dataNum"));
		
		HttpSession session = request.getSession();
		
		session.setAttribute("dataNum", dataNum);

		RequestDispatcher rd = request.getRequestDispatcher("/Result.jsp");
		rd.forward(request, response);
	}

}
