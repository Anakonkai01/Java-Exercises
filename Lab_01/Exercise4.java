public class Exercise4 {
    public static double covertToCelsius(double fahrenheit) { 
        return (fahrenheit - 32)/1.8;
    }

    public static double convertToFahrenheit(double celsius) {
        return celsius*1.8+32;
    }

    public static void main(String[] args) {
        double celsius = 32.5;
        double fahrenheit = 98.6;

        System.out.printf("%.2f celsius = %.2f fahrenheit.\n", celsius, convertToFahrenheit(celsius));
        System.out.printf("%.2f fahrenheit = %.2f celsius.", fahrenheit, covertToCelsius(fahrenheit));
    }
}
