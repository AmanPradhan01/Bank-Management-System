import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    String accountNumber;
    String name;
    double balance;

    public Customer(String accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }
}

public class BankDetails {
    private ArrayList<Customer> customers;

    public BankDetails() {
        customers = new ArrayList<>();
    }

    public void openAccount(String accountNumber, String name, double initialBalance) {
        customers.add(new Customer(accountNumber, name, initialBalance));
        System.out.println("Account opened successfully for " + name );
        System.out.println("Account NUmber : " + accountNumber);
    }

    public void withdrawMoney(String accountNumber, double amount) {
        for (Customer customer : customers) {
            if (customer.accountNumber.equals(accountNumber)) {
                if (amount > 0 && amount <= customer.balance) {
                    customer.balance -= amount;
                    System.out.println("Withdrawal successful. Remaining balance: " + customer.balance);
                } else {
                    System.out.println("Invalid withdrawal amount or insufficient funds.");
                }
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void deposit(String accountNumber, double amount) {
        for (Customer customer : customers) {
            if (customer.accountNumber.equals(accountNumber)) {
                if (amount > 0) {
                    customer.balance += amount;
                    System.out.println("Deposit successful. Updated Balance: " + customer.balance);
                } else {
                    System.out.println("Invalid Deposit amount.");
                }
                return;
            }
        }
        System.out.println("Account Not Found.");
    }

    public void search(String accountNumber) {
        for (Customer customer : customers) {
            if (customer.accountNumber.equals(accountNumber)) {
                System.out.println("Account details for " + customer.name + ":");
                System.out.println("Account Number: " + customer.accountNumber);
                System.out.println("Name: " + customer.name);
                System.out.println("Balance: " + customer.balance);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankDetails bank = new BankDetails();

        do {
            System.out.println("Choose an option:");
            System.out.println("1. Open Account");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit");
            System.out.println(" 4. Search");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Enter Account Number :");
                    String accNum = scanner.nextLine();
                    System.out.println("Enter Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Initial Balance :");
                    double initialBalance = scanner.nextDouble();
                    bank.openAccount(accNum, name, initialBalance);
                    break;
                case 2:
                    System.out.println("Enter account number :");
                    String withdrawAccNum = scanner.nextLine();
                    System.out.println("Enter withdrawal amount :");
                    double withdrawAmount = scanner.nextDouble();
                    bank.withdrawMoney(withdrawAccNum, withdrawAmount);
                    break;
                case 3:
                    System.out.println("Enter account number :");
                    String depositAccNum = scanner.nextLine();
                    System.out.println("Enter deposit amount :");
                    double depositAmount = scanner.nextDouble();
                    bank.deposit(depositAccNum, depositAmount);
                    break;
                case 4:
                    System.out.println("Enter account number :");
                    String searchAccNum = scanner.nextLine();
                    bank.search(searchAccNum);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (true);
    }
}
