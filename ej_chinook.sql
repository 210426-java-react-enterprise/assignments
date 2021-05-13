/** select **/
select * from employee;
select * from employee where lastname='King';
select * from employee where firstname ='Andrew' and reportsto is null;
/** order by **/
select * from album order by albumid DESC;--ordered by id in descending
select firstname from customer order by firstname asc;--ordered alphabetically in ascending
/**inert into**/
select * from genre;
insert into genre values ((select genreid from genre order by genreid desc limit 1)+1, 'thisIsAGenre');--use max to increment id
insert into genre values ((select genreid from genre order by genreid desc limit 1)+1, 'thisIsAnotherGenre');
/**update**/
select * from artist order by name asc;
update customer set firstname = 'Robert', lastname = 'Walter' where firstname= 'Aaron' and lastname = 'Mitchell';
update artist set name = 'CCR' where artistid = 76;
/**like**/
select * from invoice where invoice.billingaddress like 'T%';
--between
select * from invoice where invoice.total between 15 and 50;
select * from employee;
select * from employee where employee.hiredate between '2003-06-01 00:00:00' and '2004-03-01 00:00:00';
--delete 
delete from customer where firstname='Robert' and lastname='Walter';
delete * from invoiceline where invoiceid in (
    select invoiceid 
    from invoice
    where customerid = 32
);
/*
 * alter invoice
   drop constraint invoiceid
   foreign key (customerid) 
   references customer (customerid)
   ON DELETE CASCADE*/

select * from invoice where customerid = 32;
--system functions
select current_time ;
select length((select name from mediatype where mediatypeid = 1)) as lengthofstring;
--system aggregate functions
select avg(total) from invoice;
select max(unitprice) from chinook.track;
--user defined functions ASK FOR HELP
create function average returns dec(10,2) as
begin 
	return average(unitprice) from chinook.invoiceline;
	
end;
select * from chinook.employee;
select average()
--table valued udf
create function udfEmployeeAgeRange(@employee_birthdate)
returns table as select birthdate from chinook.employee where birthdate > '1968%';
--inner join
select * from invoice;
select invoice.invoiceid, customer.firstname  from invoice inner join  customer on invoice.customerid = customer.customerid;
--outer join
select customer.customerid,firstname,lastname,invoiceid,total from customer full outer join invoice on customer.customerid = invoice.customerid;
--right join
select title, name from artist right join album using (artistid);
set search_path = chinook;
--cross join
select artist.name from artist cross join album;
--self
select report from employee on T1 self join employee.table


