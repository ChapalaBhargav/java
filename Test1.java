interface A {
    void meth1();
    void meth2();
}

class MyClass implements A {
    private String name;

    // Constructor
    public MyClass(String name) {
        this.name = name;
    }

    public void meth1() {
        System.out.println(name + " says: This is meth1 implementation.");
    }

    public void meth2() {
        System.out.println(name + " says: This is meth2 implementation.");
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass("MyClass");
        obj.meth1();
        obj.meth2();
    }
}

class AnotherClass implements A {
    private String identifier;

    // Constructor
    public AnotherClass(String identifier) {
        this.identifier = identifier;
    }

    public void meth1() {
        System.out.println(identifier + " says: This is meth1 from AnotherClass.");
    }

    public void meth2() {
        System.out.println(identifier + " says: This is meth2 from AnotherClass.");
    }
}

// Example of using AnotherClass
class Test1 {
    public static void main(String[] args) {
        AnotherClass anotherObj = new AnotherClass("AnotherClass");
        anotherObj.meth1();
        anotherObj.meth2();
    }
}
