// Declare 
//  method which will deduct TDS and set netsalary.

// It has givebonus method which will increase salary.
// In permanentemp  give bonus 10 % in contractemp  give bonus 5%.
// Create 2 object and print name and netsalary using toString.

class Employee {
    static companyname = "Some Company";
    static TDS = 0.1;
    static {
        document.write(Employee.companyname);
        document.write("<br/>");
    }
    #id; #name; #salary; #netsalary;
    static aid = 0;
    constructor(nm, salary) {
        if (new.target === Employee) {
            throw new Error("You can not instantiate this class");
        }
        this.#id = ++Employee.aid;
        this.name = nm;
        this._salary = salary;
        this._netsalary = 0;
    }

    set name(value) {
        if (value.length < 4 || value.length > 15) {
            throw new TypeError("Not a valid name");
        }
        this.#name = value;
    }
    get name() {
        return this.#name;
    }

    set _salary(value) {
        this.#salary = value;
    }
    get _salary() {
        return this.#salary;
    }

    set _netsalary(value) {
        this.#netsalary = value;
    }
    get _netsalary() {
        return this.#netsalary;
    }

    get id() {
        return this.#id;
    }

    calculate_netsalary() {
        let tdsAmount = this._salary * Employee.TDS;
        this._netsalary = this._salary - tdsAmount;
        return this._netsalary;
    }

    toString() {
        return `Employee ID: ${this.id}, Name: ${this.name}, Net Salary: ${this._netsalary}`;
    }

}

class permanentEmp extends Employee {
    constructor(type, name, salary) {
        super(name, salary);
        this.type = type;
    }
    givebonus() {
        let bonus = this._salary * 0.10;
        this._salary += bonus;
        this.calculate_netsalary();
    }
}

class contractEmp extends Employee {
    constructor(type, name, salary) {
        super(name, salary);
        this.type = type;
    }
    givebonus() {
        let bonus = this._salary * 0.5;
        this._salary += bonus;
        this.calculate_netsalary();
    }
}

var obj1 = new permanentEmp('Per', "Neha", 789898);
obj1.calculate_netsalary();
document.write(obj1);
document.write("<br/>");
obj1.givebonus();
document.write("After 10% bonus: ");
document.write(obj1);
document.write("<br/><br/>");

var obj1 = new contractEmp('Per', "Mina", 789898);
obj1.calculate_netsalary();
document.write(obj1);
document.write("<br/>");
obj1.givebonus();
document.write("After 5% bonus: ");
document.write(obj1);
document.write("<br/><br/>");