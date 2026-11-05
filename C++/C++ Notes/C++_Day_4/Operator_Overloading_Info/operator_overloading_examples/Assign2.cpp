#include<iostream>
using namespace std;
class Student
{
private:
	char* name;
	int age;
public:
	Student()
	{
		name = NULL;
	}
	Student(const char* str, int age)
	{
		name = new char[strlen(str) + 1];
		strcpy_s(name, strlen(str) + 1, str);
		this->age = age;
	}
	Student(const Student& ref)
	{
		if (ref.name == NULL)
			throw "cannot initialize current object with this useless object";
		this->name = new char[strlen(ref.name) + 1];
		strcpy_s(this->name, strlen(ref.name) + 1, ref.name);
		this->age = ref.age;
	}
	~Student()
	{
		cout << "in destructor" << endl;
		if (name != NULL)
			delete name;
	}
	void disp()
	{
		if (name != NULL)
			cout << name << "\t" << age << endl;
	}
	Student& operator=(Student& ref)
	{
		if (ref.name == NULL)
			throw "cannot assign this useless object";
		if (this->name != NULL)
		{
			delete this->name;
			this->name = NULL;
		}
		this->name = new char[strlen(ref.name) + 1];
		strcpy_s(this->name, strlen(ref.name) + 1, ref.name);
		this->age = ref.age;
		return *this;
	}
};
int main()
{
	Student s1; 
	Student s2("Abcd", 20); Student s4("Vikas", 30);
	s1.disp();
	s2.disp();
	s4.disp();
	try
	{
		Student s3 = s2;
		s3.disp();
	}
	catch (const char* ptr)
	{
		cout << "in catch\t" << ptr << endl;
	}
	try
	{
		s4 = s1 = s2;  // s1.operator=(s3)
	}
	catch (const char* ptr)
	{
		cout << "in catch\t" << ptr << endl;
	}
	s1.disp();
	s4.disp();
	Student s5;
	try
	{
		s4 = s5;
	}
	catch (const char* ptr)
	{
		cout << "in catch\t" << ptr << endl;
	}
	s4.disp();
	

	Student s6;
	try
	{
		Student s7(s6);
		s7.disp();
	}
	catch (const char* ptr)
	{
		cout << "in catch\t" << ptr << endl;
	}
	cout << "done" << endl;
}