package INFO;
import EXCEPTIONS.AccountNotFound;
import java.util.ArrayList;
import java.util.HashMap;

public class DAO
{

    HashMap<Integer, Account> HashMap = new HashMap<>();
    HashMap<Integer, ArrayList<Integer>> transactionsHashMap = new HashMap<>();


    Account CreateNewAccount(Account ref)
    {
        if(HashMap.containsKey(ref.getAccountNumber()))
            System.out.println("Account Already Exists");
        else
        {
            HashMap.put(ref.getAccountNumber(),ref);
            ArrayList<Integer> al = new ArrayList<>();
            al.add(ref.getCurrentBalance());
            transactionsHashMap.put(ref.getAccountNumber(),al);
            System.out.println("Your account has been successfully created");
        }
        return ref;
    }

    Account GetDetails(int accountNumber) throws AccountNotFound
    {
        Account ref ;
        if(!HashMap.containsKey(accountNumber))
        {
            throw new AccountNotFound("No such account exists,Account number: "+accountNumber);
        }
        else
        {
            ref = HashMap.get(accountNumber);
        }
        return ref;
    }

    Account UpdateAccount(Account ref,int transaction,int typeOfTransaction)
    {
        HashMap.put(ref.getAccountNumber(),ref);
        ArrayList<Integer> al = transactionsHashMap.get(ref.getAccountNumber());
        if(typeOfTransaction<0)
        al.add(-transaction);
        else
            al.add(transaction);
        return ref;
    }

    void Delete(int accountNumber)

    {
        HashMap.remove(accountNumber);
    }

}
