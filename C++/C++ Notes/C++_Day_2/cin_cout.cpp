/*
cin and cout are objects of istream and ostream classes respectively.
no "&" and "format specifiers" required.
cin needs >> (extraction operator)
cout needs << (insertion operator)

scanf and printf are variable number of arguments functions.
*/

#include<iostream>
using namespace std;
int main()
{
	char name[20];
	int age;
	cout<<"Enter name and age"<<endl;
	cin>>name>>age;
	cout<<name<<"\t"<<age<<endl;
}


/* how to accept space in the string ? */

/*
cin.getline(name, n) can store at most n - 1 input characters, because it reserves space for the terminating null character '\0'.
Therefore, for char name[20]:

- cin.getline(name, 20); stores at most 19 input characters, followed by '\0'.

*/

char name[20];
cout << "Enter a name" << endl;
cin.getline(name, 20);
cout << "Name is\t" << name << endl;















