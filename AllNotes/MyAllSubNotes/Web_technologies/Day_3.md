**Q. How do you prove that object belongs to object class**
**-  with the help of instanceOf**
## class keyword 
class methods are non-enumerable . A class definition sets enumerable flag to false
- class definition are not hoisted(you cannot write obj of class before defining class)

## Getter/Setter new syntax
``` js
class Account {
    constructor(name, amt) {
        this.Aname = name;       // calls SETTER
        this.Abalance = amt;     // calls SETTER
    }
set Aname(value) {
        this._name = value;
    }
```

## **===#' keyword to declare private variable , not available outside the class

***===_ name is used to declare that this variable should only be used in child class


# Event
- on click 
- a field was changed 
# external js file 


## ==TOdo:== 

`Inheritance` from 05Es6.ppt (esp Abstract and the keyword new.target() // pg.13 se working
`Event.html` understand getdata() working

- **create 2 button with a value , welcome and goodbye when you click on welcome display message , "welcome to js", when you click goodbye , msg "see you again".
- **accept 2 nos from user and print product of it
- 