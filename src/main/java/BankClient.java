import java.util.Scanner;

public class BankClient {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your preferred name?");
        String name = scan.nextLine();

        // Create a bank account with the given name and random account number
        BankAccount account = new BankAccount(name);

    }
}
