--2.1 SELECT
--set search_path to chinook;
--show search_path;

--select all records from the employee table.
select * from employee;

--select all recods from the employee table where the last name is king
select * from employee 
where lastname = 'King';

--select all recods from the employee table where first name is Andrew and REPORTSTO is NULL
select * from employee 
where firstname = 'Andrew' and reportsto is null;

--2.2 ORDER BY
--select all albums in album table and sort result set in descending order
select * from album
order by albumid desc; --I am going to assume you meant album id

--select first name from first name from Customer and sort result set in ascending order
select firstname from customer
order by firstname asc;

--2.3 INSERT INTO
--insert two new reconds into Genre table
--NOTE: id does not auto-increment
insert into genre (genreid, "name")
values (26, 'Smooth Jazz');
insert into genre (genreid, "name")
values (27, 'Drum and Bass'); 

--insert two new records into the Employee table
--NOTE: id does not auto-increment
insert into employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
values (9, 'Taylor', 'Richard', 'IT staff', 1, '1997-08-03 00:00:00', '2021-04-26 00:00:00', '123 cherry lane', 'somewhere', 'nowhere', 'United States', '30906', '+1 (706) 333-3333', '+1 (706) 333-3333', 'someguy@gmail.com');
insert into employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
values (10, 'Taylorr', 'Richarrd', 'IT staff', 1, '1997-08-03 00:00:00', '2021-04-26 00:00:00', '123 cherry lane', 'somewhere', 'nowhere', 'United States', '30906', '+1 (706) 353-3333', '+1 (706) 353-3333', 'sromeguy@gmail.com');

--insert two new records into Customer Table
--NOTE: id does not auto increment
insert into customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
values (60, 'Deus', 'Iratus', null, 'somewhere out there', 'a city', 'a state', 'a country', '30906', '+1 (775) 223-7665', '+1 (775) 224-6665', 'deus@deus.com', 5);
insert into customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
values (61, 'Deuss', 'Iratuss', null, 'somewhere out there', 'a city', 'a state', 'a country', '30906', '+1 (775) 223-7655', '+1 (775) 222-7665', 'deuas@deus.com', 5);

--2.4 UPDATE
--Update Aaron Mitchell in Customer table to Robert Walter
update customer
set firstname = 'Robert', lastname = 'Walter'
where customerid = 32;

--Update name of artist "Creedence Clearwater Revival" to "CCR"
update artist
set "name" = 'CCR'
where "name" = 'Creedence Clearwater Revival';

--2.5 LIKE
--select all invoices with a billing address like "T"
select * from invoice
where billingaddress like 'T%';

--2.6 BETWEEN
--select all invoices with a total between 15 and 50
select * from invoice
where total between 15.00 and 50.00;

--Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee
where hiredate between '2003-06-01' and '2004-03-01';

-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).


-- I got help from Kyle Plummer on this query, but this is not the proper way to solve the problem
delete from invoiceline
where invoiceid in 
	(select invoiceid from invoice 
		where customerid = 32);

delete from invoice
where customerid = 32;

delete from customer
where firstname = 'Robert' and lastname = 'Walter';

--PROPER SOLUTION:
	--???
alter table customer
drop constraint fk_customersupportrepid,
add constraint fk_customersupportrepid

-- 3.0 SQL Functions

-- 3.1 System Defined Functions
-- Task – Create a function that returns the current time.
select current_date;

-- Task - Task – create a function that returns the length of a mediatype from the mediatype table
select length("name") from mediatype;
 --optional where ? = ?

-- 3.2 System Defined Aggregate Functions

-- Task – Create a function that returns the average total of all invoice
select avg(total) from invoice;

-- Task – Create a function that returns the most expensive track
select max(unitprice) from track;

-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoice-line items in the invoice-line table
create or replace function get_average_invoice ()
returns decimal(10,2)
language plpgsql
as 
$$
	declare
		n decimal(10,2);
	begin
		select avg(unitprice) into n from invoiceline;
		return n;
	end;
$$;

select get_average_invoice();

-- 3.3 User Defined Table Functions
-- Task – Create a function that returns all employees who are born after 1968.
create or replace function get_after_1968()
returns setof employee as ' 
	select * from employee where birthdate > ''1968-01-01 00:00:00'';
'language sql; --Highly scuffed I'm sure, but it gets the job done

select * from get_after_1968();

-- 4.0 JOINS
-- 4.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select c.firstname, c.lastname, i.invoiceid
from customer c inner join invoice i
on c.customerid = i.customerid;

-- 4.2 OUTER
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.
select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
from customer c full outer join invoice i
on c.customerid = i.customerid;

-- 4.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.
select "name", title 
from album 
right join artist using (artistid);

-- 4.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select *
from album 
cross join artist
order by "name" asc; --this query returns a MASSIVE result set

-- 4.5 SELF 
-- Task – Perform a self-join on the employee table, joining on the reports to column.
select * from employee e
left join employee r 
on e.employeeid = r.reportsto;


