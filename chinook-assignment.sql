--# Revature Associate SQL Workbook
 
--## Part I ? Working with an existing database

--### 1.0 Setting up Chinook

--In this section you will begin the process of working with the Chinook database

--Task ? Set up the Chinook DB by executing the script found [here](https://raw.githubusercontent.com/lerocha/chinook-database/master/ChinookDatabase/DataSources/Chinook_PostgreSql.sql)

--### 2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.

--### 2.1 SELECT
--Task ? Select all records from the Employee table. 
select * from "Employee";

--Task ? Select all records from the Employee table where last name is King.
select * from "Employee" where "LastName" = 'King';

--Task ? Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from "Employee" where "FirstName" = 'Andrew' and "ReportsTo" is null;

--### 2.2 ORDER BY
--Task ? Select all albums in album table and sort result set in descending order
select * from "Album" order by "AlbumId" desc;

--Task ? Select first name from Customer and sort result set in ascending order
select "FirstName" from "Customer" order by "FirstName" asc;

--### 2.3 INSERT INTO
--Task ? Insert two new records into Genre table
insert into "Genre" ("GenreId", "Name") values (26, 'City Pop');
insert into "Genre" ("GenreId", "Name") values (27, 'Ballad');
 
--Task ? Insert two new records into Employee table
insert into "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email")
	values (9, 'Lee', 'James', 'Developer', 4, '2000/01/01', '2020/01/01', '1234 A Ave', 'Cleveland', 'OH', 'United States', 'OH12345', '+1(123)456-7890', '+1(123)456-7891', 'jlee@revature.net' );
insert into "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email")
	values (10, 'Lee', 'Robert', 'Developer', 4, '2001/01/01', '2021/01/01', '5678 A Ave', 'Cleveland', 'OH', 'United States', 'OH67890', '+1(123)456-7892', '+1(123)456-7893', 'rlee@revature.net' );

--Task ? Insert two new records into Customer table
insert into "Customer" ("CustomerId", "FirstName", "LastName", "Company", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email", "SupportRepId") 
	values (60, 'Karl', 'Kim', 'Revature', '1234 B Ave', 'Cleveland', 'OH', 'United States', 'OH12345', '+1(123)456-7894', '+1(123)456-7895', 'kkim@revature.net', 3);
insert into "Customer" ("CustomerId", "FirstName", "LastName", "Company", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email", "SupportRepId") 
	values (61, 'Jason', 'Kim', 'Revature', '5678 B Ave', 'Cleveland', 'OH', 'United States', 'OH67890', '+1(123)456-7896', '+1(123)456-7897', 'jkim@revature.net', 3);

--### 2.4 UPDATE
--Task ? Update Aaron Mitchell in Customer table to Robert Walter
update "Customer"
	set "FirstName" = 'Robert', "LastName" = 'Walter' 
	where "FirstName" = 'Aaron' and "LastName" = 'Mitchell';

--Task ? Update name of artist ¡°Creedence Clearwater Revival¡± to ¡°CCR¡±
update "Artist"
	set "Name" = 'CCR'
	where "Name" = 'Creedence Clearwater Revival';

--### 2.5 LIKE
--Task ? Select all invoices with a billing address like ¡°T¡±
select * from "Invoice" where "BillingAddress" like '%T%'; 

--### 2.6 BETWEEN
--Task ? Select all invoices that have a total between 15 and 50
select * from "Invoice" where "Total" between 15 and 50;

--Task ? Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from "Employee" where "HireDate" between '2003/06/01' and '2004/03/31';

--### 2.7 DELETE
--Task ? Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
alter table "Invoice" 
	drop constraint "FK_InvoiceCustomerId";
alter table "Invoice"
	add constraint "FK_InvoiceCustomerId"
	foreign key ("CustomerId") references "Customer" ("CustomerId")
	on delete cascade;
alter table "InvoiceLine" 
	drop constraint "FK_InvoiceLineInvoiceId";
alter table "InvoiceLine"
	add constraint "FK_InvoiceLineInvoiceId"
	foreign key ("InvoiceId") references "Invoice" ("InvoiceId")
	on delete cascade;
	
delete from "Customer" where "FirstName" = 'Robert' and "LastName" = 'Walter';

--### 3.0 SQL Functions
--In this section you will be using the PostGreSQL system functions, as well as your own functions, to perform various actions against the database

--### 3.1 System Defined Functions
--Task ? Create a function that returns the current time.
create or replace function show_current_time() returns text 
	as '
		begin
			return current_time;
		end
	'
	language plpgsql;

select show_current_time();

--Task ? create a function that returns the length of a mediatype from the mediatype table
create or replace function mediatype_length(mediatype_id int) returns  	
	as $$
		declare
			mediatype_name varchar(120);
		
		begin
			select "Name" into mediatype_name from "MediaType"
				where "MediaTypeId" = mediatype_id;
			return length(mediatype_name);			
		end
	$$
	language plpgsql;
	
select mediatype_length(1);

--### 3.2 System Defined Aggregate Functions
--Task ?Create a function that returns the average total of all invoices
create or replace function average_invoice_total() returns numeric
	as $$
		begin
			return avg("Total") from "Invoice";
		end;
	$$
	language plpgsql;

select average_invoice_total();

--Task ? Create a function that returns the most expensive track

--### 3.3 User Defined Scalar Functions
--Task ? Create a function that returns the average price of invoice-line items in the invoice-line table
create or replace  function average_price() returns numeric 
	as $$
		begin 
			return avg("UnitPrice") from "InvoiceLine";
		end
	$$
	language plpgsql;

select average_price();

--### 3.4 User Defined Table Valued Functions
--Task ? Create a function that returns all employees who are born after 1968.
create or replace function employee_born_after_1968() 
	returns table (
		EmployId int,
		FirstName varchar(20),
		LastName varchar(20),
		BirthDate timestamp
	)
	as $$
		begin 
			return query 
			select "EmployeeId", "FirstName", "LastName", "BirthDate" from "Employee" e
			where "BirthDate" > '1967/12/31';
		end
	$$
	language plpgsql;

select * from employee_born_after_1968();

--### 4.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

--### 4.1 INNER
--Task ? Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select c."CustomerId", c."FirstName", c."LastName", i."InvoiceId" 
	from "Customer" c 
	join "Invoice" i 
	on c."CustomerId" = i."CustomerId" ;

--### 4.2 OUTER
--Task ? Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.
select c."CustomerId" , c."FirstName" , c."LastName" , i."InvoiceId" , i."Total" 
	from "Customer" c 
	full outer join "Invoice" i
	on c."CustomerId" = i."CustomerId" ; 

--### 4.3 RIGHT
--Task ? Create a right join that joins album and artist specifying artist name and title.
select a2."Name" , a1."Title" 
	from "Album" a1
	right join "Artist" a2 
	on a1."ArtistId" = a2."ArtistId";

--### 4.4 CROSS
--Task ? Create a cross join that joins album and artist and sorts by artist name in ascending order.
select * from "Album" a1 , "Artist" a2 
	order by a2."Name" asc;

--### 4.5 SELF
--Task ? Perform a self-join on the employee table, joining on the reports to column.
select e1."EmployeeId", e2."EmployeeId", e1."ReportsTo" 
	from "Employee" e1 , "Employee" e2 
	where e1."ReportsTo" = e2."ReportsTo";