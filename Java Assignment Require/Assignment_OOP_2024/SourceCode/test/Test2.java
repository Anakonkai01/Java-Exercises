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
        Child child1 = new Child();
        Parent1 parent1 = new Parent1();
        // if(parent1 instanceof)

        boolean a = true;
        boolean b= true;
        if(a == b){
            System.out.println("Hello weorld");
        }
    }
    
}
