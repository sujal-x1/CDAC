#include<iostream>
using namespace std;
//
//class base {
//public:
//	base() {
//
//	}
//	base(const char* ptr) {
//		cout << "in base class constru" << endl;
//	}
//};
//class sub : public base {
//public:
//	sub() {
//
//	}
//	sub(char a,float b) {
//
//	}
//	sub(int c) {
//
//	}
//};
//int main() {
//	sub s;
//	sub* s1 = new sub(40);
//	sub* s2 = new sub('a', 3.4);
//
//}
/*
in this first assignment we had to make a base class and sub class
constructor , and also param constructor for the sub;
*/
//////////////////////////////////////////////////////////////////////////////////////
//#include<iostream>
//using namespace std;

//class parent {
//public:
//    void disp1() {
//        cout << "disp1" << endl;
//    }
//
//    void disp2() {
//        cout << "disp2" << endl;
//    }
//
//    void disp3() {
//        cout << "disp3" << endl;
//    }
//
//    void disp4() {
//        cout << "disp4" << endl;
//    }
//
//    void disp5() {
//        cout << "disp5" << endl;
//    }
//};
//
//class sub : public parent {
//public:
//    sub(int a) {
//        cout << "in sub constr" << endl;
//    }
//
//    void disp5() {
//        cout << "in sub disp 5" << endl;
//    }
//};
//
//int main() {
//    sub s(30);
//    s.disp5();
//    s.disp3();
//    s.disp1();
//}
/*
just make it public bro...
*/
//////////////Q3//////////////////////////////////////////////////////////////////
//class person {
//public:
//	virtual void walk() {
//		cout << "walk normally" << endl;
//	}
//};
//class Athelete : public person {
//public:
//	void walk() {
//		cout << "walk faster" << endl;
//	}
//};
//int main() {
//	person* ptr;
//	Athelete obj;
//	ptr = &obj;
//	ptr->walk();
//}
///////////////////////////////////////////////Q4///////////////////////////////////
//#include <iostream>
//using namespace std;
//
//class A {
//public:
//    int a;
//
//    A(int x) {
//        a = x;
//        cout << "In class A constructor" << endl;
//    }
//
//    ~A() {
//        cout << "In class A destructor" << endl;
//    }
//};
//
//class B {
//public:
//    int b;
//
//    B(int y) {
//        b = y;
//        cout << "In class B constructor" << endl;
//    }
//
//    ~B() {
//        cout << "In class B destructor" << endl;
//    }
//};
//
//class C : public A, public B {
//public:
//    int c;
//
//    C(int x, int y, int z) : A(x), B(y) {
//        c = z;
//        cout << "In class C constructor" << endl;
//    }
//
//    ~C() {
//        cout << "In class C destructor" << endl;
//    }
//};
//
//int main() {
//    C obj(10, 20, 30);
//
//    cout << "\nValues:" << endl;
//    cout << "A = " << obj.a << endl;
//    cout << "B = " << obj.b << endl;
//    cout << "C = " << obj.c << endl;
//
//    return 0;
//}
////////////////////Q5//////////////////////////////////////////////////////////////
//#include <iostream>
//using namespace std;
//
//class Base {
//public:
//    int num1;
//    Base(int x) {
//        num1 = x;
//        cout << "Base constructor called" << endl;
//    }
//    ~Base() {
//        cout << "Base destructor called" << endl;
//    }
//};
//class Sub1 : public Base {
//public:
//    int num2;
//
//    Sub1(int x, int y) : Base(x) {
//        num2 = y;
//        cout << "Sub1 constructor called" << endl;
//    }
//
//    ~Sub1() {
//        cout << "Sub1 destructor called" << endl;
//    }
//};
//
//class Sub2 : public Sub1 {
//public:
//    int num3;
//
//    Sub2(int x, int y, int z) : Sub1(x, y) {
//        num3 = z;
//        cout << "Sub2 constructor called" << endl;
//    }
//
//    ~Sub2() {
//        cout << "Sub2 destructor called" << endl;
//    }
//};
//
//int main() {
//    Sub2 obj(10, 20, 30);
//
//    cout << "\nValues:" << endl;
//    cout << "Num1 = " << obj.num1 << endl;
//    cout << "Num2 = " << obj.num2 << endl;
//    cout << "Num3 = " << obj.num3 << endl;
//
//    return 0;
//}
////////////////Q6?????????????
//#ifndef BASE1_H
//#define BASE1_H
//
//#include <iostream>
//using namespace std;
//
//class Base1 {
//public:
//    int num1;
//
//    Base1() {
//        num1 = 10;
//        cout << "Base1 constructor called" << endl;
//    }
//
//    void display1() {
//        cout << "This is Base1 function" << endl;
//        cout << "Num1 = " << num1 << endl;
//    }
//};
//
//#endif
//////////////////////////////////////////////////
//#ifndef BASE2_H
//#define BASE2_H
//
//#include <iostream>
//using namespace std;
//
//class Base2 {
//public:
//    int num2;
//
//    Base2() {
//        num2 = 20;
//        cout << "Base2 constructor called" << endl;
//    }
//
//    void display2() {
//        cout << "This is Base2 function" << endl;
//        cout << "Num2 = " << num2 << endl;
//    }
//};
//
//#endif
//////////////////////////////////////////////////////////////
//#include <iostream>
//#include "Base1.h"
//#include "Base2.h"
//
//using namespace std;
//
//class Sub : public Base1, public Base2 {
//public:
//    Sub() {
//        cout << "Sub constructor called" << endl;
//    }
//
//    void display() {
//        cout << "This is Sub class function" << endl;
//    }
//};
//
//int main() {
//
//    Sub obj;
//
//    cout << endl;
//
//    obj.display1();
//    obj.display2();
//    obj.display();
//
//    return 0;
//}
///////////////////////////////////////////////////////