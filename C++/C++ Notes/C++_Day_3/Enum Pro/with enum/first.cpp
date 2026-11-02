/*
enum constants in C++ are by default get values 0, 1 ,2 etc.
but we can change that order. 
in the following code PLAIN is initialized with 2 , so
BOLD and ITALIC will get 3 and 4 respectively.

*/

#include<iostream>
using namespace std;
class MyFont
{
public:
	enum Style { PLAIN=2, BOLD, ITALIC };
};
class MyComponent
{
public:
	void setStyle(MyFont::Style style)
	{
		switch (style)
		{
		case MyFont::PLAIN: cout << "plain" << endl;
			break;
		case MyFont::BOLD: cout << "bold" << endl;
			break;
		case MyFont::ITALIC: cout << "italic" << endl;
			break;
		}
	}
};
int main()
{
	MyComponent mc;
	mc.setStyle(MyFont::BOLD);
	mc.setStyle(MyFont::ITALIC);
	mc.setStyle(MyFont::PLAIN);
	//		mc.setStyle(MyFont::plain); //Error
	//		mc.setStyle(1); // error
	//		mc.setStyle(6); // error
	cout << MyFont::PLAIN << endl;
	cout << MyFont::BOLD << endl;
	cout << MyFont::ITALIC << endl;
}
