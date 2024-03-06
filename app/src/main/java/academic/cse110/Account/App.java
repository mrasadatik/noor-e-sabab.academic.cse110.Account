package academic.cse110.Account;

import java.util.Date;

class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    @SuppressWarnings("FieldMayBeFinal")
    private Date dateCreated;
    
    public Account() {
        id = 0;
        balance = 0.0;
        annualInterestRate = 0.0;
        dateCreated = new Date();
    }
    
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        annualInterestRate = 0.0;
        dateCreated = new Date();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    
    public Date getDateCreated() {
        return dateCreated;
    }
    
    public double getMonthlyInterestRate() {
        return (annualInterestRate / 12 ) / 100;
    }
    
    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}

public class App {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000);
        account.setAnnualInterestRate(4.5);
        
        account.withdraw(2500);
        
        account.deposit(3000);

        System.out.println("Balance: $" + account.getBalance());
        System.out.println("Monthly Interest: $" + account.getMonthlyInterest());
        System.out.println("Date Created: " + account.getDateCreated());
    }
}
