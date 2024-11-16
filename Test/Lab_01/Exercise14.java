import java.util.Scanner;


public class Exercise14 {
    public static void vendingMachine(){
        Scanner scanner = new Scanner(System.in);
        int choose;
        do {
            System.out.printf("----Menu----\n1. Coca\n2. Pepsi\n3. Sprite\n4. Snack\n5. Shutdown Machine\n");
            System.out.println("Please enter the number");
            choose = scanner.nextInt();

            int inputMoney;
            switch (choose) {
                case 1:
                    System.out.println("The price of Coca is: 2$, please enter the amount of money:");
                    inputMoney = scanner.nextInt();
                    if (inputMoney < 2) {
                        System.err.println("Not enough money to buy this item. Please select again.\n");
                        break;
                    }
                    System.out.printf("Your change is %d$\n",inputMoney-2);
                    break;
                case 2:
                    System.out.println("The price of Coca is: 3$, please enter the amount of money:");
                    inputMoney = scanner.nextInt();
                    if (inputMoney < 3) {
                        System.err.println("Not enough money to buy this item. Please select again.\n");
                        break;
                    }
                    System.out.printf("Your change is %d$\n",inputMoney-3);
                    break;
                case 3:
                    System.out.println("The price of Coca is: 4$, please enter the amount of money:");
                    inputMoney = scanner.nextInt();
                    if (inputMoney < 4) {
                        System.err.println("Not enough money to buy this item. Please select again.\n");
                        break;
                    }
                    System.out.printf("Your change is %d$\n",inputMoney-4);
                    break;
                case 4:
                    System.out.println("The price of Coca is: 5$, please enter the amount of money:");
                    inputMoney = scanner.nextInt();
                    if (inputMoney < 5) {
                        System.err.println("Not enough money to buy this item. Please select again.\n");
                        break;
                    }
                    System.out.printf("Your change is %d$\n",inputMoney-5);
                    break;
                case 5:
                    System.out.println("Machine is shutting down");
                    break;
                default:
                    System.out.println("Please enter the valid number.");
                    break;
            }
        } while (choose != 5);
        scanner.close();
    }
    public static void main(String[] args) {
        vendingMachine();
    }
}
