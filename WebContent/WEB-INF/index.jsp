<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">
  
     <link rel="shortcut icon" href="css/pizzaicon.png">
     <title>Pizza Shop Sales Charts</title>
     
     <!-- HighCharts Libraries -->
     <script src="https://code.highcharts.com/highcharts.js"></script>
     <script src="https://code.highcharts.com/modules/exporting.js"></script>
     
     <!-- jquery library -->
     <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
     
     <!-- jquery UI library -->
     <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
     <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=" crossorigin="anonymous"></script>
     
     <!-- Bootstrap Library -->
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
     <!-- Custon js and css -->
     <link rel="stylesheet" href="css/style.css" type="text/css">
     <script src="js/custom.js"></script>
     <script type="text/javascript">
             var months =  ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
     </script>
</head>
<body>
    <!-- Navbar -->
    <div id="navbar" class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header" id="navbar-homelink">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> 
          </button>
          <a class="navbar-brand" id="home-link" href="#"><img id="pizzaicon" src="css/pizzaicon.png"></a>
          <a class="navbar-brand navbar-txt" id="home-link" href="#">Pizza Store</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="navLink active"><a id="navlink-home" href="#">Dashboard</a></li>
            <li class="navLink"><a id="navlink-filter" href="#">Filter Charts</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="jumbotron">
      <div class="container">
        <div class="col-md-8 col-md-offset-2">
           <h2 class="display-3">Pizza Store Dashboard</h2>
           <p class="lead">A small pizza store that has various statictics and figures to manage needs a good interface to do so. This dashboard is designed to display the various sales and expenses figures for such store in attractive charts and diagrams.</p>
        </div>
      </div>
    </div>
    <!-- Chart 1 div -->
    <div id="chart_1_container" class="form-container panel panel-default">
     <form class="container-fluid panel-body" id="chart_1_form" action="filterChart_1" method="GET">
           <div class="chart-controls col-md-9">
               <div class="chart-div" id="chart_1_div"></div>
           </div>
           <div class="col-md-3 panel panel-default">
              <div class="form-controls form-group panel-body">
                 <h4 class="filter-title">Filter By Date</h4>
                 <span class="input-fields">
                 <input id="fromdate" class="dateBox form-control" type="text" name="fromDate" placeholder="From Date">
                 <br>
                 <input id="todate" class="dateBox form-control" type="text" name="toDate" placeholder="To Date">
                 <p class="text-info">Please use correct date range<br> (11 March - 22 March)</p>
                 <h4 class="filter-title">Filter By Quantity</h4>
                 <input id="fromQuantity" class="textBox form-control" type="text" name="fromQuantity" placeholder="Minimun Quantity">
                 <br>
                 <input id="toQuantity" class="textBox form-control" type="text" name="toQuantity" placeholder="Maximum Quantity"><br>
                 <p class="text-info">E.g. 10 to 20</p>
                 <input id="submit-btn-1" class="btn btn-default" type="submit">
                 <br>
                 <p class="text-info">Note: Both filters can be used as a combination or separately</p>
              </div>
            </div>
     </form>
     </div>
     <!-- Chart 2 div -->
      <div id="chart_2_container" class="form-container panel panel-default">
     <form class="container-fluid panel-body" id="chart_2_form" action="filterChart_2" method="GET">
           <div class="chart-controls col-md-9">
               <div class="chart-div" id="chart_2_div"></div>
           </div>
           <div class="col-md-3 panel panel-default">
              <div class="form-controls form-group panel-body">
                 <h4 class="filter-title">Filter By Work Month</h4>
                 <label class="form-labels" for="filterWorkMonth">Select Month:</label>
                 <select name="filterWorkMonth" class="form-control" id="filterWorkMonth"></select>
                 
                 <h4 class="filter-title">Filter By Employee Name</h4>
                 <label class="form-labels" for="fromQuantity">Select Employee:</label>
                 <select id="filterEmpName" class="form-control" name="filterEmpName">
                    <option value="0">All</option>
                    <option value="Emp_1_Hours">James</option>
                    <option value="Emp_2_Hours">Wilson</option>
                    <option value="Emp_3_Hours">Jane</option>
                    <option value="Emp_4_Hours">David</option>
                 </select>
                 <input class="btn btn-default" type="submit">
                 <br>
                 <p class="text-info">Note: Both filters can be used as a combination or separately</p>
             </div>
           </div>
     </form>
     </div>
      
     <!-- Chart 3 div -->
     <div id="chart_3_container" class="form-container panel panel-default">
     <form class="container-fluid panel-body" action="filterChart_3" method="GET">
           <div class="chart-controls col-md-9">
                <div class="chart-div" id="chart_3_div"></div>
           </div>
           <div class="col-md-3 panel panel-default">
              <div class="form-controls form-group panel-body">
              <h4 class="filter-title">Filter By Sales Month</h4>
              
              <label class="form-labels" for="filterSalesMonth">Select Month:</label>
              <select name="filterDataMonth" id="filterSalesMonth" class="form-control"></select>
              
              <h4 class="filter-title">Filter By Monthly Data</h4>
              <div class="checkbox">
                    <label><input type="checkbox" name="filterDataCategory" value="AvgSales" checked>Avg Sales</label>
              </div>
              <div class="checkbox">
                    <label><input type="checkbox" name="filterDataCategory" value="AvgProfit" checked>Avg Profit</label>
              </div>
              <div class="checkbox">
                    <label><input type="checkbox" name="filterDataCategory" value="AvgExpenses" checked>Avg Expenses</label>
              </div>
              <input class="btn btn-default" type="submit">
              <br>
              <p class="text-info">Note: Both filters can be used as a combination or separately</p>
           </div>
           </div>
     </form>
     </div>
     
      <!-- Chart 4 div -->
     <div id="chart_4_container" class="form-container panel panel-default">
     <form class="container-fluid panel-body" action="filterChart_4" method="GET" target="_parent">
           <div class="chart-controls col-md-9">
                <div class="chart-div" id="chart_4_div"></div>
           </div>
           <div class="col-md-3 panel panel-default">
              <div class="form-controls form-group panel-body">
              <h4 class="filter-title">Filter By Month</h4>
              
              <label class="form-labels" for="filterMonth">Select Month:</label>
              <select name="filterRestockMonth" id="filterMonth" class="form-control"></select>
              
              <h4 class="filter-title">Filter By Item Name</h4>
              <select name="filterItemName" class="form-control">
                    <option value="0">All</option>
                    <option value="Dough">Dough</option>
                    <option value="Cheese">Cheese</option>
                    <option value="Meats">Meats</option>
                    <option value="Vegies">Vegies</option>
                    <option value="AvgExpenses">Total Monthly Expenses</option>
              </select>
              <input class="btn btn-default" type="submit">
              <br>
              <p class="text-info">Note: Both filters can be used as a combination or separately</p>
           </div>
           </div>
     </form>
     </div>
