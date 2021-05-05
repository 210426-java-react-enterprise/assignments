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