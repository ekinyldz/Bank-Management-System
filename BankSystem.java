import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankSystem {
    private static Map<String, Double> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nBank Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Authenticate User");
            System.out.println("3. Balance Inquiry");
            System.out.println("4. Deposit");
            System.out.println("5. Withdrawal");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    authenticateUser();
                    break;
                case 3:
                    balanceInquiry();
                    break;
                case 4:
                    deposit();
                    break;
                case 5:
                    withdrawal();
                    break;
                case 0:
                    System.out.println("Exiting the Bank Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void createAccount() {
        System.out.print("Enter username: ");
        String username = scanner.next();

        if (!accounts.containsKey(username)) {
            System.out.print("Enter initial deposit amount: ");
            double initialDeposit = scanner.nextDouble();
            accounts.put(username, initialDeposit);
            System.out.println("Account created successfully!");
        } else {
            System.out.println("Username already exists. Please choose a different username.");
        }
    }

    private static void authenticateUser() {
        System.out.print("Enter username: ");
        String username = scanner.next();

        if (accounts.containsKey(username)) {
            System.out.print("Enter password: ");
            // For simplicity, we're not implementing a real password system in this example.
            // You can enhance this by using secure password handling techniques.
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Username not found. Please create an account first.");
        }
    }

    private static void balanceInquiry() {
        System.out.print("Enter username: ");
        String username = scanner.next();

        if (accounts.containsKey(username)) {
            System.out.println("Balance: $" + accounts.get(username));
        } else {
            System.out.println("Username not found. Please create an account first.");
        }
    }

    private static void deposit() {
        System.out.print("Enter username: ");
        String username = scanner.next();

        if (accounts.containsKey(username)) {
            System.out.print("Enter deposit amount: ");
            double depositAmount = scanner.nextDouble();
            accounts.put(username, accounts.get(username) + depositAmount);
            System.out.println("Deposit successful. New balance: $" + accounts.get(username));
        } else {
            System.out.println("Username not found. Please create an account first.");
        }
    }

    private static void withdrawal() {
        System.out.print("Enter username: ");
        String username = scanner.next();

        if (accounts.containsKey(username)) {
            System.out.print("Enter withdrawal amount: ");
            double withdrawalAmount = scanner.nextDouble();

            if (accounts.get(username) >= withdrawalAmount) {
                accounts.put(username, accounts.get(username) - withdrawalAmount);
                System.out.println("Withdrawal successful. New balance: $" + accounts.get(username));
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Username not found. Please create an account first.");
        }
    }
}
