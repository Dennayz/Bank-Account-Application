package Bank.Application;

public abstract class Account implements IBaseRate {
    //List common properties for savings and checking accounts
    private String name;
    private String sSN;
    private double balance;
    private static int index = 10000;
    protected String accountNumber;
    protected double rate;


    //Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;

        //Set account number
        this.accountNumber = setAccountNumber();
        index++;

        setRate();
    }

    /**
     * abstract class used to set Savings and Checking's account rate
     * abstract class is when we cannot create an object from this class which we don't want to
     * but we will create them in our Savings and Checking's class because we have to inherit
     * from the parent class. We are creating the architecture in the Account class
     */
    public abstract void setRate();

    /**
     * Generate account holder's Account number
     * @return returns 11 digit account number
     */
    private String setAccountNumber() {
        String lastTwoofSSN = sSN.substring(sSN.length()-2, sSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoofSSN + uniqueID + randomNumber;
    }

    public void compound() {
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }

    //List common methods - transactions

    /**
     * Deposit method adds deposited money to current balance
     * @param amount
     */
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    /**
     * WithDraw method grabs money out of account holder's account
     * @param amount
     */
    public void withDraw(double amount) {
        balance = balance - amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }

    /**
     * Transfer method moves money to another specified account
     * @param toWhere
     * @param amount
     */
    public void transfer(String toWhere, double amount) {
        balance = balance - amount;
        System.out.println("Transfering $" + amount + " to " + toWhere);
        printBalance();
    }

    //show account holder current balance
    public void printBalance() {
        System.out.println("Your balance is now: " + this.balance);
    }

    //Show account holder's basic information
    public void showInfo() {
        System.out.println("NAME: " + this.name + "\n" +
                           "ACCOUNT NUMBER: " + this.accountNumber + "\n" +
                           "BALANCE: " + this.balance +
                           "\nRATE: " + this.rate + "%");
    }
}
