--Removed double quotes from original linked script in assignment

set search_path to chinook;
show search_path;

--Task 2.1
--Select all records from the Employee table.
select * from employee;
--Select all records from the Employee table where last name is King.
select * from employee where lastname = 'King';
--Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from employee where firstname = 'Andrew' and reportsto is null;

--Task 2.2
--Select all albums in album table and sort result set in descending order(by albumid)
select * from album order by albumid desc;
--Select first name from Customer and sort result set in ascending order
select firstname from customer order by firstname asc;

--Task 2.3
--Insert two new records into Genre table
insert into genre (genreid, name) values ((select max(genreid) from genre)+1, N'Techno');
insert into genre (genreid, name) values ((select max(genreid) from genre)+1, N'Ska');
--Insert two new records into Employee table
insert into employee (employeeid, lastname, firstname) values ((select max(employeeid) from employee)+1, N'Chin', N'Vinson');
insert into employee (employeeid, lastname, firstname) values ((select max(employeeid) from employee)+1, N'Doe', N'John');
--Insert two new records into Customer table
insert into customer (customerid, firstname, lastname, email) values ((select max(customerid) from customer)+1, N'Vinson', N'Chin', N'v.chin@revature.net');
insert into customer (customerid, firstname, lastname, email) values ((select max(customerid) from customer)+1, N'Jane', N'Doe', N'j.doe@gmail.com');

--Task 2.4
--Update Aaron Mitchell in Customer table to Robert Walter
update customer set firstname = N'Robert', lastname = N'Walter' where firstname = N'Aaron' and lastname = N'Mitchell';
--Update name of artist “Creedence Clearwater Revival” to “CCR”
update artist set name = N'CCR' where name = N'Creedence Clearwater Revival';

--Task 2.5 - Select all invoices with a billing address like “T”
select * from invoice where billingaddress like 'T';

--Task 2.6
--Select all invoices that have a total between 15 and 50
select * from invoice where total between 15 and 50;
--Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee where hiredate between '2003/6/1' and '2004/3/1';

--Task 2.7 - Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
alter table invoice drop constraint fk_invoicecustomerid;
alter table invoice add constraint fk_invoicecustomerid foreign key (customerid) REFERENCES customer(customerid) ON DELETE cascade;
alter table invoiceline drop constraint fk_invoicelineinvoiceid;
alter table invoiceline add constraint fk_invoicelineinvoiceid foreign key (invoiceid) REFERENCES invoice(invoiceid) ON DELETE cascade;
delete from customer where firstname = 'Robert' and lastname = 'Walter';

--Task 3.1
--Create a function that returns the current time.
select current_time;
--create a function that returns the length of a mediatype from the mediatype table
select length(name) from mediatype where mediatypeid = 1;

--Task 3.2
--Create a function that returns the average total of all invoices
select avg(all total) from invoice;
--Create a function that returns the most expensive track
select * from track where unitprice = (select max(unitprice) from track);

--Task 3.3 - Create a function that returns the average price of invoice-line items in the invoice-line table
create or replace function average_invoiceline_price ()
returns numeric as 
$$
begin
	return ((select sum(unitprice) from invoiceline) / (select count(*) from invoiceline));
end $$
language plpgsql;
select average_invoiceline_price();

--Task 3.4 - Create a function that returns all employees who are born after 1968.
create or replace function employee_after_1968 ()
returns table(EmployeeId int,
    		  LastName varchar,
    		  FirstName varchar,
    		  Title varchar,
    		  ReportsTo int,
    		  BirthDate timestamp,
    		  HireDate timestamp,
    		  Address varchar,
    		  City varchar,
    		  State varchar,
    		  Country varchar,
    		  PostalCode varchar,
    		  Phone varchar,
    		  Fax varchar,
    		  Email varchar)
as $$
begin
	return query (select * from employee where (select extract(year from (select date(employee.birthdate))) > 1968));
end $$
language plpgsql;
select * from employee_after_1968();

--Task 4.1 - Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select c.firstname, c.lastname, i.invoiceid from customer c join invoice i on c.customerid = i.customerid;

--Task 4.2 - Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total
select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total from customer c left join invoice i on c.customerid = i.customerid;

--Task 4.3 - Create a right join that joins album and artist specifying artist name and title.
select a.name, a2.title from artist a right join album a2 on a.artistid = a2.artistid;

--Task 4.4 - Create a cross join that joins album and artist and sorts by artist name in ascending order.
select a.name from artist a cross join album a2 order by a.name asc;

--Task 4.5 - Perform a self-join on the employee table, joining on the reports to column.
select * from employee e, employee e2 where e.reportsto = e.reportsto;