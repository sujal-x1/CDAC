#include <iostream>
using namespace std;
class Number {
	int num;
public:
	Number(int k) {
		num = k;
	}

	Number operator+(Number obj) {
		Number temp(0);
		temp.num = num + obj.num;
		return temp;
	}
	void display() {
		cout << num << endl;
	}
};

int main() {
	Number n1(10);
	Number n2(4);
	Number n3(3);

	n3 = n2 + n1;

	n3.display();
}
