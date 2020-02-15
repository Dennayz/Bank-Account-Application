package Bank.Application;

public class Checking extends Account{
    //List properties specific to a checking account
    private int debitCardNumber;
    private int debitCardPin;


    //Constructor to initialize checking account properties
    public Checking(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    //Set rate for Checking account
    @Override
    public void setRate() {
        rate = getBaseRate() * 0.15;
    }

    //Checking account need debit card and debit card PIN
    private void setDebitCard() {
        debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        debitCardPin = (int) (Math.random() * Math.pow(10, 4));

    }

    //List any methods specific to the checking account
    //overriding the parent class Account
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Your Checking Account Features: " +
                           "\n DEBIT CARD: " + this.debitCardNumber +
                           "\n PIN: " + this.debitCardPin);
    }
}
