create table tblCustomers (
CustomerID serial primary key,
CompanyName varchar(100),
ContactName varchar(100),
ContactTitle varchar(50),
Address varchar(255),
City varchar(100),
Region varchar(100),
PostalCode varchar(50),
Country varchar(50) default 'Canada',
Phone varchar(20),
Fax varchar(20)
);

create table tblShippers(
ShipperID serial primary key,
CompanyName varchar(100) unique
);

create table tblProducts(
ProductID serial primary key,
SupplierID int references tbhSupplier(SupplierID),
CategoryID int,
ProductName varchar(100),
QuantityPerUnit varchar(50),
UnitPrice decimal(10,2),
UnitsInStock int,
UnitsOnOrder int,
ReorderLevel int,
Discontinued boolean
);

create table tblOrders(
OrderId serial primary key,
CustomerID int references tblCustomers(CustomerID),
EmployeeID int,
OrderDate date,
RequiredDate date,
ShippedDate date check(ShippeDate>OrderDate),
ShipperID int references tblShippers(ShipperID),
ShipAddress varchar(255),
ShipCity varchar(100),
ShipRegion varchar(100),
ShipPostalCode(50),
ShipCountry varchar(50)
);

create table tblOrderDetails(
OrderID int references tblOders(OrderID),
ProductID int references tblProducts(ProductID),
UnitPrice decimal (10,2),
Quantity int check (Quantity>=0),
Discount decimal(5,2),
primary key(OrderID, ProductID)
);
