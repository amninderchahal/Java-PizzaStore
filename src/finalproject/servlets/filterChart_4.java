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
 * Servlet implementation class filterChart_4
 */
@WebServlet("/filterChart_4")
public class filterChart_4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SQL objSQL = new SQL(); 
	renderCharts objRenderCharts = new renderCharts();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filterChart_4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Check which input fields are selected
		if (request.getParameter("filterRestockMonth").equals("0") && request.getParameter("filterItemName").equals("0")){
		     	response.sendRedirect("/FinalProject/dashboard");
			return;
		}
		else if (!request.getParameter("filterRestockMonth").equals("0") && request.getParameter("filterItemName").equals("0")){
		    
			filterRestockMonth(request, response, request.getParameter("filterRestockMonth"));
		}
		else if (request.getParameter("filterRestockMonth").equals("0") && !request.getParameter("filterItemName").equals("0")){
			filterItemName(request, response, request.getParameter("filterItemName"));
		}
		else{
		    filterByBoth(request, response, request.getParameter("filterRestockMonth"), request.getParameter("filterItemName"));
		}
		
		// Render the remaining charts
		objRenderCharts.renderChart_1(request, response);
		objRenderCharts.renderChart_2(request, response);
		objRenderCharts.renderChart_3(request, response);
				
		//Dispatch data to jsp
		objRenderCharts.objPopulateChartData.dispatchChartData(request, response);
	}
	
	protected void filterRestockMonth(HttpServletRequest request, HttpServletResponse response, String month) throws ServletException, IOException {
		
        String query = "SELECT MR.Id, MR.Dough, MR.Cheese, MR.Meats, MR.Vegies, CR.AvgExpenses"+
                " FROM MonthlyRestock MR INNER JOIN CashRegister CR "+
                " ON MR.Id = CR.Id WHERE MR.Id="+month+";";
        
		try
        {
        	ResultSet rs = objSQL.executeStatement(query);
        	objRenderCharts.objPopulateChartData.chart_4_Data(request, response, rs);
        }
        catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
	}
	
	protected void filterItemName(HttpServletRequest request, HttpServletResponse response, String itemName) throws ServletException, IOException {
		
		String query = "SELECT MonthlyRestock.Id, "+itemName+
                " FROM MonthlyRestock INNER JOIN CashRegister "+
                " ON MonthlyRestock.Id = CashRegister.Id;";
        
		try
        {
        	ResultSet rs = objSQL.executeStatement(query);
        	objRenderCharts.objPopulateChartData.chart_4_Data(request, response, rs);
        }
        catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
	}
	
    protected void filterByBoth(HttpServletRequest request, HttpServletResponse response, String month, String itemName) throws ServletException, IOException {
		
		String query = "SELECT MonthlyRestock.Id, "+itemName+
                " FROM MonthlyRestock INNER JOIN CashRegister "+
                " ON MonthlyRestock.Id = CashRegister.Id WHERE MonthlyRestock.Id="+month+";";
        
		try
        {
        	ResultSet rs = objSQL.executeStatement(query);
        	objRenderCharts.objPopulateChartData.chart_4_Data(request, response, rs);
        }
        catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
	}
}
