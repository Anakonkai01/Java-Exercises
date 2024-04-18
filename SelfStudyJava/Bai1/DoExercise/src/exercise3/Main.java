package exercise3;

public class Main {
    public static void main(String[] args) {
        VegetableFactory vegetableFactory = new VegetableFactory();
        Vegetable test1=  vegetableFactory.getVegetable("Carrot");
        Carrot test2 = (Carrot) test1;
        test2.setType("yeah yeah");
        System.out.println(test2.getInfo());
    }

}
