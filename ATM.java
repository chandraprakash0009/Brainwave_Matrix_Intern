import java.util.Scanner;

public class ATM {
    private double balance;
    private final Scanner scanner;

    // Constructor
    public ATM(double initialBalance) {
        this.balance = initialBalance;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the menu
    public void showMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    // Method to deposit money
    public void depositMoney() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("You've successfully deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount. Please try again.");
        }
    }

    // Method to withdraw money
    public void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("You've successfully withdrawn $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Please try again.");
        } else {
            System.out.println("Invalid withdrawal amount. Please try again.");
        }
    }

    // Main method to run the ATM
    public void run() {
        boolean exit = false;
        while (!exit) {
            showMenu();
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
            System.out.println(); // Print an empty line for better readability
        }
    }

    // Main method to initiate the ATM
    public static void main(String[] args) {
        ATM atm = new ATM(1000); // Initial balance set to $1000
        atm.run();
    }
}
