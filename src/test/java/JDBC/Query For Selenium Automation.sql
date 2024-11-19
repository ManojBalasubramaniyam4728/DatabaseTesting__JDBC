use qadbt;

create table LoginCredentials
(LoginCredentialsID int(50),BrowserName varchar(50), URL varchar(50)
, EmailID varchar(50), Password varchar(50));

insert into LoginCredentials values(1,'Chrome','https://www.fireflink.com/signin', 'manoj.b@fireflink.com', 'Password@123');
insert into LoginCredentials values(2,'Firefox','https://www.fireflink.com/signin', 'praveen.m@fireflink.com', 'Password@123');
insert into LoginCredentials values(3,'Edge','https://www.fireflink.com/signin', 'ranjith.m@fireflink.com', 'Password@123');

select * from LoginCredentials where LoginCredentialsid=1;