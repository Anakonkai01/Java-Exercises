package exercise3;

public class Main {
    public static void main(String[] args) {
        Vegetable test1 = VegetableFactory.getVegetable("Carrot");
        Vegetable test2 = VegetableFactory.getVegetable("Cabbage");
        Vegetable test3 = VegetableFactory.getVegetable("Pumpkin");
        System.out.println(test1.getClass());
        System.out.println(test2.getClass());
        System.out.println(test3.getClass());
    }

}
