import java.util.*;


public class BankingApplication{
    public static void main(String[] args) {
        BankAccount obj=new BankAccount("Hari Priya", "AB1234");
        obj.showMenu();
    }
}

class BankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;
     

    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    void deposit(int amount){
        if(amount!=0){
            balance+=amount;
            previousTransaction=amount;

        }
    }

    void withdrawn(int amount){
        if(amount!=0){
            balance-=amount;
            previousTransaction= -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction>0)
            System.out.println("Deposited:"+previousTransaction);
        else if(previousTransaction<0)
            System.out.println("Withdrawn : "+Math.abs(previousTransaction));
        else
            System.out.println("No Transaction History");
    }


    void showMenu(){
        char option='\0';
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome "+customerName);
        System.out.println("Your Id is "+customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdrawn");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");

        do { 
            System.out.println("=========================================================================");
            System.out.println("Enter an option");
            System.out.println("=========================================================================");
            option=sc.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("Balance = "+balance);
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("Enter an amount to deposit : ");
                    System.out.println("------------------------------------------------------------------");
                    int amount=sc.nextInt();
                    deposit(amount);
                    System.out.println("Balance amount is: "+balance);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("Enter an amount to Withdrawn : ");
                    System.out.println("------------------------------------------------------------------");
                    int amount2=sc.nextInt();
                    withdrawn(amount2);
                    System.out.println("Balance amount is: "+balance);
                    System.out.println("\n");
                    break;
                case 'D':
                System.out.println("------------------------------------------------------------------");
                getPreviousTransaction();
                System.out.println("------------------------------------------------------------------");
                System.out.println("\n");
                    break;
                case 'E':
                    System.out.println("****************************************************************");
                    System.out.println("Thank You for using our Services!!");
                    break;
                default:
                    System.out.println("Invalid Option!!. Please Try again");
            }
            
        } while (option!='E');
    }

}
