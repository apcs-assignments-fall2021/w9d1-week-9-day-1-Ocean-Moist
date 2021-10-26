public class BankAccount {
    // Instance variables
    private int balance;
    private final long accountNumber;
    private String preferredName;

    public BankAccount(String preferredName) {
        this.accountNumber = (long) (Math.random() * Math.pow(2,63));
        this.balance = 0;
        this.preferredName = preferredName;
    }
    public void withdraw(int amt){
        if (amt > balance) {
            System.out.println("your broke you cant afford that");
        } else {
            this.balance -= amt;
            System.out.println("withdrawed $" + amt);
        }
    }
    public void deposit(int amt) {
        this.balance += amt;
    }

    public int getBalance() {
        return this.balance;
    }
    public long getAccountNumber() {
        return this.accountNumber;
    }
    public String getPreferredName() {
     return this.preferredName;
    }
    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }
    @Override
    public String toString() {
        return "balance=" + this.balance + ", accountNumber=" + this.accountNumber;
    }
}
