interface Saysomething{
    void say();
}

public class Ex5 {
    public static void main(String[] args) {
        Saysomething s = new Saysomething() {
            public void say(){
                System.out.println("Hello world!");
            }
        };


        s.say();
    }
}
