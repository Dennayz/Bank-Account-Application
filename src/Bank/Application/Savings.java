package Bank.Application;

public class Savings extends Account{
    //List properties specific to the savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;


    //Constructor to initialize settings for the Savings properties
    public Savings(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    //set rate for Savings account
    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    /**
     * set Savings Account holders Safety Deposit Box with an
     * identified 3-digit number and accessed with a 4-digit code
     */
    private void setSafetyDepositBox() {
        //generate three digit integer
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }


    //List any methods specific to savings account
    //overriding the parent class Account
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Your Savings Account Features: " +
                           "\n Safety Deposit Box ID: " + safetyDepositBoxID +
                           "\n Safety Deposity Box Key: " + safetyDepositBoxKey);

    }
}