</body>

<script>
  
// Populate data received from servlets to the charts
   $(document).ready(function(){
	   
       var url = window.location.href;
       var homeurl = "/FinalProject/dashboard";
       $("#home-link,#navlink-home").attr('href', homeurl);
       
       if (url.includes("filterChart")){
    	   $(".navLink").toggleClass("active");
       }
       
       if(url.includes("filterChart_1")){
    	   $('html, body').animate({
    	        scrollTop: $("#chart_1_container").offset().top - 60
    	    }, 1000);
       }
       else if(url.includes("filterChart_2")){
    	   $('html, body').animate({
   	        scrollTop: $("#chart_2_container").offset().top - 60
   	    }, 1000);
       }
       else if(url.includes("filterChart_3")){
    	   $('html, body').animate({
   	        scrollTop: $("#chart_3_container").offset().top - 60
   	    }, 1000);
       }
       else if(url.includes("filterChart_4")){
    	   $('html, body').animate({
   	        scrollTop: $("#chart_4_container").offset().top - 60
   	    }, 1000);
       }
       
	   // Populate select options
	   var i;
	   var optionsString = "<option value='0'>All</option>";
		for(i = 0; i <12; i++){
			optionsString += "<option value='"+ (i+1) +"'>"+ months[i]+"</option>";
		};
       $("#filterWorkMonth,#filterSalesMonth,#filterMonth").html(optionsString);
       
       // Set datepickers
       $(".dateBox").datepicker();
       
      // Populate Chart 1 Data
       var chart_1_Data = [];
	      chart_1_Data[0] =  [ <c:forEach var="date" items="${objChartData.dateOfSale}">
	                                 '<c:out value="${date}"/> March',
	                           </c:forEach> ]; 
	      
	      chart_1_Data[1] =  ${objChartData.pizzaSales};
	      
		  chart_1_Data[2] =  ${objChartData.drinkSales};
		  
		  chart_1_Data[3] =  ${objChartData.sliceSales};
		  
		  renderChart_1(chart_1_Data);
		  
	  // Populate Chart 2 Data
	  var chart_2_Data = [];
	  chart_2_Data[0] = [ <c:forEach var="workMonth" items="${objChartData.workMonth}">
	                            months[<c:out value="${workMonth}" />-1],
	                      </c:forEach>];
	  
	  chart_2_Data[1] = ${objChartData.emp_1_Hours};
	  
	  chart_2_Data[2] = ${objChartData.emp_2_Hours};
	  
	  chart_2_Data[3] = ${objChartData.emp_3_Hours};
	  
	  chart_2_Data[4] = ${objChartData.emp_4_Hours};
	  
	  renderChart_2(chart_2_Data);
	  
	  // Populate Chart 3 Data
	  var chart_3_Data = [];
	  
	  chart_3_Data[0] = [ <c:forEach var="saleMonth" items="${objChartData.salesMonth}">
	                            months[<c:out value="${saleMonth}" />-1],
	                      </c:forEach> ];
	  
	  chart_3_Data[1] = ${objChartData.avgSales};
	  
	  chart_3_Data[2] = ${objChartData.avgProfit};
	  
	  chart_3_Data[3] = ${objChartData.avgExpenses};
	  
	  renderChart_3(chart_3_Data);
	  
	// Populate Chart 4 Data
	var chart_4_Data = [];
	
	chart_4_Data[0] = [	<c:forEach var="restockMonth" items="${objChartData.restockMonth}">
		                      months[<c:out value="${restockMonth}" />-1],
		                </c:forEach> ];
	
	chart_4_Data[1] = ${objChartData.dough};
	
	chart_4_Data[2] = ${objChartData.cheese};
	
	chart_4_Data[3] = ${objChartData.meats};
	
	chart_4_Data[4] = ${objChartData.vegies};
	
	chart_4_Data[5] = ${objChartData.avgMonthlyRestock};
	
	renderChart_4(chart_4_Data);
	  
   });
</script>
</html>