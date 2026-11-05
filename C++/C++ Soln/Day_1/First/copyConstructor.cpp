#include <iostream>
using namespace std;
class Student {
	char* name;
	int age ;

public:
	Student() {//default const
		name = NULL;
	}

	Student(const char* str, int k) {
		name = new char[strlen(str) + 1];
		strcpy_s(name, strlen(str) + 1, str);
		age = k;
	}

	Student(const Student& ref) {
		name = new char[strlen(ref.name) + 1];
		strcpy_s(name, strlen(ref.name) + 1, ref.name);

		age = ref.age;
	}

	~Student() {
		delete[]name;
	}

	void display() {
		if (name != NULL) {
			cout << name << age << endl;
		}
	}
};

int main() {
	Student s1("sujal", 23);
	Student s2 = s1;

	s1.display();
	s2.display();
}
