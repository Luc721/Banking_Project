package INFO;

class Account
{
    private String AccountHolderName;
    private  int AccountNumber;
    private int currentBalance;
    private int pin;


    public Account(String AccountHolderName, int AccountNumber, int currentBalance, int pin)
    {
        this.AccountHolderName=AccountHolderName;
        this.AccountNumber=AccountNumber;
        this.currentBalance=currentBalance;
        this.pin=pin;
    }

    public String getAccountHolderName()
    {
        return AccountHolderName;
    }

    public void setAccountHolderName(String s)
    {
        this.AccountHolderName=s;
    }

    public  int getAccountNumber()
    {
        return AccountNumber;
    }

    public void SetAccountNumber(int accountNumber)
    {
        this.AccountNumber=accountNumber;
    }

    public  int getCurrentBalance()
    {
        return currentBalance;
    }

    public   void setCurrentBalance(int currentBalance)
    {
        this.currentBalance=currentBalance;
    }

    public int getPin()
    {
        return pin;
    }

    public void setPin(int pin)
    {
        this.pin=pin;
    }
}
