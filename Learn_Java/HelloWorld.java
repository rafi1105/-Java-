import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        int num;

        System.out.println("Enter integers to sum:");
        while (sum <= 100) {
            num = input.nextInt();
            sum += num;
        }
        System.out.println("Done");
    }
}
