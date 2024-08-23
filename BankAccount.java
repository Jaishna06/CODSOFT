import java.util.Scanner;
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance=initialBalance;
    }
    public void deposit(double amount) {
        if(amount>0) {
            balance+=amount;
            System.out.println("Successfully deposited $" +amount);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }
    public void withdraw(double amount) {
        if (amount>0 && amount<=balance) {
            balance-=amount;
            System.out.println("Successfully withdrew $" + amount);
        } else if (amount>balance) {
            System.out.println("Insufficient balance. Transaction failed.");
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        }
    }
    public double checkBalance() {
        return balance;
    }
}
class ATM {
    private BankAccount account;
    private Scanner sc;
    public ATM(BankAccount account) {
        this.account=account;
        this.sc=new Scanner(System.in);
    }
    public void start() {
        boolean exit=false;
        while (!exit) {
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                    performWithdrawal();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    displayBalance();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private void performWithdrawal() {
        System.out.print("Enter the amount to withdraw: ");
        double amount=sc.nextDouble();
        account.withdraw(amount);
    }
    private void performDeposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount=sc.nextDouble();
        account.deposit(amount);
    }
    private void displayBalance() {
        double balance=account.checkBalance();
        System.out.println("Your current balance is: $" + balance);
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        atm.start();
    }
}