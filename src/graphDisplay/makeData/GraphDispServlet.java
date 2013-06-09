package graphDisplay.makeData;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;

/**
 * Servlet implementation class MakeDataServlet
 */
@WebServlet("/GraphDispServlet")
public class GraphDispServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GraphDispServlet() {
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
        
		String dataOutput = "";
		StringBuffer sb = new StringBuffer();
		int dataNum = 0;
		HistogramDataset histgram = new HistogramDataset();

		response.setContentType("image/png;charset=UTF-8");

		HttpSession session = request.getSession();
		
		dataNum = (Integer)session.getAttribute("dataNum");
        
		double[] values = new double[dataNum];
		
		for (int i = 0; i < dataNum; i++) {
			values[i] = (int) (Math.random() * 10) + 1;
		}
		
		histgram.addSeries("データ数", values, 10);
		
		OutputStream out = response.getOutputStream();

		ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
       

		try {
			JFreeChart chart = ChartFactory.createHistogram("データ分布", "値", "個数", histgram, PlotOrientation.VERTICAL,
					true, true, false);
			ChartUtilities.writeChartAsPNG(out, chart, 600, 400);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
        
	}

}
