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
 * Servlet implementation class filterChart_3
 */
@WebServlet("/filterChart_3")
public class filterChart_3 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	SQL objSQL = new SQL(); 
	renderCharts objRenderCharts = new renderCharts();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filterChart_3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Check which input fields are selected
		if (request.getParameter("filterDataMonth").equals("0") && request.getParameter("filterDataCategory").equals("")){
			response.sendRedirect("/FinalProject/dashboard");
			return;
	    }
		
		else if (!request.getParameter("filterDataMonth").equals("0") && request.getParameter("filterDataCategory").equals("")){
			filterBySalesMonth(request, response, request.getParameter("filterDataMonth"));
		}
		
        else if (request.getParameter("filterDataMonth").equals("0") && !request.getParameter("filterDataCategory").equals("")){
        	String[] checkedItems = new String[0];
        	checkedItems = request.getParameterValues("filterDataCategory");
			filterByCashRegItem(request, response, checkedItems);
		}
		
        else {
        	String[] checkedItems = new String[0];
        	checkedItems = request.getParameterValues("filterDataCategory");
			filterByBoth(request, response, checkedItems, request.getParameter("filterDataMonth"));
		}
		// Render remaining charts
		objRenderCharts.renderChart_1(request, response);
		objRenderCharts.renderChart_2(request, response);
		objRenderCharts.renderChart_4(request, response);
		
		//Dispatch data to jsp
		objRenderCharts.objPopulateChartData.dispatchChartData(request, response);
	}
	
	// Filter chart data by sales month
    protected void filterBySalesMonth(HttpServletRequest request, HttpServletResponse response, String month) throws ServletException, IOException {
    	
    	String query = "SELECT * FROM CashRegister WHERE Id="+month+";";
    	
    	try
        {
        	ResultSet rs = objSQL.executeStatement(query);
        	objRenderCharts.objPopulateChartData.chart_3_Data(request, response, rs);
        }
        catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    
 // Filter chart data by cash register entity
    protected void filterByCashRegItem(HttpServletRequest request, HttpServletResponse response, String[] checkedItems) throws ServletException, IOException {
    	
    	String itemsName = "Id";
    	
    	for (int i = 0; i < checkedItems.length;i++){
    		
    		if (itemsName.contains(checkedItems[i])){
    			break;
    		}
    		else
    			itemsName = itemsName + ", " + checkedItems[i];
    	}
    	
    	String query = "SELECT "+ itemsName +" FROM CashRegister;";
        
    	try
        {
        	ResultSet rs = objSQL.executeStatement(query);
        	objRenderCharts.objPopulateChartData.chart_3_Data(request, response, rs);
        }
        catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    
    //Filter by Both month and cash register entities
    protected void filterByBoth(HttpServletRequest request, HttpServletResponse response, String[] checkedItems, String month) throws ServletException, IOException {
		
        String itemsName = "Id";
    	
    	for (int i = 0; i < checkedItems.length;i++){
    		
    		if (itemsName.contains(checkedItems[i])){
    			break;
    		}
    		else
    			itemsName = itemsName + ", " + checkedItems[i];
    	}
    	
    	String query = "SELECT "+ itemsName +" FROM CashRegister WHERE Id="+month+";";
    	
    	try
        {
        	ResultSet rs = objSQL.executeStatement(query);
        	objRenderCharts.objPopulateChartData.chart_3_Data(request, response, rs);
        }
        catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
	}
}
