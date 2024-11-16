public class Car extends Vehicle {
    private int year;
    public Car(String brand, int year) {
        super(brand);
        this.year = year;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    @Override
    public String toString() {
        return "Car [year=" + year + "]";
    }
}
