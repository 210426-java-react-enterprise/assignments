/* Kyle Plummer - Chinook SQL Assignment
 * set search_path to chinook;
 * show search_path
 */
--2.1 SELECT
select * from employee;

select * from employee where lastname = 'King';

select * from employee where firstname = 'Andrew' and reportsto is null;



--2.2 ORDER BY
select * from album order by albumid desc;

select firstname from customer order by firstname asc;



--2.3 INSERT INTO
insert into genre (genreid, name) 
values 
	((select genreid from genre order by genreid desc limit 1)+1, 'Dubstep'),
	((select genreid from genre order by genreid desc limit 1)+2, 'Hard House');


insert into employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
values 
	((select MAX(employeeid) from employee)+1,
	'Plummer', 'Kyle', 'Developer', 6, '1985-06-14', '2021-04-21', '1 Way st.', 'Troy', 'NY', 'US', '12180', '+ 1 (518) 555-5555', null, 'kplum@email.com'),
	((select MAX(employeeid) from employee)+2,
	'Smith', 'John', 'Developer', 6, '1985-06-14', '2021-04-21', '1 Way st.', 'Troy', 'NY', 'US', '12180', '+ 1 (518) 555-5555', null, 'jsmith@email.com');

insert into customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
values
	((select customerid from customer order by customerid desc limit 1)+1,
	'Michael', 'Jordan', 'The NBA', '21 MJ court', 'Beverly Hills', 'CA', 'US', '90210', '+ 1 (555) 555-1234', '+ 1 (555) 555-4321', '6rings@NBA.org', 3),
	((select customerid from customer order by customerid desc limit 1)+2,
	'LeBron', 'James', 'The NBA', '55 Street st', 'Beverly Hills', 'CA', 'US', '90210', '+ 1 (555) 335-1234', '+ 1 (555) 335-4321', 'SpaceJam2@NBA.org', 3);
	


--2.4 UPDATE
update customer set firstname = 'Robert', lastname = 'Walter' where customerid = 32;

update artist set name = 'CCR' where name = 'Creedence Clearwater Revival';



--2.5 LIKE
select * from invoice where billingaddress like 'T%'; --I assume we wanted to use a wild card and not just get the address 'T'



--2.6 BETWEEN
select * from invoice where total between 15 and 50;

select * from employee where hiredate between '2003-06-01' and '2004-03-01';



--2.7 DELETE
alter table invoice
drop constraint fk_invoicecustomerid,
add constraint fk_invoicecustomerid
foreign key (customerid) references customer (customerid) on delete cascade;

alter table invoiceline 
drop constraint fk_invoicelineinvoiceid,
add constraint fk_invoicelineinvoiceid
foreign key (invoiceid) references invoice (invoiceid) on delete cascade;

delete from customer where firstname = 'Robert' and lastname = 'Walter';



--3.1 SYSTEM DEFINED FUNCTIONS
create or replace function GETTIME() returns time as $$
declare
	currenttime time := (select NOW());
begin
	return currenttime;
end;
$$ LANGUAGE plpgsql;
select GETTIME();


create or replace function MEDIALENGTH() returns int as $$
declare
	medialength int := (select LENGTH((select name from mediatype limit 1)));
begin
	return medialength;
end;
$$ LANGUAGE plpgsql;
select MEDIALENGTH();



--3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
create or replace function INVOICEAVERAGE() returns numeric as $$
declare
	invoiceaverage numeric := (select AVG(total) from invoice);
begin
	return invoiceaverage;
end;
$$ LANGUAGE plpgsql;
select INVOICEAVERAGE();


create or replace function EXPENSIVETRACK() returns numeric as $$
declare
	expensivetrack numeric := (select MAX(unitprice) from track);
begin
	return expensivetrack;
end;
$$ LANGUAGE plpgsql;
select EXPENSIVETRACK();



--3.3 USER DEFINED SCALAR FUNCTIONS
create or replace function MYINVOICELINEAVERAGE() returns numeric as $$
declare
	invoicelinesum numeric := (select SUM(unitprice) from invoiceline);
	invoicelinecount numeric := (select COUNT(unitprice) from invoiceline);
begin
	return (invoicelinesum / invoicelinecount);
end;
$$ LANGUAGE plpgsql;
select MYINVOICELINEAVERAGE();



--3.4 USER DEFINE TABLE VALUED FUNCTION
create or replace function TABLEYOUNGPEOPLE() returns table (first_name varchar(20), last_name varchar(20), birthday timestamp) as $$
begin
	return query
	select firstname as first_name, lastname as last_name, birthdate as birthday
	from employee 
	where birthdate > '1968-01-01';
end;
$$ LANGUAGE plpgsql;
select * from TABLEYOUNGPEOPLE();




--4.1 INNER JOINS
select c.lastname || ', ' || c.firstname as name, i.invoiceid 
from customer c 
inner join invoice i on c.customerid = i.customerid


-- 4.2 OUTER JOINS
select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
from customer c 
full outer join invoice i on c.customerid = i.customerid


--4.3 RIGHT JOINS
select ar.name, al.title 
from artist ar
right join album al on ar.artistid = al.artistid


--4.4 CROSS JOINS
select * 
from album al
cross join artist ar
order by ar.name


--SELF JOINS
select *
from employee a 
join employee b on a.reportsto = b.employeeid 



