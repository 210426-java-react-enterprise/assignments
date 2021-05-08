--1.0
	--ran the setup code for chinook DB

--2.1 select
select * from "Employee";
select * from "Employee" where "LastName" = 'King';

--the is keyword is required for NULL checks
select * from "Employee" where "FirstName" = 'Andrew' and "ReportsTo" is NULL;

--2.2 Order By
select * from "Album" order by "Title" desc;
select "FirstName" from "Employee" order by "FirstName" asc;

--2.3 Insert into
--Had to add id manually due to the ID being non-null. I think the table isn't serializable as well
insert into "Genre" values (26, 'Techno'), (27, 'Kpop');
insert into "Employee" values (11, 'Barack', 'Obama'), (10, 'Lincoln', 'Abraham');
insert into "Customer" values (60, 'Giancarlo', 'Tomasello', 'Revature', '123 California Way', 'San Jose', 'CA', 'USA', null, null, null, 'gtomasel@mail.com'), 
(61, 'Singleton', 'Wezely', 'Revature', '456 Floridian Drive', 'Florida Town', 'FL', 'USA', null, null, null, 'WSingelton@mail.com');

--2.4 Update 
update "Customer" set "FirstName" = 'Robert', "LastName" = 'Walter' where "FirstName" = 'Aaron' and "LastName" = 'Mitchell';
update "Artist" set "Name" = 'CCR' where "Name" = 'Creedence Clearwater Revival';

--2.5 Like
select * from "Invoice" where "BillingAddress" like 'T%';

--2.6 Between
select * from "Invoice" where "Total" between 15 and 50;
select * from "Employee" where "HireDate" between '2003-06-01 00:00:00' and '2004-03-01 00:00:00';

--2.7 Delete

--To delete Rober Walter you need to delete all his associated rows in the forein tables

--At the deepest level all these Invoice Ids were associated with the customerID 32. These need to be deleted
delete from "InvoiceLine" where "InvoiceId" = 50;
delete from "InvoiceLine" where "InvoiceId" = 61;
delete from "InvoiceLine" where "InvoiceId" = 116;
delete from "InvoiceLine" where "InvoiceId" = 245;
delete from "InvoiceLine" where "InvoiceId" = 268;
delete from "InvoiceLine" where "InvoiceId" = 290;
delete from "InvoiceLine" where "InvoiceId" = 342;

--CustomerID 32 is associated with Robert Walter so it, and it's dependencies need to be deleted
delete from "Invoice" where "CustomerId" = 32;

--Once all the above filed are deleted you can now delete Robert Walter from the table
delete from "Customer" where "FirstName" = 'Robert' and "LastName" = 'Walter';

/*The better way to accomplish this is with delete cascade
 * if table doesn't have cascade set, alter table drop constraint
 * re add constraint with delete cascade
 *  */

