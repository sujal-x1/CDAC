## views
1. when a view is created using join of two or more tables then update or insert is possible only if they are modifying data of 1 base table at a time
2. if a view does not contain any not null column of the table  and that column does not even have default value then insert in that view is not possible 
3. if the view is a complex view i.e it has group by clause , ranking function , aggregated func then DML on that view is not allowed.

##  dknf
A relation is in **DKNF** if **every constraint on the relation is a logical consequence of only:**

2. **Domain constraints** — restrictions on valid values.
		``
		```Student_ID → positive integers
		Name      → strings
		Age       → integers from 1 to 100
	
			    
	1. **Key constraints** — restrictions imposed by keys.
				`Student_ID must be unique

		               DOMAIN
						  ↓
			"Is this value allowed?"
						 KEY
						  ↓
			"Is this value/combination unique?"

## Normalization
- This is the process which allows you to winnow out redundant data within your database 
- this involves restructuring the tables to successively meeting higher forms of Normalization
- A properly normalized database should have the following characteristics 
		`scalar values in each field `
		`Absence of redundancy`
		`Minimal use of null values`
		`minimal loss of information


## 1NF
A table is considered to be in 1nf if all fields contain only scalar values.

## 2NF
for a table to be in 2nf , there are two requirements
 - the db iin first normal form
 - All nonkey attributes in the table must be functionally dependent on the entire primary key

## 3NF
This form dictates that all non-key attributes of a  table must be functionally dependent on a primary key  i.e there can be 



## truncate vs delete 
truncate isn't locked ata row level ,
turncate don't have where clause
trunc resets autoincrement
