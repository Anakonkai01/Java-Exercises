class Employee{
    private String ID;
    private String fullName;
    private int yearJoined;
    private double coefficientsSalary;
    private int numDaysOff;
    static private int currentYear = 2024;
    static final private double basicSalary = 1150.0;

    public Employee(){
        this.ID = "0";
        this.fullName = "";
        this.yearJoined = 2020;
        this.coefficientsSalary = 1.0;
        this.numDaysOff = 0;
    }
    public Employee(String ID, String fullname, double coeficientsSalary){
        this.ID = ID;
        this.fullName = fullname;
        this.coefficientsSalary = coeficientsSalary;
        this.yearJoined = 2020;
        this.numDaysOff = 0;
    }
    public Employee(String ID, String fullName, int yearJoined, double coefficientsSalary, int numDaysOff) {
        this.ID = ID;
        this.fullName = fullName;
        this.yearJoined = yearJoined;
        this.coefficientsSalary = coefficientsSalary;
        this.numDaysOff = numDaysOff;
    }
    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public int getYearJoined() {
        return yearJoined;
    }
    public void setYearJoined(int yearJoined) {
        this.yearJoined = yearJoined;
    }
    public double getCoefficientsSalary() {
        return coefficientsSalary;
    }
    public void setCoefficientsSalary(double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }
    public int getNumDaysOff() {
        return numDaysOff;
    }
    public void setNumDaysOff(int numDaysOff) {
        this.numDaysOff = numDaysOff;
    }
    public static int getCurrentYear() {
        return currentYear;
    }
    public static void setCurrentYear(int currentYear) {
        Employee.currentYear = currentYear;
    }
    public static double getBasicSalary() {
        return basicSalary;
    }
    public double getSenioritySalary(){
        int yearWork = currentYear - yearJoined + 1;
        if(yearWork == 5) return yearWork*basicSalary/100;
        else return 0;
    }
    public String considerEmulation(){
        if(numDaysOff == 2) return "B";
        if(numDaysOff >= 3) return "C";
        else return "A";
    }
    
    public double getCoefficientsEmulation(){
        double coefficientsEmulation = 1.0;
        String rated = considerEmulation();
        if(rated.equals("B")){
            coefficientsEmulation = 0.75;
        }
        else if(rated.equals("C")){
            coefficientsEmulation = 0.5;
        }
        return coefficientsEmulation;
    }

    public double getSalary(){
        
        return basicSalary*coefficientsSalary*getCoefficientsEmulation()+getSenioritySalary();
    }
    @Override
    public String toString() {
        return "Employee [ID=" + ID + ", fullName=" + fullName + ", yearJoined=" + yearJoined + ", coefficientsSalary="
                + coefficientsSalary + ", numDaysOff=" + numDaysOff + "]";
    }

}



public class Exercise5 {
    public static void main(String[] args) {
        
    }
}
