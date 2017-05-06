package finalproject.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import finalproject.classes.renderCharts;

/**
 * Servlet implementation class charts
 */
@WebServlet("/dashboard")
public class charts extends HttpServlet {
	private static final long serialVersionUID = 1L;
    renderCharts objRenderCharts = new renderCharts();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public charts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Render Charts
		objRenderCharts.renderChart_1(request, response);
		objRenderCharts.renderChart_2(request, response);
		objRenderCharts.renderChart_3(request, response);
		objRenderCharts.renderChart_4(request, response);
		
		//Dispatch data to jsp
		objRenderCharts.objPopulateChartData.dispatchChartData(request, response);
	}
}
