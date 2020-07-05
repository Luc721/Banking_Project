package EXCEPTIONS;

public class AccountNotFound extends RuntimeException
{
    public   AccountNotFound(String s)
    {
        super(s);
    }
}
