package exercise3;

public class VegetableFactory {
    public static Vegetable getVegetable(String type) {
        if(type == null) return null;
        switch (type) {
            case "Carrot":
                return new Carrot();
            case "Pumpkin":
                return new Pumpkin();
            case "Cabbage":
                return new Cabbage();
            default:
                return null;
        }
    }
}
