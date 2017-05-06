package finalproject.classes;

import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import finalproject.classes.SQL;
import finalproject.classes.populateChartData;

public class renderCharts{
	SQL objSQL = new SQL();
	public populateChartData objPopulateChartData = populateChartData.getInstance();
	
	// Render chart 1 data
	public void renderChart_1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
		String query = "SELECT * FROM DailySales ORDER BY DateOfSale;";
		
        try
        {
            ResultSet rs = objSQL.executeStatement(query);
            objPopulateChartData.chart_1_Data(request, response, rs);
        }
        catch (Exception e){
            e.printStackTrace();
        }
	}
	// Render chart 2 data
	public void renderChart_2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	        
		String query = "SELECT * FROM WorkHours;";
			
	    try
	    {
	         ResultSet rs = objSQL.executeStatement(query);
	         objPopulateChartData.chart_2_Data(request, response, rs);
	    }
	    catch (Exception e){
	         e.printStackTrace();
	    }
	}
	// Render chart 3 data
	public void renderChart_3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	 
		String query = "SELECT * FROM CashRegister;";
		
		try{
			ResultSet rs = objSQL.executeStatement(query);
			objPopulateChartData.chart_3_Data(request, response, rs);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	//Render chart 4 data
	public void renderChart_4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String query = "SELECT MR.Id, MR.Dough, MR.Cheese, MR.Meats, MR.Vegies, CR.AvgExpenses"+
                        " FROM MonthlyRestock MR INNER JOIN CashRegister CR "+
                        " ON MR.Id = CR.Id;";
		
		try{
			ResultSet rs = objSQL.executeStatement(query);
			objPopulateChartData.chart_4_Data(request, response, rs);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}

