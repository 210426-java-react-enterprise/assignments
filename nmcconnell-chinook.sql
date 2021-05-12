--2.1 SELECT

select * from "Employee";

select * from "Employee" where "LastName" = 'King';

select * from "Employee" where "FirstName" = 'Andrew' and "ReportsTo" = null;

--2.2 ORDER BY

select * from "Album" order by "AlbumId" desc;

select "FirstName" from "Customer" order by "FirstName";

--2.3 INSERT INTO

select * from "Genre";

insert into "Genre" values (26, 'Nix Mix'), (27, 'Nicks sweet toons');

select * from "Employee";

insert into "Employee"("EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", "BirthDate", "HireDate",
			"Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email")
values(9, 'McConnell', 'Nick', 'Developer', 5, '1984-05-22 00:00:00', '1984-05-22 00:00:00',
		'56 street Way', 'dallas', 'TX', 'us', '54684', '+1 (555) 555-5555', '+1 (555) 555-5555',
		'nick@nick.com'),
	  (10, 'McConnell', 'Jackson', 'Fetcher', 3, '2015-05-01 00:00:00', '2021-04-26 00:00:00',
		'13 Dog Bone Way', 'Philly', 'PA', 'USA', '31245', '+1 (555) 555-5555', '+1 (555) 555-5555',
		'dog@dog.com');

	insert into "Customer"
values(60, 'Nick', 'McConnell', 'Revature', '25 little St', 'River Styx', 'PA', 'US',
		65458, '+1 (444) 444-4444', '+1 (554) 345-3456', 'nick@nick.com', 2),
	(61, 'Jackson', 'Dog', 'The Couch', '2334 nicks Apt lane', 'philly', 'pa', 'USA',
		98745, '+1 (456) 734-4765', '+1 (235) 866-4563', 'dog@dog.com', 1);
	
--2.4 UPDATE
	update "Customer" 
set "FirstName" = 'Robert',
	"LastName" = 'Walter'
where "CustomerId" = 32;

update "Artist" 
set "Name" = 'CCR'
where "Name" = 'Creedence Clearwater Revival';

--2.5 LIKE

select * from "Invoice" where "BillingAddress" like 'T%';

--2.6 BETWEEN

select * from "Invoice" where "Total" between 15 and 50;

select * from "Employee" where "HireDate" between '2003-05-01' and '2004-03-01';

--2.7 DELETE

DROP CONSTRAINT "FK_InvoiceCustomerId",
ADD CONSTRAINT "FK_InvoiceCustomerId"
   FOREIGN KEY ("CustomerId")
   REFERENCES "Customer"("CustomerId")
   ON DELETE CASCADE;
  
ALTER TABLE "InvoiceLine"
DROP CONSTRAINT "FK_InvoiceLineInvoiceId",
ADD CONSTRAINT "FK_InvoiceLineInvoiceId"
   FOREIGN KEY ("InvoiceId")
   REFERENCES "Invoice"("InvoiceId")
   ON DELETE CASCADE;

delete from "Customer" where "FirstName" = 'Robert' and "LastName" = 'Walter';

--3.1 System Defined Functions

select current_time;

select length("Name") as "Media_Type_Name_Length" from "MediaType";


--3.2 System Defined Aggregate Functions

select AVG("Total")
from "Invoice";

select * from "Track"
where "UnitPrice" = (
   select max ("UnitPrice")
   from "Track"
);


--3.3 User Defined Scalar Functions

create or replace function get_invoiceline_avg(Invoice_Id int)
returns numeric
language plpgsql
as
$$
declare
   avg_cost numeric;
begin
   select avg("UnitPrice") 
   into avg_cost
   from "InvoiceLine"
   where "InvoiceId" = Invoice_id;
  
   return avg_cost;
end;
$$;

select avg("UnitPrice") from "InvoiceLine" where "InvoiceId" = 5;

select get_invoiceline_avg(5);

--3.4 User Defined Table Valued Functions

create or replace function get_employees_born_before_1968()
	returns table (
		emp_id int,
		first_name text,
		last_name text
	) 
	language plpgsql
as $$
begin
	return query 
		select
			"EmployeeId"::integer,
			"FirstName"::text,
			"LastName"::text
		from
			"Employee"
		where
			"BirthDate" >= '1968-01-01' and "BirthDate" < '1969-01-01';
end;$$

select * from get_employees_born_before_1968();

--4.1 INNER


select "FirstName", "LastName", "InvoiceId"
from "Customer"
inner join "Invoice" on "Invoice"."CustomerId" = "Customer"."CustomerId";

--4.2 OUTER

select "Customer"."CustomerId", "FirstName", "LastName", "InvoiceId", "Total"
from "Customer"
full outer join "Invoice" on "Invoice"."CustomerId" = "Customer"."CustomerId";

--4.3 RIGHT

select "Name", "Title"
from "Artist"
right join "Album" using ("ArtistId");


