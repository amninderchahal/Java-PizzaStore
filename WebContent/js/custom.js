//------Chart 1-------//
function renderChart_1(data){
		Highcharts.chart('chart_1_div',{
			chart:{
				type: 'spline'
			},
			title:{
				text: 'Daily Sales ('+ data[0][0] +' - '+ data[0][(data[0].length - 1)]+')'
			},
			xAxis: {
				categories:data[0]
			},
			yAxis: {
				title : {
					text : 'Sales per day'
				}
			},
			tooltip:{
				headerFormat: '<b>{series.name}</b><br>',
		        pointFormat: '{point.y} Sold'
			},
			series:[{
				name: 'Pizza Sales',
				data: data[1]
			},
				{
				name: 'Drinks Sales',
				data: data[2]
			},
				{
				name: 'Slice Sales',
				data: data[3]
			}
			]
		});
}
//----- Chart 2 -----//
function renderChart_2(data){
	
	var temp = [{name: 'James', data: data[1]}, {name: 'Wilson', data: data[2]}, {name: 'Jane', data: data[3]}, {name: 'David', data: data[4]}];
	
	// Remove names with no hours data
	var chartData = [];
	var j = 0;
	for (var i = 1; i <= temp.length; i ++){
		
		if(data[i].length != 0){
			chartData[j] = temp[(i-1)];
			j++;
		}
	}
	temp = null;
	
	// Chart 2 
	Highcharts.chart('chart_2_div', {
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: 'Monthly work hours of employees(2016)'
	    },
	    xAxis: {
	        categories: data[0],
	        crosshair: true
	    },
	    yAxis: {
	        min: 0,
	        title: {
	            text: 'Work Hours'
	        }
	    },
	    tooltip: {
	        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	            '<td style="padding:0"><b>{point.y:.1f} Hours</b></td></tr>',
	        footerFormat: '</table>',
	        shared: true,
	        useHTML: true
	    },
	    plotOptions: {
	        column: {
	            pointPadding: 0.2,
	            borderWidth: 0
	        }
	    },
	    series: chartData
	});
}

// Chart 3
function renderChart_3(data){
	
	var temp = [{
        name: 'Avg Sales',
        type: 'column',
        data: data[1],
        tooltip: {
            valuePrefix: '$'
        }

    }, {
        name: 'Avg Profit',
        type: 'spline',
        color: '#90ED7D',
        data: data[2],
        tooltip: {
        	valuePrefix: '$'
        }
    }, {
        name: 'Avg Expenses',
        type: 'spline',
        data: data[3],
        color: '#333333',
        marker: {
            enabled: false
        },
        dashStyle: 'shortdot',
        tooltip: {
        	valuePrefix: '$'
        }

    }];
	//var chartData = temp;
	
	// Remove fields with no hours data
	var chartData = [];
	var j = 0;
	for (var i = 1; i <= temp.length; i ++){
		
		if(data[i].length != 0){
			chartData[j] = temp[(i-1)];
			j++;
		}
	}
	temp = null;
	
	//for (var k = 0; k < chartData.length;k++)
		//console.log(chartData[k]);
	
	//Chart 3 
	Highcharts.chart('chart_3_div', {
	    chart: {
	        zoomType: 'xy'
	    },
	    title: {
	        text: 'Average Monthly cash register'
	    },
	    xAxis: {
	        categories: data[0],
	        crosshair: true
	    },
	    yAxis: {
	    	title : {
			text : 'Monthly figures'
		},
		labels: {
            formatter: function () {
                return '$'+this.value;
            }
        }
	    },
	    tooltip: {
	        shared: true
	    },
	    legend: {
	        layout: 'vertical',
	        align: 'left',
	        x: 80,
	        verticalAlign: 'top',
	        y: 55,
	        floating: true,
	        backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
	    },
	    series: chartData
	});
}

// Chart 4
function renderChart_4(data){
	
	var temp_TotalExpData = [{
        name: 'Dough',
        y: calculateTotal(data[1]),
        color: Highcharts.getOptions().colors[0] 
    }, {
        name: 'Cheese',
        y: calculateTotal(data[2]),
        color: '#ffb31a' 
    }, {
        name: 'Meats',
        y: calculateTotal(data[3]),
        color: '#ff8080'
    }, {
        name: 'Vegetables',
        y: calculateTotal(data[4]),
        color: '#90ED7D' 
    }];
	
	
	var totalExpData = [];
	var j = 0;
	for (var i = 1; i <= temp_TotalExpData.length; i ++){
		
		if(data[i].length != 0){
			totalExpData[j] = temp_TotalExpData[(i-1)];
			j++;
		}
	}
	temp_TotalExpData = null;
	
	var totalExp = {
	        type: 'pie',
	        name: 'Total Expenses ($)',
	        data: totalExpData,
	        center: [100, 80],
	        size: 100,
	        showInLegend: false,
	        dataLabels: {
	            enabled: false
	        }
	    };
	
	tempChartData = [{
        type: 'column',
        name: 'Dough',
        data: data[1]
    }, {
        type: 'column',
        name: 'Cheese',
        data: data[2],
        color: '#ffb31a'
    }, {
        type: 'column',
        name: 'Meats',
        data: data[3],
        color: '#ff8080'
    }, {
        type: 'column',
        name: 'Vegetables',
        data: data[4],
        color: '#90ED7D'
    },{
        type: 'spline',
        name: 'Total Monthly Expenses',
        data: data[5],
        marker: {
            lineWidth: 2,
            lineColor: Highcharts.getOptions().colors[3],
            fillColor: 'white'
        }
    }];
	
	var chartData = [];
	var k = 0;
	for (var i = 1; i <= tempChartData.length; i ++){
		
		if(data[i].length != 0){
			chartData[k] = tempChartData[(i-1)];
			k++;
		}
	}
	tempChartData = null;
	
	chartData.push(totalExp);
	
	Highcharts.chart('chart_4_div', {
	    title: {
	        text: 'Monthly Restocking Expenses (2016)'
	    },
	    xAxis: {
	        categories: data[0]
	    },
	    yAxis: {
	    	title : {
			text : 'Expenses'
		},
		labels: {
            formatter: function () {
                return '$'+this.value;
            }
        }
	    },
	    labels: {
	        items: [{
	            html: 'Aggregate Restocking Expenses',
	            style: {
	                left: '50px',
	                top: '18px',
	                color: (Highcharts.theme && Highcharts.theme.textColor) || 'black'
	            }
	        }]
	    },
	    series: chartData
	});
}
// Calculate total
function calculateTotal(data){
	var total = 0;

	for (i = 0; i < data.length; i++)
		total += data[i];
	
	return total;
}