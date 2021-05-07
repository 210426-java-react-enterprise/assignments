/**
create schema chinook;
create user wsingleton with password 'revature'; --user can connect to this database using this credential
drop user wsingleton;
create user swekevin with password 'secret';
grant all privileges on all tables in schema chinook to swekevin;

set search_path to chinook; -- prevents us from having to explicitly taret the chinook schema when creating objects

show search_path; --shows us the default schema for this script, should be chinook after running above line
**/

--shows us what user we are currently connected to the database as
select current_user;
show search_path;
set search_path to chinook;

grant usage on schema chinook to swekevin;
grant create on schema chinook to swekevin;
grant all privileges on all tables in schema chinook to swekevin;

set search_path to chinook;

--Task 1.0----------------------------------------------------------------
--Executed, removed from script to save space

--Task 2.0 SQL Queries----------------------------------------------------
--Task 2.1 SELECT
select * from employee;
select * from employee where lastname = 'King';
select * from employee where firstname = 'Andrew'and reportsto is null;

--Task 2.2 ORDER BY
select * from album order by albumid desc;
select * from customer c order by customerid asc;

--Task 2.3 INSERT INTO
select * from genre;
insert into genre (genreid, name) values (26, 'Rap');
insert into genre (genreid, name) values (27, 'Ballroom');

--Task 2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
/*
select*from customer c ;
select*from customer where firstname = 'Aaron' and lastname = 'Mitchell';
select*from customer where firstname = 'Robert' and lastname = 'Walter'; --simply checking what currently exists
*/ 

update customer set firstname = 'Robert', lastname = 'Walter' where firstname = 'Aaron' and lastname = 'Mitchell';

--select*from artist where name = 'Creedence Clearwater Revival';
--select*from artist where name = 'CCR';

update artist set name = 'CCR' where name = 'Creedence Clearwater Revival';


-- 2.5 LIKE
--Task – Select all invoices with a billing address like “T”
select * from invoice where billingaddress like 'T%';


--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50 Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from invoice where total between 15 and 50;


--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE invoice DROP 
   CONSTRAINT fk_invoicecustomerid;
  
ALTER TABLE invoice ADD 
   CONSTRAINT fk_invoicecustomerid 
      FOREIGN KEY (customerid)
      REFERENCES customer (customerid)
      ON delete cascade;

ALTER TABLE invoiceline DROP 
   CONSTRAINT FK_InvoiceLineTrackId;
     
ALTER TABLE invoiceline ADD 
   CONSTRAINT FK_InvoiceLineTraclId 
      FOREIGN KEY (invoiceid)
      REFERENCES invoice (invoiceid)
      ON delete cascade;
     
delete from customer where firstname = 'Robert' and lastname = 'Walter'; --this doesnt work because this puts the primary keys out of order


--3.0 SQL Functions----------------------------------------------------------------------------------------------------------------------------------
--In this section you will be using the PostGreSQL system functions, as well as your own functions, to perform various actions against the database


--3.1 System Defined Functions
--Task – Create a function that returns the current time. Task – create a function that returns the length of a mediatype from the mediatype table

--returns the current time
create or replace function get_current_time() 
	returns time
	as $$
	
		declare 
			current_time time;
		
		begin
			select CURRENT_TIME
			into current_time;
		
			return current_time;
		end
	$$

	language plpgsql;

select * from mediatype;

--gets length of a selected mediatype
create or replace function get_mediatype_length(id numeric)
returns numeric 
as $$
	declare
		media_length int;
	begin
		select length(name) into media_length from mediatype m where m.mediatypeid = id;
		return media_length;
		
	end
$$
language plpgsql;
 

--3.2 System Defined Aggregate Functions
--Task –Create a function that returns the average total of all invoices 
--Task – Create a function that returns the most expensive track

--average total of all invoices
create function average_invoice_totals()
	returns numeric
	as $$
		declare
			average_val numeric;
		begin
			select avg(total) into average_val from invoice;
			return average_val;
		end
		$$
	language plpgsql;

--returns a query of the most expensive tracks here
drop function most_expensive_track ;
create function most_expensive_track()
	returns table (song_name varchar)
	as $$
		declare
			max_unit_price numeric;
		begin
			select max(unitprice) into max_unit_price from track;
			return query select name
				from track
				where unitprice = max_unit_price;
		end
		$$
		language plpgsql;

select most_expensive_track();




--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoice-line items in the invoice-line table
drop function average_invoiceline_price;

--currently returns the invoiceline price average where records match the invoiceid of temp_invoice_id (input)
create function average_invoiceline_price(temp_invoice_id int)
	returns numeric
	language plpgsql
	
	as $$
		declare
			avg_price numeric;
		begin
			select avg(unitprice)
			into avg_price
			from invoiceline
			where invoiceid = temp_invoice_id;
			
			return avg_price;
		end
		$$;
	
select average_invoiceline_price(5);


--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
create function employees_after_date(given_date timestamp)
	returns table (
		last_name varchar,
		first_name varchar)
	language plpgsql
	
	as $$
		begin
			return query select lastname, firstname from employee where birthdate > given_date;
		end
	$$;

--makes a specific selection for 1968
select employees_after_date('1968-01-01 00:00:00');

	

--4.0 JOINS-------------------------------------------------------------------------------------------------------------------------------------------------------
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.


--4.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select firstname, lastname, invoiceid from customer
inner join 	invoice
on customer.customerid = invoice.customerid order by firstname asc;
 	
--4.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.
select * from customer;
select * from invoice;
select customer.customerid, firstname, lastname, invoiceid, total
from customer 
full outer join invoice
on invoice.customerid = customer.customerid
order by customerid;

--4.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
select * from artist;
select * from album;

select name, title
from album a 
right join artist r 
on a.artistid = r.artistid
order by name asc;


--4.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select * from album a 
cross join artist
order by artist.name asc;

--4.5 SELF
--Task – Perform a self-join on the employee table, joining on the reports to column.
select e1.employeeid, e1.lastname, e1.firstname, e1.reportsto from employee e1
join employee e2
on e1.reportsto= e2.employeeid;
