package finalproject.classes;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class populateChartData {
	
    public chartData objChartData = chartData.getInstance();
	List<Date> date = null;
	
	private static populateChartData instance = null;
	
	private populateChartData(){}

	// returns instance 
	public static populateChartData getInstance(){
		
		if (instance == null){
			
		    instance = new populateChartData();
		    return instance;
		}
		else
			return instance;
	}
	// Add CHART 1 Data to Chart Data Object
	public void chart_1_Data(HttpServletRequest request, HttpServletResponse response, ResultSet rs) throws ServletException, IOException{
		
		List<Date> date = new ArrayList<>();
		objChartData.resetChart_1_Fields();
		
        try
        {
            while(rs.next()){     
            	objChartData.pizzaSales.add(rs.getInt("pizzaSales"));
            	objChartData.drinkSales.add(rs.getInt("drinkSales"));
            	objChartData.sliceSales.add(rs.getInt("sliceSales"));
            	date.add(rs.getDate("DateOfSale"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
	    for (Byte i = 0; i < date.size();i++){
	    	SimpleDateFormat sf = new SimpleDateFormat("dd");
	    	objChartData.dateOfSale.add(Integer.decode(sf.format(date.get(i))));
	    }
	}
	
	// Add CHART 2 Data to chartData Object
	public void chart_2_Data(HttpServletRequest request, HttpServletResponse response, ResultSet rs) throws ServletException, IOException{
		
		objChartData.resetChart_2_Fields();
		
		List<Integer> empHours;
		try{
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			String EmpName = rsmd.getColumnLabel(2);
			empHours = new ArrayList<>();
			// Get data for one employee
			if (columnCount == 2)
			{
				while(rs.next()){
					objChartData.workMonth.add(rs.getInt("Id"));
					empHours.add(rs.getInt(EmpName));
				}
				setEmpHours(empHours, EmpName);
			}
			// Get data for multiple employees
			else{
				while(rs.next()){
					objChartData.workMonth.add(rs.getInt("Id"));
					objChartData.emp_1_Hours.add(rs.getInt("Emp_1_Hours"));
					objChartData.emp_2_Hours.add(rs.getInt("Emp_2_Hours"));
					objChartData.emp_3_Hours.add(rs.getInt("Emp_3_Hours"));
					objChartData.emp_4_Hours.add(rs.getInt("Emp_4_Hours"));
				}
			}
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	// Add CHART 3 Data to chartData Object
	public void chart_3_Data(HttpServletRequest request, HttpServletResponse response, ResultSet rs) throws ServletException, IOException{
		
		objChartData.resetChart_3_Fields();
		
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			List<String> dataItem = new ArrayList<>();
			
			for (int i = 0; i < columnCount; i++)
			     dataItem.add(rsmd.getColumnLabel(i+1));
			
			// Get data for multiple employees
		    while(rs.next()){
		    	
				objChartData.salesMonth.add(rs.getInt("Id"));
				
				if (dataItem.contains("AvgSales"))
					objChartData.avgSales.add(rs.getInt("AvgSales"));
				
				if (dataItem.contains("AvgProfit"))
					objChartData.avgProfit.add(rs.getInt("AvgProfit"));
				
				if (dataItem.contains("AvgExpenses"))
					objChartData.avgExpenses.add(rs.getInt("AvgExpenses"));
		    }
		    //for (int i = 0; i < objChartData.avgProfit.size(); i++)
		    	//System.out.println(objChartData.avgProfit.get(i));
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Add CHART 4 Data to chartData Object
	public void chart_4_Data(HttpServletRequest request, HttpServletResponse response, ResultSet rs) throws ServletException, IOException{
		
		objChartData.resetChart_4_Fields();
		
		ResultSetMetaData rsmd;
		
		try {
			rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			List<String> dataItem = new ArrayList<>();
			
			for(int i = 0; i < columnCount; i++)
				dataItem.add(rsmd.getColumnLabel(i+1));
			
			while(rs.next()){
				objChartData.restockMonth.add(rs.getInt("Id"));
				
				if (dataItem.contains("Dough"))
				   objChartData.dough.add(rs.getInt("Dough"));
				
				if (dataItem.contains("Cheese"))
				   objChartData.cheese.add(rs.getInt("Cheese"));
				
				if (dataItem.contains("Meats"))
				   objChartData.meats.add(rs.getInt("Meats"));
				
				if (dataItem.contains("Vegies"))
				   objChartData.vegies.add(rs.getInt("Vegies"));
				
				if (dataItem.contains("AvgExpenses"))
					objChartData.avgMonthlyRestock.add(rs.getInt("AvgExpenses"));
			}
		   // for (int i = 0; i < objChartData.meats.size(); i++)
		    //	System.out.println(objChartData.meats.get(i));

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	// Add data to employee list that the user requested 
	private void setEmpHours(List<Integer> empHours, String EmpName){
		
		switch (EmpName){
		case"Emp_1_Hours" : 
			objChartData.emp_1_Hours = empHours;
			break;
		
		case"Emp_2_Hours" : 
			objChartData.emp_2_Hours = empHours;
			break;
			
		case"Emp_3_Hours" : 
			objChartData.emp_3_Hours = empHours;
			break;
			
		case"Emp_4_Hours" : 
			objChartData.emp_4_Hours = empHours;
			break;
		}
	}
	
	// Dispatch object chartData to the jsp page
	public void dispatchChartData (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		request.setAttribute("objChartData", objChartData);
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}
}
