import java.util.Scanner;
abstract class bank{
    bank()
    {

    }
    void getInterest()
    {
        System.out.println("nop");
    }
}
class brac extends bank{
    
    double amount;
    double interest;
void getInterest(int tk){
     interest = (double) 7/100;
        amount= tk + interest*tk;
     System.out.println("your interest is " + amount);  
    //  super.getInterest();
}
void option(int tk){
    int option;
    Scanner scanner = new Scanner(System.in);
    System.out.println("1. Balance");
    System.out.println("2. Loan");
    System.out.println("3. withdraw");
    System.out.println("4. Exit");
    option= scanner.nextInt();
        if (option==1)             balance(tk);
        else if(option==2)       getInterest(tk);
        else if (option==3)      withdraw(tk);
        
}
 void balance(int tk)
{
    System.out.println("your balance is " + tk); 
}
void withdraw(int tk)
{
    System.out.println("Enter the amount to withdraw from the account :");
  Scanner scanner = new Scanner(System.in);
    int withdraw = scanner.nextInt();
    tk= tk-withdraw;
    System.out.println("now your amount is " + tk);
}
}

class test{
    public static void main(String[] args) {
        
            System.out.println("enter your amount");
        
        Scanner input = new Scanner(System.in);
        int tk = input.nextInt();
       
        new brac().option(tk);
    }
}