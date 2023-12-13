import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Bank 
{
    private Map<String, Account> accounts;

    public Bank() 
    {
        this.accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, String accountHolder, double initialBalance) 
    {
        Account account = new Account(accountNumber, accountHolder, initialBalance);
        accounts.put(accountNumber, account);
        System.out.println("Account created successfully.");
    }

    public void deposit(String accountNumber, double amount) 
    {
        if (accounts.containsKey(accountNumber)) 
        {
            Account account = accounts.get(accountNumber);
            account.deposit(amount);
            System.out.println("Deposit successful. Current balance: " + account.getBalance());
        } 
        else 
        {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String accountNumber, double amount) 
    {
        if (accounts.containsKey(accountNumber)) 
        {
            Account account = accounts.get(accountNumber);
            if (account.withdraw(amount)) 
            {
                System.out.println("Withdrawal successful. Current balance: " + account.getBalance());
            } 
            else 
            {
                System.out.println("Insufficient funds.");
            }
        } 
        else 
        {
            System.out.println("Account not found.");
        }
    }

    public void checkBalance(String accountNumber) 
    {
        if (accounts.containsKey(accountNumber)) 
        {
            Account account = accounts.get(accountNumber);
            System.out.println("Current balance: " + account.getBalance());
        } 
        else 
        {
            System.out.println("Account not found.");
        }
    }
}

class Account 
{
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) 
    {
        balance += amount;
    }

    public boolean withdraw(double amount) 
    {
        if (amount <= balance) 
        {
            balance -= amount;
            return true;
        } 
        else 
        {
            return false;
        }
    }

    public double getBalance() 
    {
        return balance;
    }
}

public class BankManagementSystem 
{
    public static void main(String[] args) 
    {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String accountHolder = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    bank.createAccount(accountNumber, accountHolder, initialBalance);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bank.deposit(accountNumber, depositAmount);
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    bank.withdraw(accountNumber, withdrawalAmount);
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    bank.checkBalance(accountNumber);
                    break;

                case 5:
                    System.out.println("Exiting program. Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
