import java.util.Scanner;

public class BankAccount {

    private int balance;
    private int previousTransaction;
    private String customerName;
    private String customerId;

    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    public void deposit(int amount){
        if(amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    public void withdraw(int amount){
        if(amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    public void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited: "+previousTransaction);
        }else if(previousTransaction < 0){
            System.out.println("Withdrawn: " +Math.abs(previousTransaction));
        }else{
            System.out.println("No transaction occurred");
        }
    }

    public void showMenu(){
        String option;
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do{
            System.out.println("********************************");
            System.out.println("Enter an option");
            System.out.println("********************************");
            option = scan.nextLine();

            switch (option){
                case "A":
                    System.out.println("********************************");
                    System.out.println("Balance = " + balance);
                    System.out.println("********************************");
                    break;
                case "B":
                    System.out.println("********************************");
                    System.out.println("Enter an amount to deposit");
                    System.out.println("********************************");
                    String amount = scan.nextLine();
                    int amountInt = Integer.parseInt(amount);
                    deposit(amountInt);
                    break;
                case "C":
                    System.out.println("********************************");
                    System.out.println("Enter an amount to withdraw");
                    System.out.println("********************************");
                    String amount2 = scan.nextLine();
                    withdraw(Integer.parseInt(amount2));
                    break;
                case "D":
                    System.out.println("********************************");
                    getPreviousTransaction();
                    System.out.println("********************************");
                    break;
                case "E":
                    System.out.println("********************************");
                    break;
                default:
                    System.out.println("Option Invalid. Try again.");
                    break;
            }

        } while(!option.equals("E"));
        System.out.println("Thank you! Come Again.");
    }
}
