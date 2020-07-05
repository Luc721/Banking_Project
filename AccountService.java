package INFO;
import EXCEPTIONS.*;
import java.util.ArrayList;
import java.util.HashMap;


class Service
{
    DAO dao = new DAO();

    public Account createAccount(Account ref)
    {
        dao.CreateNewAccount(ref);
        return ref;
    }

    public void checkPin(int AccountNumber,int pin) throws AccountNotFound,PinNotFound
    {
        Account account= dao.GetDetails(AccountNumber);
        if(account.getPin()!=pin)
            throw new PinNotFound("Wrong Pin Entered");


    }

    public  int depositAmount(int accountNumber,int deposit)throws AccountNotFound
    {
        Account ref = dao.GetDetails(accountNumber);
        ref.setCurrentBalance(ref.getCurrentBalance()+deposit);
        dao.UpdateAccount(ref,deposit,1);
        return ref.getCurrentBalance();
    }

    public  int withdraw(int accountNumber,int withdraw)throws AccountNotFound,InsufficientFunds
    {
        Account ref = dao.GetDetails(accountNumber);
        int check;
        check=ref.getCurrentBalance()-withdraw;
        if(check<0)
throw new InsufficientFunds("Insufficient fund available,Fund availiable in account : " +ref.getCurrentBalance());
        else
            ref.setCurrentBalance(check);
        dao.UpdateAccount(ref,withdraw,-1);
        return check;
    }

    public Account getDetails(int accountNumber)
    {
        return dao.GetDetails(accountNumber);
    }

    public boolean checkAccountExist(int accountNumber)throws AccountNotFound
    {
        Account ref = dao.GetDetails(accountNumber);
        return true;
    }

    public ArrayList<Integer> getAllTransaction(int accountNumber)
    {
        return dao.transactionsHashMap.get(accountNumber);
    }

    public int transferFunds(int sender_accountnumber,int receiver_accountnumber,int transfer,Service ref)
    {
       int balance= ref.withdraw(sender_accountnumber,transfer);
        ref.depositAmount(receiver_accountnumber,transfer);
        return balance;
    }

    public void changePin(int accountNumber,int newPin)
    {
        Account ref = dao.GetDetails(accountNumber);
        ref.setPin(newPin);
    }

    public void deleteAccount(int accountNumber)
    {
        dao.Delete(accountNumber);
    }

    public HashMap<Integer,Account> showAllAccounts()
    {
        return dao.HashMap;

    }

}
