package test;

interface Drink {
    void prepareDrink();
}

class Coffee implements Drink {
    public void prepareDrink() {
        System.out.println("Coffee");
    }
}

class Tea implements Drink {
    public void prepareDrink() {
        System.out.println("Tea");
    }
}

class Soda implements Drink {
    public void prepareDrink() {
        System.out.println("Soda");
    }
}

class DrinkFactory {
    public Drink getDrink(String drinkType) {
        if (drinkType == null) return null;
        switch (drinkType.toLowerCase()) {
            case "coffee":
                return new Coffee();
            case "tea":
                return new Tea();
            case "soda":
                return new Soda();
            default:
                return null;
        }
    }
}

public class TestFactoryPattern {
    public static void main(String[] args) {
        DrinkFactory test = new DrinkFactory();
        Drink coffee = test.getDrink("coffee");
        Drink tea = test.getDrink("tea");
        Drink soda = test.getDrink("soda");
        coffee.prepareDrink();
        tea.prepareDrink();
        soda.prepareDrink();
    }
}
