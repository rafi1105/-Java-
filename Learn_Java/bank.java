
public class bank {
    public static void main(String[] args) {
        b account = new b(1000);
        try{
            account.withdraw(1500);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
class b{
    private double balance;
    b(double balance)
    {
        this.balance = balance;
    }

void withdraw(double amount) throws InsufficientBalanceException
{
    if (amount > balance)
    {
        throw new InsufficientBalanceException("Insufficient Balance");
    }
    balance-=amount;
}
}
