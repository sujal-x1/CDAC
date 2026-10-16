// Create  abstract class Account having private variable id, name, balance.
// Declare getter setter for name ➔ minimum length=4 max=15
// Id is auto increment➔ write only getter
// Declare balance getter setter as protected
// Declare deposit method which will increase balance
// Create 2 child class saving and current
// It has withdraw method which will reduce balance.
// In saving –ve balance not allowed in current –ve balane allowed.
// Create 2 object and print name and balance using toString.
// Asson as you load application it should print name of bank.
// Declare static method payinterest(accountholder) which will give interest to account holder and increase balance.
// Declare static interest=0.06;

'use strict'
class Account {

    #id; #name; #balance;
    static aid = 0;
    static nameofbank = "Some BANK";
    static intrest = 0.06;

    static {
        document.write(Account.nameofbank);
        document.write("<br/>");
    }
    constructor(nm, amt) {
        document.write("<br/>");
        if (new.target === Account) {
            throw new TypeError("You can not instantiate Account class");
        }
        this.name = nm;
        this._balance = amt;
        this.#id = ++Account.aid;
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

    set _balance(value) {
        this.#balance = value;
    }
    get _balance() {
        return this.#balance;
    }

    get id() {
        return this.#id;
    }

    deposit(amt) {
        this._balance += amt;
    }

    static payIntrest(obj) {
        let intrestAmount = obj._balance * Account.intrest;
        obj.deposit(intrestAmount);
        return intrestAmount;
    }

    toString() {
        return `Account ID: ${this.id}, Name: ${this.name}, Balance: ${this._balance}`;
    }
}

class SavingAccount extends Account {
    constructor(type, name, amt) {
        super(name, amt);
        this.type = type;
    }
    withdraw(amt) {
        const min = 1000;
        if (this._balance - amt < min) {
            throw new Error("You don't have enough balance");
        }
        this._balance -= amt;
    }
}

class CurrentAccount extends Account {
    constructor(type, name, amt) {
        super(name, amt);
        this.type = type;
    }
    withdraw(amt) {
        this._balance -= amt;
    }
}

try {
    var obj1 = new SavingAccount('sav', "Is67ha", 100000);

} catch (e) {
    document.write(e);
}
obj1.deposit(9898);
obj1.withdraw(998);
document.write("<br/>");
document.write(obj1);
document.write("<br/>");
document.write(obj1);
document.write("<br/>");
document.write(Account.payIntrest(obj1));
document.write("<br/>");

try {
    var obj2 = new CurrentAccount('cur', "Is67ha", 100000);
} catch (e) {
    document.write(e);
}
obj2.deposit(9876);
obj2.withdraw(999);
document.write(obj2);
document.write("<br/>");
document.write(obj2);
document.write("<br/>");
document.write(Account.payIntrest(obj1));