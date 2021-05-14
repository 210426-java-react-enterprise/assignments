--set search_path to chinook;
--show search_path;

--2.1 select 
select * from "Employee";
select * from "Employee" where "LastName" = 'King';
select * from "Employee" where ("FirstName" = 'Andrew' and "ReportsTo" is null);
--2.2 order by
select * from "Album" order by "AlbumId" desc;
select "FirstName" from "Customer" order by "CustomerId" asc;
--2.3 insert into
insert into "Genre"("GenreId", "Name")
values
(26, 'rap metal'),
(27, 'modern jazz');

insert into "Employee"("EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email")
values
(9, 'Singleton', 'Wezley', 'Trainer', 1, '1991-01-01', '2015-01-01', '1 1st St', 'Tampa', 'Florida', 'United States', '09988', '+1(555) 555-5555', '+1(555) 555-5554', 'WSingleton@revature.net' ),
(10, 'Fallon', 'James', 'Developer', 9, '1992-04-29', '2015-01-01', '2 1st St', 'Oakhurst', 'New Jersey', 'United States', '07755', '+1(555) 555-5556', '+1(555) 555-5556', 'Jfallon@revature.net' );

insert into "Customer"("CustomerId", "FirstName", "LastName", "Company", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email", "SupportRepId")
values
(60, 'John', 'Smith', 'Revature', '2 2nd St', 'Miami', 'Florida', 'United States', '08888', '+1(555) 555-6745', '+1(567) 555-6433', 'jsmith@gmail.com', 5),
(61, 'Jane', 'Smith', 'Revature', '2 2nd St', 'Miami', 'Florida', 'United States', 'O8888', '+1(555) 555-6743', '+1(567) 555-6433', 'jsmith2@gmail.com', 5);
--2.4 update
update "Customer" set "FirstName" = 'Robert' where "FirstName" = 'Aaron';
update "Customer" set "LastName" = 'Walter' where "LastName" = 'Mitchell';
--2.5 Like
select * from "Invoice" where "BillingAddress" like 'T';
--2.6 Between
select * from "Invoice" where "Total" between 15 and 50;
select * from "Employee" where "HireDate" between '2003-06-01' and '2004-03-01';
--2.7 Delete
alter table "Invoice" drop constraint "FK_InvoiceCustomerId";
alter table "Invoice" add constraint "FK_InvoiceCustomerId" foreign key ("CustomerId") references "Customer"("CustomerId") on delete cascade;
alter table "InvoiceLine" drop constraint "FK_InvoiceLineInvoiceId";
alter table chinook."InvoiceLine" add constraint "FK_InvoiceLineInvoiceId" foreign key ("InvoiceId") references chinook."Invoice"("InvoiceId") on delete cascade;
delete from "Customer" where "FirstName" = 'Robert' and "LastName" = 'Walter';
--3.1 System Defined Functions
select current_timestamp;
select length("Name") from "MediaType" where "MediaTypeId" = 1; 
--3.2 System Defined Aggregate Functions
select avg("Total") from "Invoice"; 
select * from "Track" where "UnitPrice" = (select max("UnitPrice") from "Track"); 
--3.3 User Defined Table Valued Functions
select avg("UnitPrice") from "InvoiceLine";
--3.4 User Defined Table Valued Functions
select * from "Employee" where  "BirthDate" > '1968-12-31';
--4.1  Inner
select "FirstName", "LastName", "InvoiceId"
from "Invoice"
inner join "Customer"
on "Customer"."CustomerId" = "Invoice"."CustomerId";
--4.2 Outer
select *
from "Invoice"
full outer join "Customer"
on "Customer"."CustomerId" = "Invoice"."CustomerId";
--4.3 Right
select "Name", "Title"
from "Artist"
right join "Album"
on "Album"."ArtistId" = "Artist"."ArtistId";
--4.4 Cross
select * 
from "Album" 
cross join "Artist" order by "Name" asc;
--4.5 Self
select E."FirstName", E."LastName", E."EmployeeId", R."FirstName", R."LastName", R."EmployeeId"  
from "Employee"  E
left join "Employee" R
on E."ReportsTo" = R."EmployeeId"; 
