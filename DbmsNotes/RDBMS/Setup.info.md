Check mysql80 in services.msc
open task manager -> details -> mysqld.exe (d stands for daemon (Backend process)) -> kill the process & check services.msc(not recommended)

for not configured
- C drive -> program files -> MySQL -> MySQL Server 8.0(or anything) -> bin (Copy the path till bin)
- Set this path in Path under System Variable (edit -> new -> add the copied path)
- Close the current cmd. Open a new one
- Now type : mysql ( Access denied will appear)
- mysql -uroot" (-u stands for user) and enter your password 
- to quit enter '\q'
- mysql -uroot -p : Secure way to connect
- "-P" : "P" is for port
- "select version();" => gives version info
- "show databases;" => shows system databases (should be 4, apart from that 4 all are User DBs)

to check current session is connected to which DB : "select database();" (NULL not connected to any DB)
use mysql => connects to one of the system db
show tables; => shows the tables of that dbs
create database sept2026;
show databases; => shows the new one in list
use sept2026; => connects to sept2026
select database(); => to confirm
show tables => will return empty set (meaning no tables currently)

select curdate();
	now()
	curtime();


select never  changes just shows current value.

Inside mysql
	show variables like 'datadir';
	=> the path takes us to a folder where all our db are there as folder.
	=> find .err 

	show variables like 'port';
	=> shows on which port our current session is running

	drop database sept2026;
	=> deletes the db, check what errors comes if u r using the same db

How to create a Table(Schema (ONLY IN MySQL)) 
=> create table t1 (c1 int, c2 varchar(100), c3 date);
varchar => alpha-numeric values, text can go upto 100 character

show tables; => to see the table

desc t1 => describes the table, what columns are there
