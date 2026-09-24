
	 Normalization in DBMS
Normalization is the process of organizing data in a database to reduce redundancy and prevent insertion, deletion, and update anomalies by dividing data into related tables using functional dependencies.
## 1NF — First Normal Form

### Technical

A relation is in **1NF** if:

- Every attribute contains **atomic (indivisible) values**.
    
- There are no repeating groups or multi-valued attributes.


## 23-sep things 

### `what is a cursor?
-> A **cursor** is a database object that lets you **process query results one row at a time**.

## `partition by ~~sample `
```sql
SELECT department,name,salary,RANK() OVER (PARTITION BY department
 ORDER BY salary DESC
) AS salary_rank FROM employees;
```
## `Triggers
- statement level - gets executed only once
- row level- as many times as num of rows remain => **only this supported by mysql**
~used in Auditing , Automation

create table emp_audit 
(upd_datetime timestamp ,
upd_user varchar(100),
old_eid int,,
new_eid int,
old_ename varchar(100),
new_ename varchar(100),
old_salary int,
new_salary int,
old_deptid int,
new_deptid int)

D-durabililty - volatile keyword
Transaction is a unit of work ;
wal - write adhed logging


![[Pasted image 20260924014851.png|556]]

![[Pasted image 20260924014911.png|617]]

![[Pasted image 20260924014942.png|645]]![[Pasted image 20260924014952.png|599]]![[Pasted image 20260924015002.png|593]]![[Pasted image 20260924015011.png|632]]![[Pasted image 20260924015017.png|615]]![[Pasted image 20260924015024.png|597]]![[Pasted image 20260924015032.png|630]]![[Pasted image 20260924015039.png|603]]