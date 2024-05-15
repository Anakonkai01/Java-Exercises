package test;

class Parent1 {
    protected int a = 10;

}

class Parent2 extends Parent1{
    protected int b = 20;
}

class Child extends Parent2{
    protected int c = 30;
}
public class Test2 {
    public static void main(String[] args) {
        Child obj = new Child();
        System.out.println(obj.a);
        System.out.println(obj.b);
        System.out.println(obj.c);

    }
    
}
