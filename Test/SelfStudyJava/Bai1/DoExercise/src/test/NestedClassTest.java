package test;

interface Greeting {
    void sayHello();
}

public class NestedClassTest {
    public static void main(String[] args) {
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello");
            }
        };
        greeting.sayHello();


    }
}