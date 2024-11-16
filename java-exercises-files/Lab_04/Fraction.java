public class Fraction {
    private int numerator;
    private int denominator;

    //constructor
    public Fraction() {}
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Fraction(Fraction otherFraction) {
        this.numerator = otherFraction.numerator;
        this.denominator = otherFraction.denominator;
    }
    // add fraction
    public Fraction add(Fraction otherFraction) {
        int newNumerator = this.numerator*otherFraction.denominator + otherFraction.numerator*this.denominator;
        int newDenominator = this.denominator*otherFraction.denominator;
        return new Fraction(newNumerator, newDenominator);
    }
    // subtract fraction
    public Fraction sub(Fraction otherFraction) {
        int newNumerator = this.numerator*otherFraction.denominator - otherFraction.numerator*this.denominator;
        int newDenominator = this.denominator*otherFraction.denominator;
        return new Fraction(newNumerator, newDenominator);
    }
    // multiply fraction
    public Fraction mul(Fraction otherFraction) {
        int newNumerator = this.numerator*otherFraction.numerator;
        int newDenominator = this.denominator*otherFraction.denominator;
        return new Fraction(newNumerator, newDenominator);
    }
    // divide fraction
    public Fraction div(Fraction otherFraction) {
        int newNumerator = this.numerator*otherFraction.denominator;
        int newDenominator = this.denominator*otherFraction.numerator;
        return new Fraction(newNumerator, newDenominator);
    }
    //reducer
    public void reducer(){
        for(int i = (numerator<denominator)? numerator:denominator; i > 0; i--){
            if(numerator%i == 0 && denominator%i == 0){
                numerator /= i;
                denominator /= i;
                break;
            }
        }
    }
    @Override
    public String toString() {
        return "Fraction(Numerator: " + numerator +", Denominator: " + denominator+")";
    }

    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(1,2);
        Fraction fraction2 = new Fraction(3,4);

        
        System.out.println("Fraction 1: "+fraction1.toString());
        System.out.println("Fraction 2: "+fraction2.toString());
        Fraction fraction3 = fraction1.add(fraction2);
        System.out.println("Fraction 3 = Fraction1  + Fraction2: "+fraction3.toString());
        fraction3.reducer();
        System.out.println("Reduce Fraction 3: "+fraction3.toString());
    }
}
