public class House {
    private String houseCode = "A01";
    private int numberOfBedRooms = 2;
    private boolean hasSwimmingPool = false;
    private double area = 0.0;
    private double costPerSquareMeter = 0.0;

    //constructor
    public House() {}
    public House(String houseCode, int numberOfBedRooms, boolean hasSwimmingPool, double area, double costPerSquareMeter) {
        this.houseCode = houseCode;
        this.numberOfBedRooms = numberOfBedRooms;
        this.hasSwimmingPool = hasSwimmingPool;
        this.area = area;
        this.costPerSquareMeter = costPerSquareMeter;
    }

    // getters and setters
    public boolean getHasSwimmingPool() {
        return hasSwimmingPool;
    }
    public double getArea() {
        return area;
    }
    public double getCostPerSquareMeter() {
        return costPerSquareMeter;
    }
    public String getHouseCode() {
        return houseCode;
    }
    public int getNumberOfBedRooms() {
        return numberOfBedRooms;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public void setCostPerSquareMeter(double costPerSquareMeter) {
        this.costPerSquareMeter = costPerSquareMeter;
    }
    public void setHasSwimmingPool(boolean hasSwimmingPool) {
        this.hasSwimmingPool = hasSwimmingPool;
    }
    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }
    public void setNumberOfBedRooms(int numberOfBedRooms) {
        this.numberOfBedRooms = numberOfBedRooms;
    }
    
    // calculate the cost of the house
    public double calculateSellingPrice(){
        double subTotal = area*costPerSquareMeter;

        if (hasSwimmingPool) {
            subTotal += 0.1*subTotal;
        }
        return subTotal + 0.15*subTotal;
    }


    @Override
    public String toString() {
        return "House[House Code=" + this.houseCode + ",Number of bedrooms=" + numberOfBedRooms + ", Has Swimming Pool=" + hasSwimmingPool + ", Selling price: "+calculateSellingPrice()+"]";
    }

    public static void main(String[] args) {
        House house1 = new House("A02",10,true,200,12);
        System.out.println(house1.toString());
    }
}
