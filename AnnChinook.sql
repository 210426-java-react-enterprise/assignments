Ann Chinook


2.1 SELECT
- Select all from employee table in chinook----------------------------------------------------------------------------------------------------------------------------
SELECT * FROM employee;

--–Select all records from the Employee table where last name is King.--------------------------------------------------------------------------------------------------
SELECT firstname, lastname 
FROM employee
WHERE lastname = 'King';

--Select all records from the Employee table where first name is Andrewand REPORTSTOis NULL.----------------------------------------------------------------------------

SELECT * FROM employee
WHERE firstname = 'Andrew' AND reportsto IS NULL;



2.2 order BY

--Select all albumsin Albumtable and sort result set in descending orderby title.---------------------------------------------------------------------------------------

SELECT * FROM album 
ORDER BY title DESC;

--–Select first name from Customerand sort result set in ascending orderbycity-----------------------------------------------------------------------------------------

SELECT firstname FROM customer
ORDER BY city ASC;


2.3 insert to
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Insert two new records into Genre table-----------------------------------------------------------------------------------------------------------------------------

INSERT INTO genre VALUES(66,'Hip Hop');
INSERT INTO genre VALUES(67,'Pop');

- Insert two new records into Employee table-----------------------------------------------------------------------------------------------------------------------------
INSERT INTO employee (city, state) VALUES('miami','florida');
INSERT INTO employee (LastName, FirstName) VALUES('charles','Ann');

- Insert two new records into Customer table-----------------------------------------------------------------------------------------------------------------------------
INSERT INTO records (State, Country) VALUES('Florida','US');
INSERT INTO records (PostalCode, Phone) VALUES('PostalCode','7869426081');


2.4 UPDATE
--– Update AaronMitchellin Customertable to Robert Walter--------------------------------------------------------------------------------------------------------------

UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname= 'Mitchell';
commit;

-- Update name of artist in the Artist table“Creedence Clearwater Revival” to “CCR”-------------------------------------------------------------------------------------

Update artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';




2.5 LIKE
-- Select all invoiceswith a billing addresslike “T”--------------------------------------------------------------------------------------------------------------------

SELECT billingaddress FROM invoice
WHERE billingaddress LIKE 'T';


2.6 BETWEEN
--Select all invoicesthat have a totalbetween 15and 50

SELECT total FROM invoice
WHERE total > 15 AND total < 50;

--Select all employees hired between 1stof June 2003 and 1stof March 2004

SELECT firstname, lastname, hiredate FROM employee
WHERE hiredate > TO_DATE(20030601,'YYYYMMDD') AND hiredate < TO_DATE(20040301,'YYYYMMDD');


2.7 DELETE

--Delete a record in Customertable where the name is Robert Walter(There may be constraints that rely on this, find out how to resolve them).
--Delete from the parent tables first..

DELETE FROM invoiceline WHERE invoiceid = 50 OR invoiceid= 61 OR invoiceid= 116 OR invoiceid= 245 OR invoiceid=268 OR invoiceid= 290 OR invoiceid= 342;
DELETE FROM invoice WHERE customerid =32;
DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter'; or






3.1 defined FUNCTIONS
-- Create a query that leverages a sys-defined function that returns the current time
SELECT chinook.get_current_time FROM DUAL;

-- create a query that leverages a sys-defined function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(name) as "Number of Chars" FROM mediatype;


3.2 AGREGGATE functions
-- Create a query that leverages a sys-defined function that returns the average total of all invoices
SELECT AVG(total) as "Average For Invoices" FROM invoice;

-- Create a query the leverages a sys defined function that returns the most expensive track
SELECT name,MAX(unitprice) FROM track;



3.3 SCALAR FXNS

-- Create a function that returns the average priceof invoiceline itemsin the invoiceline table
SELECT AVG(unitprice) as "Average Price Of Items" FROM invoiceline;


3.4 VALUED FXNS
-- Create a function that returns all employees who are born after 1968

SELECT firstname,lastname, birthdate FROM employee 
Where birthdate > TO_DATE('1968','YYYY');



4.1 INNER
--Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId

SELECT customer.firstname,customer.lastname, invoice.invoiceid FROM customer INNER JOIN invoice on customer.customerid = invoice.customerid;

4.2 OUTER

--– Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid,invoice.total FROM 
customer FULL OUTER JOIN invoice on customer.customerid = invoice.customerid;


4.3 RIGHT
--– Create a right join that joins album and artist specifying artist name and title.

SELECT artist.name,album.title FROM artist RIGHT OUTER JOIN Album ON artist.artistid = album.artistid;


4.4 CROSS

-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT 
album.TITLE,
artist.name
FROM artist 
CROSS JOIN album;

COMMIT;


4.5 SELF

--– Perform a self-join on the employee table, joining on the reportsto column.

SELECT e1.firstname, e1.lastname, e2.reportsto FROM employee ;

