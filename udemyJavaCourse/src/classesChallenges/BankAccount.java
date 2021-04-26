package classesChallenges;

public class BankAccount {



    private String customerName;
    private int accountNumber;
    private double balance;
    private String email;
    private String phoneNumber;

    public BankAccount(){
        this("default name", 12345,
                0.0, "default email", "default phone number");
    }

    public BankAccount(String customerName, String email, String phoneNumber) {
       this(customerName,12345, 100.55, email, phoneNumber);
    }

    public BankAccount(String customerName, int accountNumber,
                       double balance, String email, String phoneNumber){

        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        System.out.println(balance);
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void deposit(double amount){
        balance += amount;
        System.out.println(balance);
    }

    public void withdraw (double amount){
        if (balance >= amount){
            balance-= amount;
            System.out.println("New balance is " + balance);
        } else
            System.out.println("Funds not enough");


    }


}
