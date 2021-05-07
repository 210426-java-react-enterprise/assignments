--Task – Select all records from the Employee table.
select * from "Employee";

--Task – Select all records from the Employee table where last name is King.
select * from "Employee" 
where "LastName" = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from "Employee" 
where "FirstName" = 'Andrew' 
and "ReportsTo" isnull; 

--Task – Select all albums in album table and sort result set in descending order
select * from "Album" 
order by "AlbumId" DESC;

--Task – Select first name from Customer and sort result set in ascending order
select "FirstName" from "Customer" 
order by "FirstName";

--Task – Insert two new records into Genre table
insert into "Genre" 
values (26, 'Indie'), (27, 'Showtunes');

--Task – Insert two new records into Employee table
insert into "Employee" ("EmployeeId", "LastName", "FirstName", "Email") 
values (9, 'Smith', 'Charles', 'mynameisgeneric@gmail.com'), (10, 'Bukowski', 'Genevieve', 'mynameisnotgeneric@gmail.com');

--Task – Insert two new records into Customer table
insert into "Customer" ("CustomerId", "FirstName", "LastName", "Email") 
values (60, 'Jessica', 'Franklin', 'jfrank12@hotmail.com'), (61, 'Taylor', 'Anderson', 'tayland92@outlook.com');

--Task – Update Aaron Mitchell in Customer table to Robert Walter
update "Customer" 
set ("FirstName", "LastName")=('Robert', 'Walter') 
where ("FirstName","LastName")=('Aaron', 'Mitchell');

--Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
update "Artist" set "Name" = 'CCR' 
where "Name" = 'Creedence Clearwater Revival';

--Task – Select all invoices with a billing address like “T”
select * from "Invoice" 
where "BillingAddress" like 'T%';

--Task – Select all invoices that have a total between 15 and 50
select * from "Invoice" 
where "Total" >= 15 and "Total" <= 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from "Employee" 
where "HireDate" >= '2003-06-01 00:00:00' 
and "HireDate" <= '2004-03-01 23:59:59';

--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
alter table "Invoice" 
drop constraint "FK_InvoiceCustomerId", 
add constraint "FK_InvoiceCustomerId" 
foreign key ("CustomerId") 
references "Customer" ("CustomerId") 
on delete cascade;

alter table "InvoiceLine" 
drop constraint "FK_InvoiceLineInvoiceId", 
add constraint "FK_InvoiceLineInvoiceId" 
foreign key ("InvoiceId") 
references "Invoice" ("InvoiceId") 
on delete cascade;

delete from "Customer" 
where ("FirstName", "LastName")=('Robert','Walker');

/* Sorry but this just isn't possible with less than three statements. Cascade delete
 * only affects direct child tables and not grandchild tables, so just changing the foreign
 * key of Invoice still causes an error as InvoiceLine has reecords dependent on the records
 * which themselves are dependent on the records in Customer. There's no way I could find to
 * to make deleting a Customer record to cascade both to the child that references it and the grandchild
 * that references that.*/
 
--Task – Create a function that returns the current time.
create function get_time() returns time with time zone language plpgsql as 
$$
begin 
	return current_time;
end
$$;

select get_time();

-- Task – create a function that returns the length of a mediatype from the mediatype table
create function media_length(media_id int) returns int language plpgsql as $length$
declare
	media_name varchar(120);
begin
	select "Name" from "MediaType"
	into media_name
	where "MediaTypeId" = media_id;
	return length(media_name);
end
$length$;

select media_length(1);

-- Task –Create a function that returns the average total of all invoices
create function invoice_average() returns numeric(10,2) language plpgsql as $avg$
begin
	return avg("Total")
	from "Invoice";
end;
$avg$

select invoice_average();

--Task – Create a function that returns the most expensive track
create function track_max() returns table(track_name varchar(200), unit_price numeric(10,2)) language plpgsql as $max$
declare 
	max_price numeric(10,2);
begin
	select max("UnitPrice") 
	into max_price
	from "Track";

	return query
	select "Name", "UnitPrice"
	from "Track"
	where "UnitPrice" = max_price;
end;
$max$

select track_max();

-- Task – Create a function that returns the average price of invoice-line items in the invoice-line table
create function average_invoice_line_price() 
returns numeric(10,2) language plpgsql as $$
declare
	current_record record;
	total_price numeric(10, 2) := 0;
	total_num int := 0;
begin
	for current_record in select * from "InvoiceLine"
	loop
	total_price := total_price + current_record."UnitPrice";
	total_num := total_num + 1;
	end loop;

return total_price/total_num;
end;
$$

select average_invoice_line_price();

-- Task – Create a function that returns all employees who are born after 1968.
create function employees_after_1968() 
returns table(EmployeeId int, LastName varchar(20), FirstName varchar(20), Title varchar(30), ReportsTo int, BirthDate timestamp, HireDdate timestamp, Address varchar(70), City varchar(40), State varchar(40), Country varchar(40), PostalCode varchar(10), Phone varchar(24), Fax varchar(24), Email varchar(60))
language plpgsql as $$
begin
	return query
	select * from "Employee"
	where "BirthDate" >= '1968-01-01 00:00:00';
end;
$$

select employees_after_1968();

-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select "FirstName","LastName","InvoiceId"
from "Customer"
inner join "Invoice"
on "Customer"."CustomerId" = "Invoice"."CustomerId";

-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.
select "Customer"."CustomerId", "FirstName", "LastName", "InvoiceId", "Total"
from "Customer"
full join "Invoice"
on "Customer"."CustomerId" = "Invoice"."CustomerId";

-- Task – Create a right join that joins album and artist specifying artist name and title.
select "Title", "Name"
from "Album"
right join "Artist"
on "Album"."ArtistId" = "Artist"."ArtistId";

--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select * 
from "Album"
cross join "Artist"
order by "Name";

-- Task – Perform a self-join on the employee table, joining on the reports to column.
select E2."FirstName" || ' ' || E2."LastName" as Employee,
E1."FirstName" || ' ' || E1."LastName" as Supervisor,
from "Employee" E1
inner join "Employee" E2
on E1."EmployeeId" = E2."ReportsTo";