--2.1
select * from "Employee";
select * from "Employee" where "LastName" = 'King';
select * from "Employee" where "FirstName" = 'Andrew'
     and "ReportsTo" IS NULL;

--2.2
select * from "Album" order by "AlbumId" desc;
select "FirstName" from "Customer" order by "FirstName" asc;

--2.3
insert into "Genre"("GenreId", "Name") values(26, 'Ska'), (27, 'Spoken Word');
insert into "Employee"("EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", "BirthDate", "HireDate",
			"Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email")
values(9, 'McGraw', 'Scruff', 'Fighter of Crime', 5, '1962-02-18 00:00:00', '1962-02-18 00:00:00',
		'222 Boomerang Way', 'someplace', 'somewhere', 'idk', 'T43 F7Q', '+1 (555) 555-5555', '+1 (555) 555-5555',
		'scruffy@planetexpress.xyz'),
	  (10, 'Dingus', 'Bingus', 'Redacted', 3, '1962-02-18 00:00:00', '1962-02-18 00:00:00',
		'222 Boomerang Way', 'somepalce', 'somewhere', 'idk', 'T43 F7Q', '+1 (555) 555-5555', '+1 (555) 555-5555',
		'dingus@help.me');
insert into "Customer"("CustomerId", "FirstName", "LastName", "Company", "Address", "City", "State",
						"Country", "PostalCode", "Phone", "Fax", "Email", "SupportRepId")
values(60, 'Jim', 'Bob', 'NotReal', '555 Someplace ct', 'Chatanooga', 'TN', 'US',
		55555, '+1 (638) 555-5555', '+1 (638) 555-5555', 'jim.bob@bobjim.org', 2),
	(61, 'Bob', 'Jim', 'MaybeReal', '555 Fakeplace ct', 'Narnia', 'Narn', 'NA',
		55555, '+1 (638) 555-5555', '+1 (638) 555-5555', 'bob.jim@jimbob.org', 1);

--2.4
update "Customer" 
set "FirstName" = 'Robert',
	"LastName" = 'Walter'
where "CustomerId" = 32;
update "Artist" 
set "Name" = 'CCR'
where "Name" = 'Creedence Clearwater Revival';

--2.5
select * from "Invoice" where "BillingAddress" like 'T%';

--2.6
select * from "Invoice" where "Total" between 15 and 50;
select * from "Employee" where "HireDate" between '2003-05-01' and '2004-03-01';

--2.7


ALTER TABLE "Invoice"
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

--3.1
select current_time;
select length("Name") as "Media_Type_Name_Length" from "MediaType";

--3.2
select AVG("Total")
from "Invoice";
select * from "Track"
where "UnitPrice" = (
   select max ("UnitPrice")
   from "Track"
);

--3.3
create or replace function get_invoice_line_average(invoice_Id int)
returns numeric
language plpgsql
as
$$
declare
   average_cost numeric;
begin
   select avg("UnitPrice") 
   into average_cost
   from "InvoiceLine"
   where "InvoiceId" = invoice_id;
  
   return average_cost;
end;
$$;
select avg("UnitPrice") from "InvoiceLine" where "InvoiceId" = 5;
select get_invoice_line_average(5);

--3.4
create or replace function get_employees_born_before_1968()
	returns table (
		employee_id int,
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

--4.1
select "FirstName", "LastName", "InvoiceId"
from "Customer"
inner join "Invoice" on "Invoice"."CustomerId" = "Customer"."CustomerId";

--4.2
select "Customer"."CustomerId", "FirstName", "LastName", "InvoiceId", "Total"
from "Customer"
full outer join "Invoice" on "Invoice"."CustomerId" = "Customer"."CustomerId";

--4.3
select "Name", "Title"
from "Artist"
right join "Album" using ("ArtistId");

--4.4
select *
from "Artist", "Album"
order by "Name" asc;

--4.5

select employee_1."FirstName", employee_2."FirstName", employee_1."ReportsTo"
from "Employee" employee_1
inner join "Employee" employee_2
    on employee_1."EmployeeId" <> employee_2."EmployeeId"
    and employee_1."ReportsTo" = employee_2."ReportsTo";

