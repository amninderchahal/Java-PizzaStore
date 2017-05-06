package finalproject.servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import finalproject.classes.SQL;
import finalproject.classes.renderCharts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class filterChart_1
 */
@WebServlet("/filterChart_1")
public class filterChart_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SQL objSQL = new SQL(); 
	renderCharts objRenderCharts = new renderCharts();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filterChart_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*-----Filter by date and quantity---------*/
		if (!request.getParameter("toDate").equals("") && !request.getParameter("fromDate").equals("") && !request.getParameter("toQuantity").equals("") && !request.getParameter("fromQuantity").equals("")){
			
			String fromDate = request.getParameter("fromDate");
			String toDate = request.getParameter("toDate");
			String fromQuantity = request.getParameter("fromQuantity");
			String toQuantity = request.getParameter("toQuantity");
			filterByBoth(request, response, fromDate, toDate, fromQuantity, toQuantity );
		}
		/*-----Filter by date only---------*/
	    else if (!request.getParameter("toDate").equals("") && !request.getParameter("fromDate").equals("")){
			filterByDate(request, response, request.getParameter("fromDate"), request.getParameter("toDate"));
	    }
		/*-----Filter by quantity only---------*/
		else if (!request.getParameter("toQuantity").equals("") && !request.getParameter("fromQuantity").equals("")){
			filterByQuantity(request, response, request.getParameter("fromQuantity"), request.getParameter("toQuantity"));
	    }
		else
		{
			response.sendRedirect("/FinalProject/dashboard");
			return;
		}
		
		// Render the remaining charts
		objRenderCharts.renderChart_2(request, response);
		objRenderCharts.renderChart_3(request, response);
		objRenderCharts.renderChart_4(request, response);
		
		//Dispatch data to jsp
		objRenderCharts.objPopulateChartData.dispatchChartData(request, response);
	}
	
	/*-----Filter by date---------*/
    protected void filterByDate(HttpServletRequest request, HttpServletResponse response, String fromDate, String toDate) throws ServletException, IOException{
    	
		SimpleDateFormat sdf1 = new SimpleDateFormat("M/dd/yyyy");
		String query = "SELECT * FROM DailySales where DateOfSale >=? AND DateOfSale<=? ORDER BY DateOfSale";
		
        try
        {
        	java.sql.Date sqlFromDate = new java.sql.Date(sdf1.parse(fromDate).getTime());
        	java.sql.Date sqlToDate = new java.sql.Date(sdf1.parse(toDate).getTime());			
			
			Connection con = objSQL.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setDate(1, sqlFromDate);
			ps.setDate(2, sqlToDate);
            ResultSet rs = ps.executeQuery();
            objRenderCharts.objPopulateChartData.chart_1_Data(request, response, rs);
        }
        catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    /*-----Filter by quantity---------*/
    protected void filterByQuantity(HttpServletRequest request, HttpServletResponse response, String fQ, String tQ) throws ServletException, IOException{
    	
    	String query = "SELECT * FROM DailySales WHERE (pizzaSales BETWEEN "+fQ+" AND "+tQ+") AND (drinkSales BETWEEN "+fQ+" AND "+tQ+") AND (sliceSales BETWEEN "+fQ+" AND "+tQ+") ORDER BY DateOfSale;";
    	
        try
        {
        	ResultSet rs = objSQL.executeStatement(query);
        	objRenderCharts.objPopulateChartData.chart_1_Data(request, response, rs);
        }
        catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    /*-----Filter by date and quantity---------*/
    protected void filterByBoth(HttpServletRequest request, HttpServletResponse response, String fD, String tD, String fQ, String tQ) throws ServletException, IOException{
    	
		SimpleDateFormat sdf1 = new SimpleDateFormat("M/dd/yyyy");
		String query = "SELECT * FROM DailySales WHERE (DateOfSale BETWEEN ? AND ?) AND (pizzaSales BETWEEN "+fQ+" AND "+tQ+") AND (drinkSales BETWEEN "+fQ+" AND "+tQ+") AND (sliceSales BETWEEN "+fQ+" AND "+tQ+") ORDER BY DateOfSale;";
	    
        try
        {
        	java.sql.Date sqlFromDate = new java.sql.Date(sdf1.parse(fD).getTime());
        	java.sql.Date sqlToDate = new java.sql.Date(sdf1.parse(tD).getTime());	
			
			Connection con = objSQL.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setDate(1, sqlFromDate);
			ps.setDate(2, sqlToDate);
            ResultSet rs = ps.executeQuery();
            objRenderCharts.objPopulateChartData.chart_1_Data(request, response, rs);
        }
        catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
}

