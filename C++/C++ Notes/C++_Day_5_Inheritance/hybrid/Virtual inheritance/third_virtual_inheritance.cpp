/* When two or more objects(P1 and P2) are derived from  a common base class (Gp) ,you can prevent multiple copies of the base class(Gp) from being present in an object (child)  derived from those objects(P1 and P2) by declaring the base class(Gp) as virtual,when it is inherited */


/*
In virtual inheritance, P1 and P2 may each contain a vbptr. These pointers provide access to compiler-generated vbtable information, which helps locate the single shared Gp subobject inside the child object.
*/


#include<iostream>
#pragma pack(1)
using namespace std;
class Gp
{
private:
	int num1;
public:
	Gp()
	{
		cout << "Gp no-arg constr" << endl;
	}
	void disp1()
	{
		cout << "Gp disp1" << endl;
	}
	~Gp()
	{
		cout << "Gp dest" << endl;
	}

};
class P1 :public virtual Gp
{
private:
	int num2;
public:
	P1()
	{
		cout << "P1 no-arg const" << endl;
	}
	~P1()
	{
		cout << "P1 dest" << endl;
	}
};
class P2 :virtual public Gp
{
private:
	int num3;
public:
	P2()
	{
		cout << "P2 no-arg const" << endl;
	}
	~P2()
	{
		cout << "P2 dest" << endl;
	}
};
class child :public P1, public P2
{
private:
	int num4;
public:
	child()
	{
		cout << "child no-arg const" << endl;
	}
	~child()
	{
		cout << "child dest" << endl;
	}
};
int main()
{
	child c;

	c.disp1();
	cout << sizeof(c) << endl;   //  32

	// let's check sizes of P1 and P2
	P1 obj1;
	P2 obj2;
	cout << "Sizes of P1 and P2 are" << endl;
	cout << sizeof(obj1) << "\t" << sizeof(obj2) << endl;

}