import java.util.Scanner;

class User {
    private double accountBalance;

    public User(double initialBalance) {
        this.accountBalance = initialBalance;
    }
     
    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

}

class ATM {
    private User user;

    public ATM(User user){
        this.user = user;
    }
    
    public void withdraw(double amount){
        if (amount > 0 && amount <= user.getAccountBalance()) {
            user.setAccountBalance(user.getAccountBalance() - amount);
            System.out.printf(" Whithdrawal successful. Remaining balance : $%.2f%n ", user.getAccountBalance());

        }else {
            System.out.println("Invalid Withdrawal amount or insufficient balance.");

        }
    }

    public void deposit(double amount) {
        if (amount > 0){
            user.setAccountBalance(user.getAccountBalance() + amount);
            System.out.printf("Deposit successful. New balance: $%.2f%n", user.getAccountBalance());

        }else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void checkBalance() {
        System.out.printf("Current balance: $%.2f%n", user.getAccountBalance());
    }
}

public class Main2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double initialBalance = scanner.nextDouble();

        User user = new User(initialBalance);
        ATM atm = new ATM(user);

        while (true) {
            System.out.println("\nATM Menu");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice (1 to 4):  ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;   
                    
                case 2:
                    System.out.print("Enter deposit amoun: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    atm.checkBalance();
                    break;    
                
                case 4:
                    System.out.print("Exiting the ATM. thank you!");
                    scanner.close();
                    System.exit(0);
                    break;
                
                default:
                System.out.println("Invalid choice. Please enter a number 1 to 4.");
            }
        }

        
    }
}