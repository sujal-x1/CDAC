#include<iostream>
#include <cstring>
using namespace std;

int main() {
	char name[] = "sachin";

	char name2[7];

	strcpy_s(name2, name);

	cout << name2 << endl;
}
class student {
public:
	int age;

	student(int a) {
		age = a;
	}
	student(const student& s) {
		age = s.age;
	}
};