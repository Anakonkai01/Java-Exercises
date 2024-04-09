package exercise4;

import java.util.Scanner;
import java.util.Vector;

public class Exercise4 {
    public static Vector<Long> calculateFx (Vector<Integer> X){
        Vector<Long> Y = new Vector<>();
        for(Integer x : X){

            Y.add((2L*x*x));
        }
        return Y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of Vector:");
        int n = scanner.nextInt();
        Vector<Integer> X = new Vector<>(n);
        System.out.println("Enter the values of X:");
        for (int i = 0; i < n; i++) {
            System.out.print("X[" + i + "]: ");
            int value = scanner.nextInt();
            X.add(value);
        }

        Vector<Long> Y = calculateFx(X);
        System.out.println("Values of F(x): " + Y);
        }
}
