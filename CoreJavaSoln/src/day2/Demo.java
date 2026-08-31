package day2;


class A {

    // Static variable
    static int staticVarA = 10;

    // Non-static variable
    int nonStaticVarA = 20;


    // Static method
    static void staticMethodA() {
        System.out.println("Static method of A");
    }

    // Non-static method
    void nonStaticMethodA() {
        System.out.println("Non-static method of A");
    }
}


class B {

    // Static variable
    static int staticVarB = 30;

    // Non-static variable
    int nonStaticVarB = 40;


    // Static method
    static void staticMethodB() {
        System.out.println("Static method of B");
    }

    // Non-static method
    void nonStaticMethodB() {
        System.out.println("Non-static method of B");
    }
}


class C {

    // Static variable
    static int staticVarC = 50;

    // Non-static variable
    int nonStaticVarC = 60;


    // Static method
    static void staticMethodC() {
        System.out.println("Static method of C");
    }

    // Non-static method
    void nonStaticMethodC() {
        System.out.println("Non-static method of C");
    }
}


public class Demo {

    public static void main(String[] args) {

        // Static members → use class name
        System.out.println(A.staticVarA);
        A.staticMethodA();

        // Non-static members → create object
        A a = new A();

        System.out.println(a.nonStaticVarA);
        a.nonStaticMethodA();




        // Static members → use class name
        System.out.println(B.staticVarB);
        B.staticMethodB();

        // Non-static members → create object
        B b = new B();

        System.out.println(b.nonStaticVarB);
        b.nonStaticMethodB();


        // Static members → use class name
        System.out.println(C.staticVarC);
        C.staticMethodC();

        // Non-static members → create object
        C c = new C();

        System.out.println(c.nonStaticVarC);
        c.nonStaticMethodC();
    }
}