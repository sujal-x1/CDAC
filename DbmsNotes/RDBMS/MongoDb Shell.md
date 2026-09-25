show databases;
create database sept 2026;
use sept2026;
db.createCollection("emp")
db.emp.insertOne({name: "john",salary : 100})
db.emp.insertMany({name: "try",salary:2000},{name:"xyz",salary:300},{name:"jk",salary:89},{name:"uyt",salary:909},)
db.emp.find().smth;
db.emp.find({salary:100,$or:[{name:'John'},{salary:1100}]})
db.emp.aggregate ([{$group : {_id:null,totalsalary: {$sum :"$salary"},averagesalary:{$avg:"$salary"}}}])
{
_id_: null,
totalsalary:232342,
averagesalary:23233
}


select recursive letters as(select 'A' as letter union all
select char(ascii(letter)+1))
from letters 










with recursive letters as (select 'A' as letter union all
select char(ascii(letter)+1)
from letters
where letter <'Z' )select letter from letters;










with recursive letters as(select 'A' as letter
union all
select char(ascii(letter)+1))
from letters 
where letter < '2') select letter from letters;

with recursive nums as (select 1 as num
union all
select num+1
from nums
where num<10)select num from nums;
