USE DB
GO

INSERT INTO DailySales (pizzaSales, drinkSales, sliceSales, DateOfSale)
VALUES (23, 14, 24, CAST(N'2017-03-11' AS Date)),
       (20, 16, 18, CAST(N'2017-03-12' AS Date)),
       (13, 20, 16, CAST(N'2017-03-13' AS Date)),
       (15, 24, 19, CAST(N'2017-03-14' AS Date)),
       (11, 22, 21, CAST(N'2017-03-15' AS Date)),
       (19, 17, 14, CAST(N'2017-03-16' AS Date)),
       (17, 19, 17, CAST(N'2017-03-17' AS Date)),
       (18, 14, 18, CAST(N'2017-03-18' AS Date)),
       (12, 18, 24, CAST(N'2017-03-19' AS Date)),
       (19, 17, 14, CAST(N'2017-03-20' AS Date)),
       (22, 21, 19, CAST(N'2017-03-21' AS Date)),
       (24, 21, 25, CAST(N'2017-03-22' AS Date));
	   
INSERT INTO WorkHours(Emp_1_Hours, Emp_2_Hours, Emp_3_Hours, Emp_4_Hours)
VALUES     (140, 160, 155, 170),
           (120, 145, 135, 130),
	   (133, 130, 115, 146),
	   (158, 161, 129, 150),
	   (126, 136, 149, 134),
	   (143, 145, 163, 158),
	   (150, 176, 152, 129),
	   (163, 126, 176, 178),
	   (128, 146, 143, 141),
	   (136, 152, 157, 149),
	   (171, 100, 141, 181),
	   (124, 140, 136, 126);
	   
INSERT INTO CashRegister (AvgSales, AvgProfit, AvgExpenses)
VALUES (27540, 14350, 13190),
       (29500,17000 , 12500),
	   (26250, 12300, 13950),
	   (31260, 16300, 14960),
	   (33600, 14200, 19400),
	   (27100, 16300, 10800),
	   (29600, 19500, 10100),
	   (34250, 21400, 12850),
	   (26050, 10600, 15450),
	   (27850, 13650, 14200),
	   (30550, 18750, 11800),
	   (36500, 23300, 13200);
	   
INSERT INTO MonthlyRestock(Dough, Cheese, Meats, Vegies)
VALUES (3250, 4560, 2960, 2420),
       (2750, 3100, 3400, 3250),
	   (2560, 4920, 2980, 3490),
	   (4350, 2654, 4140, 1486),
	   (5650, 3560, 6120, 4070),
	   (3140, 2580, 2310, 2770),
	   (2430, 1950, 3215, 2505),
	   (4100, 3250, 1980, 3520),
	   (6130, 2640, 3650, 3030),
	   (3260, 5130, 4120, 1690),
	   (2350, 3740, 3640, 2070),
	   (2840, 3160, 2680, 4520);