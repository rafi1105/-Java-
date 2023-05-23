import java.util.Scanner;
 class test{
    public static void main(String[] args) {
        System.out.println("enter your amount: ");
        Scanner input = new Scanner(System.in);
        double tk =input.nextInt();
        System.out.println("the amount is : " + tk);
        double interest; double amount;
    void get_interest(double tk){
        interest= 7/100;
        amount= tk + tk*interest;
        System.out.println("you balance is : "+ amount);
    }
    }
}