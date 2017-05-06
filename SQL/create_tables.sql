CREATE DATABASE DB
GO

USE DB
GO

CREATE TABLE DailySales 
(
  Id INT NOT NULL IDENTITY PRIMARY KEY,
  pizzaSales INT,
  drinkSales INT,
  sliceSales INT,
  DateOfSale DATE
);

CREATE TABLE WorkHours
(
   Id INT NOT NULL IDENTITY PRIMARY KEY,
   Emp_1_Hours INT,
   Emp_2_Hours INT,
   Emp_3_Hours INT,
   Emp_4_Hours INT
);

CREATE TABLE CashRegister
(
   Id INT NOT NULL IDENTITY PRIMARY KEY,
   AvgSales INT,
   AvgProfit INT,
   AvgExpenses INT
);

CREATE TABLE MonthlyRestock
(
  Id INT NOT NULL IDENTITY PRIMARY KEY,
  Dough INT,
  Cheese INT,
  Meats INT,
  Vegies INT
);