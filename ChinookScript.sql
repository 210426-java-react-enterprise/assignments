--set search_path to chinook;
--show search_path;
--select current_user;

--1.0 Setting up Chinook, the longest process in the world.
--2.0 SQL Queries
--2.1 SELECT
select * from "Employee";
select * from "Employee" where "LastName" = 'King';
select * from "Employee" where "FirstName" = 'Andrew' and "ReportsTo"  is null;

--2.2 ORDER BY
select * from "Album" order by "Title" desc; -- Instructions vague, descending by Title or AlbumId?
select * from "Customer" order by "FirstName" asc;

--2.3 INSERT INTO
select * from "Genre";
insert into "Genre" values (26, 'K-pop');
insert into "Genre" values (27, 'Bachata');

select * from "Employee";
insert into "Employee" ("EmployeeId", "LastName", "FirstName") values (9, 'Tyson', 'Mike');
insert into "Employee" ("EmployeeId", "LastName", "FirstName") values (10, 'Clay', 'Cassius');

select * from "Customer";
insert into "Customer" ("CustomerId", "FirstName", "LastName", "Phone", "Email") values (60, 'Katy', 'Perry', '+1 (605) 475-6968', 'katy.perry@singer.com');
insert into "Customer" ("CustomerId", "FirstName", "LastName", "Phone", "Email") values (61, 'Jennifer', 'Lopez', '+1 (646) 926-6614', 'jennifer.lopez@actress.net');

--2.4 UPDATE
select * from "Customer";
update "Customer" set "FirstName" = 'Robert', "LastName" = 'Walter' where ("FirstName"='Aaron' and "LastName"='Mitchell');

select * from "Artist";
update "Artist" set "Name" = 'CCR' where "Name" = 'Creedence Clearwater Revival';

--2.5 LIKE
select * from "Invoice" where "BillingAddress" like 'T%';

--2.6 BETWEEN
select * from "Invoice" where "Total" between 15 and 50;
select * from "Employee" where "HireDate" between '2003-06-01' and '2004-03-01'

--2.7 DELETE
select * from "Customer" where "FirstName" = 'Robert' and "LastName" = 'Walter'; -- line 32, Customer -- CustomerId = 32
select * from "Invoice" where "CustomerId" = 32; -- line 50, Invoice
alter table "Invoice" drop constraint "FK_InvoiceCustomerId";
alter table "Invoice" with check add constraint "FK_InvoiceCustomerId" foreign key "CustomerId" references "Customer"."CustomerId" on delete cascade;

alter table "InvoiceLine" drop constraint "FK_InvoiceLineInvoiceId";
alter table "InvoiceLine" with check add constraint "FK_InvoiceLineInvoiceId" foreign key "InvoiceId" references "Invoice"."InvoiceId" on delete cascade;

delete from "Customer" where "FirstName" = 'Robert' and "LastName" = 'Walter';

--3.0 SQL Functions
--3.1 System Defined Functions
select current_timestamp; -- alternatively "select current_timestamp();" where it includes date
select "Name", length("Name") from "MediaType";

--3.2 System Defined Aggregate Functions
select avg("Total") as "Average Total of All Invoices" from "Invoice" ;
select "TrackId", "Name", "UnitPrice" from "Track" where "UnitPrice" = (select max("UnitPrice") from "Track");

--3.3 User Defined Scalar Functions
create function returnAvgPriceInvoiceLine("UnitPrice" decimal) 
returns numeric as $$ select avg("UnitPrice")  from "InvoiceLine"; $$ language sql;
--for more info, see https://www.postgresql.org/docs/current/xfunc-sql.html

--3.4 User Defined Table Valued Functions
create or replace function returnEmployeesBornAfter1968()
returns table ("EmployeeId" int, "FirstName" varchar, "LastName" varchar, "BirthDate" timestamp)
language plpgsql as $$
begin
	return query
	select "EmployeeId", "FirstName", "LastName", "BirthDate"
	from "Employee"
	where "BirthDate" >= '1969-01-01 00:00:00';
end;$$
--for more info, see https://www.postgresqltutorial.com/plpgsql-function-returns-a-table/

--4.0 Joins
--4.1 INNER
select "FirstName", "LastName", "InvoiceId" from "Customer" inner join "Invoice"
on "Customer"."CustomerId" = "Invoice"."CustomerId";

--4.2 OUTER
select "Customer"."CustomerId", "FirstName", "LastName", "InvoiceId", "Total" from "Customer" full outer join "Invoice" 
on "Customer"."CustomerId" = "Invoice"."CustomerId";

--4.3 RIGHT
select "Name", "Title" from "Artist" right join "Album"
using ("ArtistId");

--4.4 CROSS


--4.5 SELF
