package exercise3;

public class VegetableFactory {
    public Vegetable getVegetable(String type) {
        if(type == null) return null;
        return switch (type.toLowerCase()) {
            case "carrot" -> new Carrot();
            case "cabbage" -> new Cabbage();
            case "pumpkin" -> new Pumpkin();
            default -> null;
        }; //enhance switch statement nay hay ne =)))))))) co gi tim hieu them
    }
}
