import java.util.Scanner;

public class Banking_App {
    public static void main(String[] args) {
        BankAccount newSummary = new BankAccount("Kondi","B96276");
        newSummary.showMenu();
    }

 static class BankAccount
{
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    BankAccount(String cname, String cid){
        customerID = cid;
        customerName = cname;

    }
    void deposit(int amount){
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
            System.out.println("you have deposited £"+amount+" into your account");
        }
    }

    void withdraw(int amount){
        if (amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
            System.out.println("you have withdrawn £"+amount+" out your account");
        }
    }

     void  getPreviousTransaction() {
        if (previousTransaction > 0){
            System.out.println("Deposited "+ previousTransaction);
    }
        else if (previousTransaction < 0){
            System.out.println("Withdrawn"+ Math.abs(previousTransaction));
        }
    }

    void interstRate(int years){

        double interestRate = 0.3;
        double newBalance = (balance*interestRate*years)+balance;
        System.out.println("your new balance is \n"+ newBalance);

    }
     void showMenu()
    {
        String option;
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        System.out.println("Welcome "+ customerName+"\nYour ID is "+customerID);
        System.out.println("A) Check Balance, B) Deposit, C)Withdraw, D) Previous Transaction, E) Exit,  F)Check Interest");

        while( i == 1 ){

            System.out.println("=============================================================");
            System.out.println("Select an option");
            System.out.println("=============================================================");
            option = scanner.next();

            if(option.equals("A")||option.equals("a")){
                System.out.println("Your balance is £"+balance);
            }
            else if (option.equals("B")||option.equals("b")){
                int x = scanner.nextInt();
                deposit(x);
            }
            else if (option.equals("C")||option.equals("c")){
                int x = scanner.nextInt();
                withdraw(x);
            }
            else if (option.equals("D")||option.equals("d")){
                getPreviousTransaction();
            }
            else if (option.equals("E")|| option.equals("e"))
            {
                System.out.println("=============================================================");
                System.out.println("Logging out");
                System.out.println("=============================================================");
                i++;
            }
            else if (option.equals("F")|| option.equals("f")){
                System.out.println("how many years do you plan on leaving this amount?\n");
                double x = scanner.nextDouble();
                interstRate((int) x);
            }

        }
    }
}}
