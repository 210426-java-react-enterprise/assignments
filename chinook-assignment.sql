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
