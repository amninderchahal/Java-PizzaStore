package finalproject.classes;

import java.util.ArrayList;
import java.util.List;

public class chartData {

	// Data elements
	// Chart 1 data
	public List<Integer> pizzaSales = new ArrayList<>();
	public List<Integer> drinkSales = new ArrayList<>();
	public List<Integer> sliceSales = new ArrayList<>();
	public List<Integer> dateOfSale = new ArrayList<>();
	// Chart 2 data
	public List<Integer> emp_1_Hours = new ArrayList<>();
	public List<Integer> emp_2_Hours = new ArrayList<>();
	public List<Integer> emp_3_Hours = new ArrayList<>();
	public List<Integer> emp_4_Hours = new ArrayList<>();
	public List<Integer> workMonth = new ArrayList<>();
	// Chart 3 data
	public List<Integer> avgSales = new ArrayList<>();
	public List<Integer> avgProfit = new ArrayList<>();
	public List<Integer> avgExpenses = new ArrayList<>();
	public List<Integer> salesMonth = new ArrayList<>();
	// Chart 4 data
	public List<Integer> restockMonth = new ArrayList<>();
	public List<Integer> dough = new ArrayList<>();
	public List<Integer> cheese = new ArrayList<>();
	public List<Integer> meats = new ArrayList<>();
	public List<Integer> vegies = new ArrayList<>();
	public List<Integer> avgMonthlyRestock = new ArrayList<>();
	
	private static chartData instance = null;
	private chartData(){}
	
	// returns instance
	public static chartData getInstance() {
		
		if (instance == null){
		    instance = new chartData();
		    return instance;
		}
		else
			return instance;
	}
	// Reset chart 1 fields
    public void resetChart_1_Fields(){
		
		pizzaSales.clear();
		drinkSales.clear();
		sliceSales.clear();
		dateOfSale.clear();
	}
    // Reset chart 2 fields
    public void resetChart_2_Fields(){
    	
		emp_1_Hours.clear();
		emp_2_Hours.clear();
		emp_3_Hours.clear();
		emp_4_Hours.clear();
		workMonth.clear();
	}
    // Reset chart 3 fields
    public void resetChart_3_Fields(){
    	avgSales.clear();
    	avgProfit.clear();
    	avgExpenses.clear();
    	salesMonth.clear();
    }
    // Reset chart 4 fields
    public void resetChart_4_Fields(){
    	restockMonth.clear();
    	dough.clear();
    	cheese.clear();
    	meats.clear();
    	vegies.clear();
    	avgMonthlyRestock.clear();
    }
	public List<Integer> getPizzaSales() {
		return pizzaSales;
	}

	public List<Integer> getDrinkSales() {
		return drinkSales;
	}

	public List<Integer> getSliceSales() {
		return sliceSales;
	}

	public List<Integer> getDateOfSale() {
		return dateOfSale;
	}

	public List<Integer> getEmp_1_Hours() {
		return emp_1_Hours;
	}

	public List<Integer> getEmp_2_Hours() {
		return emp_2_Hours;
	}

	public List<Integer> getEmp_3_Hours() {
		return emp_3_Hours;
	}

	public List<Integer> getEmp_4_Hours() {
		return emp_4_Hours;
	}

	public List<Integer> getWorkMonth() {
		return workMonth;
	}
	public List<Integer> getAvgSales() {
		return avgSales;
	}

	public List<Integer> getAvgProfit() {
		return avgProfit;
	}

	public List<Integer> getAvgExpenses() {
		return avgExpenses;
	}

	public List<Integer> getSalesMonth() {
		return salesMonth;
	}

	public List<Integer> getRestockMonth() {
		return restockMonth;
	}

	public List<Integer> getDough() {
		return dough;
	}

	public List<Integer> getCheese() {
		return cheese;
	}

	public List<Integer> getMeats() {
		return meats;
	}

	public List<Integer> getVegies() {
		return vegies;
	}

	public List<Integer> getAvgMonthlyRestock() {
		return avgMonthlyRestock;
	}
}