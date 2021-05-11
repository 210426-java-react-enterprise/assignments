--Chinook assignment
--Completed by: Everett Diuguid
--May 10, 2021

select * from invoice;
--2.1
select * from employee;
select * from employee where lastname='King';
select * from employee where firstname = 'Andrew' and reportsto is null;

--2.2
select * from album order by albumid desc;
select firstname from customer order by firstname;

--2.3
insert into genre values(26, 'Jam Band'), (27, 'Corner Space Jazz');
insert into employee (employeeid, lastName, firstName, email) values(9, 'Jones', 'George', 'george.jones@gmail.com'), (10, 'Frank', 'George', 'george.frank@gmail.com');
insert into customer (customerid, firstname, lastname, email) values(60, 'John', 'Jenkins', 'john.jenkins@gmail.com'), (61, 'John', 'Jenk', 'john.jenk@gmail.com');

select * from customer;
--2.4
update customer set firstname='Robert', lastname='Walter' where lastname='Mitchell';
update artist set name = 'CCR' where name = 'Creedence Clearwater Revival';

--2.5
select * from invoice where billingaddress like 'T%';

--2.6
select * from invoice where total >= 15 and total <= 50;
select * from employee where hiredate >= '2003-06-01 00:00:00' and hiredate <= '2004-03-01 23:59:59';

--2.7
alter table invoice 
drop constraint fk_invoicecustomerid, 
add constraint fk_invoicecustomerid foreign key (customerid) references customer (customerid) on delete cascade;

alter table invoiceline 
drop constraint fk_invoicelineinvoiceid, 
add constraint fk_invoicelineinvoiceid foreign key (invoiceid) references invoice (invoiceid) on delete cascade;

delete from customer where firstname='Robert' lastname='Walker';

--3.1
create or replace function get_time() returns time as
$$ 
begin
	return current_time;
end
$$
language plpgsql;
select get_time();


create or replace function get_length(media_id int) returns int as $$
declare
	media varchar(50);
begin
	select name from mediatype
	into media
	where mediatypeid = media_id;
	return length(media);
end
$$

language plpgsql;

select get_length(1);

--3.2
create or replace function invoice_average() returns numeric as $$
begin
	return avg(total) from invoice;
end;
$$ language plpgsql;
select invoice_average();

select* from track;
create or replace function most_expensive() returns varchar as $$
declare 
	most_exp numeric;
	track_name varchar;
begin
	select max(unitprice) into most_exp from track;
	select name from track where unitprice=most_exp into track_name; 

	return track_name; 
end
$$ language plpgsql;
select most_expensive();

--3.3
select * from invoiceline;

create or replace function average_total() returns numeric as $$
declare
	count_inv numeric; 
	sum_inv numeric; 
begin
	select count(invoiceid) from invoiceline into count_inv;
	select sum(unitprice) from invoiceline into sum_inv;
	
	return sum_inv/count_inv;
end;
$$ language plpgsql;

select average_total();
end

--3.4
select * from employee;
create or replace function get_birthdays() returns table (first_name varchar(50), last_name varchar(50), birthday timestamp) as $$
begin
	return query
	select firstname as first_name, lastname as last_name, birthdate as birthday
	from employee 
	where birthdate > '1968-01-01';
end;
$$ LANGUAGE plpgsql;
select * from get_birthdays();

--4.1
select firstname, lastname, invoiceid from customer 
inner join invoice on customer.customerid = invoice.customerid;

--4.2
select customer.customerid, firstname, lastname, invoiceid, total from customer 
full join invoice on customer.customerid = invoice.customerid;

--4.3
select title, name from album 
right join artist on album.artistid = artist.artistid;

--4.4
select * from album
cross join artist order by name;

--4.5
select t1.firstname from employee t1
join employee t2 on t2.employeeid = t1.reportsto;






