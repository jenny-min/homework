package session08.Exercise04;

public class BankAccount implements IBank{
    //Thuộc tính
    private String accountId;
    private double balance;
    private String userName;
    private String phoneNumber;

    //Constructor
    public BankAccount(String accountId, String userName, String phoneNumber) {
        this.accountId = accountId;
        this.balance = 0.0;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    //getter account
    public String getAccountId() {
        return accountId;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Đã nạp tiền: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Đã rút tiền: " + amount);
        } else {
            System.out.println("Số dư trong tài khoản không đủ!");
        }
    }

    public void displayBalance() {
        System.out.println("Số dư tài khoản (" + getAccountId() + ") : " + balance);
    }
}
