package EXCEPTIONS;

public class InsufficientFunds extends RuntimeException
{
    public InsufficientFunds(String s)
    {
        super(s);
    }
}
