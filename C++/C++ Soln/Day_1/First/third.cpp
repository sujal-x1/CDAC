//#include <iostream>
//using namespace std;
//class Myclass {
//public:
//	char* name;
//	int age;
//	Myclass(const char* name, int age) {
//		this->name = new char[strlen(name) + 1];
//		strcpy_s(this->name,strlen(name)+1, name);
//		this->age = age;
//		cout << "in constructor " << endl;
//	}
//	~Myclass() {
//		delete[]name;
//		cout << "in destructor" << endl;
//	}
//private:
//	void disp1() {
//		cout << " in class 1" << endl;
//	}
//	friend void disp1();
//};
//
//class Myclass2 {
//public:
//	char* name;
//	int age;
//	Myclass2(const char* name, int age) {
//		this->name = new char[strlen(name) + 1];
//		strcpy_s(this->name, strlen(name) + 1, name);
//	}
//	void disp2() {
//		cout << " in class 2" << endl;
//	}
//};
//
//int main() {
//	
//}
