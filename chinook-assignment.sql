--# Revature Associate SQL Workbook
 
--## Part I – Working with an existing database

--### 1.0 Setting up Chinook

--In this section you will begin the process of working with the Chinook database

--Task – Set up the Chinook DB by executing the script found [here](https://raw.githubusercontent.com/lerocha/chinook-database/master/ChinookDatabase/DataSources/Chinook_PostgreSql.sql)

--### 2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.

--### 2.1 SELECT
--Task – Select all records from the Employee table. 
SELECT * 
FROM Employee;

--Task – Select all records from the Employee table where last name is King.
select * 
from Employee 
where lastname = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * 
from Employee
where firstname = 'Andrew' 
and reportsto is null;

--### 2.2 ORDER BY
--Task – Select all albums in album table and sort result set in descending order
select *
from Album
order by title desc;

--Task – Select first name from Customer and sort result set in ascending order
select firstname
from Customer
order by firstname asc;

--### 2.3 INSERT INTO
--Task – Insert two new records into Genre table
insert into Genre (genreid, name)
values (26, 'Grunge');

insert into Genre (genreid, name)
values (27, 'Horror');

--Task – Insert two new records into Employee table
insert into Employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
values (9, 'Diendorf', 'Thomas', 'IT Staff', 6, '1988-06-14 03:47:02', '2021-04-26 10:00:00', '55555 Some Street NW', 'Apple Valley', 'CA', 'United States', '92307', '+1 (760) 555-4929', '+1 (760) 555-4929', 'thomas.diendorf@revature.net');

insert into Employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
values (10, 'Gecko', 'Gex', 'Slacker', null, '1995-04-01 03:47:02', '2021-04-26 10:00:00', '55555 Some Street NW', 'Maui', 'HI', 'United States', '96708', '+1 (808) 555-4929', '+1 (808) 555-4929', 'gex.gecko@revature.net');

--Task – Insert two new records into Customer table
insert into Customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
values(60, 'Thomas', 'Diendorf', 'Revature', '55555 Some Street NW', 'Apple Valley', 'CA', 'United States', '92307', '+1 (760) 555-4929', '+1 (760) 555-4929', 'thomas.diendorf@revature.net', 3);

insert into Customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
values(61, 'Gex', 'Gecko', 'Revature', '55555 Some Street NW', 'Maui', 'HI', 'United States', '96708', '+1 (808) 555-4929', '+1 (808) 555-4929', 'gex.gecko@revature.net', 4);

--### 2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
update Customer
set firstname = 'Robert'
where firstname = 'Aaron';

update Customer
set lastname = 'Walter'
where lastname = 'Mitchell';

--Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
update artist 
set name = 'CCR'
where name = 'Creedence Clearwater Revival';


--### 2.5 LIKE
--Task – Select all invoices with a billing address like “T”
select *
from invoice
where billingaddress like '%T%';

--### 2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
select *
from invoice
where invoiceid between 15 and 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select *
from employee
where hiredate between '2003-06-01' and '2004-03-1';

--### 2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
alter table customer
drop constraint fk_customersupportrepid;

alter table customer
add constraint fk_customersupportrepid
foreign key(supportrepid)
references invoice
on delete cascade;

delete from customer
where customerid = 32;


--### 3.0 SQL Functions
--In this section you will be using the PostGreSQL system functions, as well as your own functions, to perform various actions against the database

--### 3.1 System Defined Functions
--Task – Create a function that returns the current time.
select current_time;

--Task – create a function that returns the length of a mediatype from the mediatype table
select 'MPEG audio file', char_length('MPEG audio file')
as character_length
from mediatype;

--just to show I could return length of all mediatypes
--select name, char_length(name)
--from mediatype;

--### 3.2 System Defined Aggregate Functions
--Task –Create a function that returns the average total of all invoices
select avg(total) 
as average_total 
from invoice;

--Task – Create a function that returns the most expensive track
select max(unitprice)
as mostExpensiveTrack
from track;

--### 3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoice-line items in the invoice-line table
select avg(unitprice)
as average_price
from invoiceline;

--### 3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
select *
from employee
where birthdate > '1968-01-01';

--### 4.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

--### 4.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select customer.firstname, customer.lastname, invoice.invoiceid
from customer
inner join invoice on customer.customerid = invoice.customerid;

--### 4.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.
select customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
from customer
full outer join invoice on customer.customerid = invoice.customerid;

--### 4.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
select artist.name, album.title
from album
right join artist on album.albumid = artist.artistid;

--### 4.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select artist.name
from artist
cross join album
order by name asc;

--### 4.5 SELF
--Task – Perform a self-join on the employee table, joining on the reports to column.
select t1.reportsto, t2.reportsto
from employee t1, employee t2;

commit;