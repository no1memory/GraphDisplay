package graphDisplay.makeData;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        // TODO Auto-generated constructor stub
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
        
		String dataOutput = "";
		StringBuffer sb = new StringBuffer();
		int dataNum = 0;

		request.setCharacterEncoding("Shift_JIS");
		response.setContentType("text/html; charset=Shift_JIS");

		dataNum = Integer.parseInt(request.getParameter("dataNum"));
        
		for (int i = 0; i < dataNum; i++) {
			sb.append(String.valueOf((int) (Math.random() * 11)));
			if (i != (dataNum - 1))
				sb.append(",");
		}
		dataOutput = sb.toString();

		request.setAttribute("dataOutput", dataOutput);

		RequestDispatcher rd = request.getRequestDispatcher("/makeData.jsp");
		rd.forward(request, response);
        
	}

}
