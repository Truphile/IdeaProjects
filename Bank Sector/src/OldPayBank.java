import java.util.Scanner;

public class OldPayBank {

    private static final Scanner input = new Scanner(System.in);
    private static final BankApp bank = new BankApp();

    public static void main(String[] args) {

        System.out.println("==== WELCOME TO OLD-PAY BANK ====");

        while (true) {
            printMenu();
            System.out.print("Choose option: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> transfer();
                case 5 -> checkBalance();
                case 6 -> exitApp();
                default -> System.out.println("Invalid option.\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("""
                
                1. Create Account
                2. Deposit
                3. Withdraw
                4. Transfer
                5. Check Balance
                6. Exit
                
                """);
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (Exception e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter name: ");
        String name = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        int accNo = bank.createAccount(name, password);

        System.out.println("Account created! This your Account number: " + accNo + "\n");
    }

    private static void deposit() {
        System.out.print("Enter account number: ");
        int accNo = readInt();

        System.out.print("Enter amount: ");
        int amount = readInt();

        try {
            bank.deposit(accNo, amount);
            System.out.println("Deposit successful.\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    private static void withdraw() {
        System.out.print("Enter account number: ");
        int accNo = readInt();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter amount: ");
        int amount = readInt();

        try {
            bank.withdraw(accNo, amount, password);
            System.out.println("Withdrawal successful");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    private static void transfer() {
        System.out.print("Enter sender account number: ");
        int accA = readInt();

        System.out.print("Enter sender password: ");
        String password = input.nextLine();

        System.out.print("Enter receiver account number: ");
        int accB = readInt();

        System.out.print("Enter amount: ");
        int amount = readInt();

        try {
            bank.transfer(accA, accB, amount, password);
            System.out.println("Transfer successful.\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    private static void checkBalance() {
        System.out.print("Enter account number: ");
        int accNo = readInt();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        try {
            int bal = bank.checkBalance(accNo, password);
            System.out.println("Current balance: " + bal + "\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    private static void exitApp() {
        System.out.println("Thank you for choosing Old Pay  Bank.\n");
        System.exit(0);
    }


}




