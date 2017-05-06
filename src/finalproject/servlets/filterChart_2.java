package finalproject.servlets;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import finalproject.classes.SQL;
import finalproject.classes.renderCharts;

/**
 * Servlet implementation class filterChart_2
 */
@WebServlet("/filterChart_2")
public class filterChart_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SQL objSQL = new SQL(); 
	renderCharts objRenderCharts = new renderCharts();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filterChart_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Check which input fields are selected
		if (request.getParameter("filterWorkMonth").equals("0") && request.getParameter("filterEmpName").equals("0")){
			response.sendRedirect("/FinalProject/dashboard");
			return;
	    }
		else if (!request.getParameter("filterWorkMonth").equals("0") && request.getParameter("filterEmpName").equals("0")){
			filterByMonth(request, response, request.getParameter("filterWorkMonth"));
		}
		else if (request.getParameter("filterWorkMonth").equals("0") && !request.getParameter("filterEmpName").equals("0")){
			filterByEmpName(request, response, request.getParameter("filterEmpName"));
	    }
		else{
			filterByBoth(request, response, request.getParameter("filterWorkMonth"), request.getParameter("filterEmpName"));
		}
		// Render the remaining charts
		objRenderCharts.renderChart_1(request, response);
		objRenderCharts.renderChart_3(request, response);
		objRenderCharts.renderChart_4(request, response);
		
		//Dispatch data to jsp
		objRenderCharts.objPopulateChartData.dispatchChartData(request, response);
	}
	
	// Filter by month
	protected void filterByMonth(HttpServletRequest request, HttpServletResponse response, String month) throws ServletException, IOException {
		
		String query = "SELECT * FROM WorkHours WHERE Id="+month+";";
		
		try
        {
        	ResultSet rs = objSQL.executeStatement(query);
        	objRenderCharts.objPopulateChartData.chart_2_Data(request, response, rs);
        }
        catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
	}
	
	// Filter by employee name
    protected void filterByEmpName(HttpServletRequest request, HttpServletResponse response, String name) throws ServletException, IOException {
		
		String query = "SELECT Id, "+name+" FROM WorkHours;";
		
		try
        {
        	ResultSet rs = objSQL.executeStatement(query);
        	objRenderCharts.objPopulateChartData.chart_2_Data(request, response, rs);;
        }
        catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
	}
    //Filter by both Employee name and month
    protected void filterByBoth(HttpServletRequest request, HttpServletResponse response, String month, String empName) throws ServletException, IOException {
    	
    	String query = "SELECT Id, "+empName+" FROM WorkHours WHERE Id="+month+";";
    	
    	try
        {
        	ResultSet rs = objSQL.executeStatement(query);
        	objRenderCharts.objPopulateChartData.chart_2_Data(request, response, rs);;
        }
        catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
}
