

--2.1 All employees
SELECT * FROM "Employee";
--2.1 Employees with last name King
SELECT * FROM "Employee" WHERE "LastName" = 'King';
--2.1 Andrews who do not report
SELECT * FROM "Employee" WHERE "FirstName" = 'Andrew' AND "ReportsTo" = NULL;

--2.2 All albums in descending order
SELECT * FROM "Album" ORDER BY "Title" DESC;
--2.2 First names of customer's in asscending order
SELECT "FirstName" FROM "Customer" order BY "FirstName" ASC;

--2.3 Insert 2 new genres
INSERT INTO "Genre" ("Name")
VALUES ('emo western'), ('mathcore');
--2.3 Insert 2 new customers
SELECT * FROM "Customer";
INSERT INTO "Customer" ("FirstName","LastName","Company","Address","City","State","PostalCode","Phone","Email","SupportRepId")
VALUES ('Aaron','Aaronson','New York Ceramics','10 First Avenue','Mineola','NY','11524','+1 (516) 555-1234','Alffan@NYceramics.net',3),
('Zed','Zimmerwick','Internal Revenue Service','456 Michigan Avenue','Washington','DC','26400','+1 (737) 555-9876','ZZimmerwick@IRS.gov',4);

--2.4 Update customer Aaron Mitchell to Robert Walker
UPDATE "Customer" 
SET "FirstName" = 'Robert', "LastName" = 'Walker'
WHERE "FirstName" = 'Aaron' AND "LastName" = 'Mitchell';
--2.4 Change Creedance Clearwater Revival to CCR
UPDATE "Artist" 
SET "Name" = 'Creedance Clearwater Revival'
WHERE "Name" = 'CCR';

--2.5 Get all invoices with billing addresses starting with T
SELECT * FROM "Invoice"
WHERE "BillingAddress" LIKE 'T%';

--2.6 Get all invoices with 15 < totals < 50
SELECT * FROM "Invoice"
WHERE "Total" BETWEEN 15 AND 50;

--2.7 Delete Robert Walker from Customers
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

 DELETE FROM "Customer" WHERE "FirstName" = 'Robert' AND "LastName" = 'Walter';

--3.1 Return current time
SELECT current_time;
--3.1 returns length of a mediatype from the mediatype table
SELECT length("Name") AS "Media_Type_Name_Length" FROM "MediaType";

--3.2 Invoice average
SELECT AVG("Total") from "Invoice";
--3.2 Most expensive track(s)
SELECT * FROM "Track" WHERE "UnitPrice" = (
   SELECT MAX ("UnitPrice")
   FROM "Track");
  
 --3.3 Average price of invoce line items
CREATE OR REPLACE FUNCTION get_invoiceline_avg(Invoice_Id int)
RETURNS numeric
LANGUAGE plpgsql
AS
$$
DECLARE
   avg_cost numeric;
BEGIN
   SELECT AVG("UnitPrice") 
   INTO avg_cost
   FROM "InvoiceLine"
   WHERE "InvoiceId" = Invoice_id;
  
   RETURN avg_cost;
END;
$$;
SELECT avg("UnitPrice") from "InvoiceLine" where "InvoiceId" = *;
SELECT get_invoiceline_avg(*);

--3.4 Employees born after 1968
CREATE OR REPLACE FUNCTION employees_born_after_1968()
	returns table (
		emp_id int,
		first_name text,
		last_name text
	) 
	LANGUAGE plpgsql
AS $$
BEGIN
	RETURN query 
		SELECT
			"EmployeeId"::integer,
			"FirstName"::text,
			"LastName"::text
		FROM
			"Employee"
		WHERE
			"BirthDate" >= '1969-01-01';
END;$$
SELECT * FROM employees_born_after_1968();

--4.1 inner join of customers nd their invoices
SELECT "FirstName", "LastName", "InvoiceId"
FROM "Customer"
INNER JOIN "Invoice" ON "Invoice"."CustomerId" = "Customer"."CustomerId";

--4.2 outer join of customers and their invoices
SELECT "Customer"."CustomerId", "FirstName", "LastName", "InvoiceId", "Total"
FROM "Customer"
FULL OUTER JOIN "Invoice" ON "Invoice"."CustomerId" = "Customer"."CustomerId";

--4.3  right join of artist and albums
SELECT "Name", "Title"
FROM "Artist"
RIGHT JOIN "Album" USING ("ArtistId");

--4.4 cross join of albums and artists by artist name asc 
SELECT *    
FROM "Album"   
CROSS JOIN "Artist" ORDER BY "Name" ASC;  

--4.5 Self Join on the employee table with reports to
SELECT *
FROM "Employee"
INNER JOIN "Employee ON "ReportsTo";
