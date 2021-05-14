-- Chinook Assignment 
--Juan Mendoza

-- Task 2.1 (SELECT)
show search_path;
set search_path to chinook;

--a) Select all records from the Employee table.
select * from "Employee" ;

--b) Select all records from the Employee table where last name is King.
select * from "Employee" where "LastName" = 'King';

--c) Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from "Employee" e  where "FirstName" ='Andrew' and "ReportsTo" is null; 


-- Task 2.2(ORDER BY)
--a)Select all albums in album table and sort result set in descending order
select * from "Album" order by "AlbumId" desc; -- descending using album colum
select * from "Album" order by "Title" desc ; -- descending but now title column

--b) Select first name from Customer and sort result set in ascending order
select "FirstName" from "Customer" order by "FirstName" desc;


-- Task 2.3(INSERT INTO)
--a)  Insert two new records into Genre table
insert into "Genre" values (26,'Instrumental');
insert into "Genre" values (27,'Orchestra');

--b) Insert two new records into Employee table
insert into "Employee" ("EmployeeId","FirstName","LastName") values (9,'Jihn', 'ADC'),(10,'Bard','Support');
select * from "Employee";

--c) Insert two new records into Customer table
insert into "Customer" values(60, 'John','Doe', null, 'Find Me Ave', 'Goodluck', 'WA', 'The US of A', '99999', '+1 (777) 777-7777', null, 'jdoe@revature.net', 1),
(61, 'Post','gres', null, 'Find Me Ave', 'Dimmsdale', 'WA', 'FairyRealm', '11111', '+1 (111) 111-1111', null, 'post.gres@revature.net', 2);
select * from "Customer";



--Task 2.4 (UPDATE)
--a) Update Aaron Mitchell in Customer table to Robert Walter
update "Customer" set "FirstName" = 'Robert', "LastName" = 'Walter' where "FirstName" = 'Aaron' and "LastName" = 'Mitchell';

--b) Update name of artist “Creedence Clearwater Revival” to “CCR”
select * from "Artist" where "Name" = 'Creedence Clearwater Revival';
update "Artist" set "Name" = 'CCR' where "ArtistId" = 76;
select * from "Artist" where "ArtistId" = 76;



-- Task 2.5 (LIKE)
--  Select all invoices with a billing address like “T”
select * from "Invoice" where "BillingAddress" like '%T%'; -- percent tells us where to look for condition, one in front looks for start, one in end looks for matching @ end, both sides tells us to look anywhere!

-- Task 2.6 (BETWEEN)
--a) Select all invoices that have a total between 15 and 50
select * from "Invoice" where "Total" between 15 and 50;

--b) Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from "Employee" where "HireDate" between '2003-06-01' and '2004-03-01';


--Task 2.7(DELETE)
--  Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
update "Invoice" set "CustomerId" = null where "CustomerId" = 32;
delete from "Customer" where "FirstName" = 'Robert' and "LastName"='Walter';

select * from "Invoice";


--Task 3.1(System Defined Functions)
-- a)  Create a function that returns the current time.
select current_time;

--b)  create a function that returns the length of a mediatype from the mediatype table
select * from "MediaType" mt;
select length("Name") as length_mediaType from "MediaType";



--Task 3.2(System Defined Aggregate Functions);
--a)Create a query that leverages a system-defined function to return the average total of all invoices
select avg("Total") from "Invoice"; 

--b)Create a query that leverages a system-defined function to return the most expensive track
select * from "Track" where "UnitPrice" = (select max("UnitPrice")from "Track");

--Task 3.3 (User Defined Scalar Function)
-- Create a function that returns the average price of invoice-line items in the invoice-line table

--had to use count and sum, these keywords in this document is all sql i know=/

create or replace function avg_priceInvoiceLine()--funciton name
returns numeric --return type
language plpgsql --specifying a procedural language, postgres supports plpgsql
as 
$$
declare ---variable declaration
summation float;
total float;
begin	--logic of what function will accomplish
	select count(*) into total from "InvoiceLine";
	select sum("UnitPrice") into summation from "InvoiceLine";
	return summation/total;
end;
$$

select avg_priceInvoiceLine();  --   avg = 1.03955...
select avg("UnitPrice") from "InvoiceLine"; --  avg = 1.03955... 

--Task 3.4(User Defined Table Valued Functions)
--Create a function that returns all employees who are born after 1968.
select * from "Employee" where "BirthDate" > '1968-1-1';


--- COULD NOT GET FUNCTION TO WORK
create or replace function findoldpeoplefunc()
return varchar 
language plpgsql as 
$$ 
declare 
begin 
	return select * from "Employee" where "BirthDate" > '1968-12-30';

end;
$$

--Task 4.1(INNER)
--Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select * from "Invoice";
select * from "Customer";
select "FirstName" from "Customer" inner join "Invoice" on "Customer"."CustomerId" = "Invoice"."CustomerId"; 


--Task 4.2(outer)
--  Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.
-- not (outer join ----> full outer join)
select "FirstName","LastName","InvoiceId","Total" from "Invoice" full outer join "Customer" on "Invoice"."CustomerId"="Customer"."CustomerId";

--Task 4.3(Right)
--Create a right join that joins album and artist specifying artist name and title.
select * from "Artist";
select * from "Album"; --table 1
select "Name","Artist","Title" from "Album" right join "Artist" on "Album"."ArtistId" = "Artist"."ArtistId";

--Task 4.4(Cross)
-- Create a cross join that joins album and artist and sorts by artist name in ascending order.

--Task 4.5(Self)
--Perform a self-join on the employee table, joining on the reports to column.

select * from "Employee";
select e1."ReportsTo",e2."FirstName",e1."LastName" from "Employee" e1 inner join "Employee" e2 on e1."EmployeeId" <> e2."EmployeeId"; 
