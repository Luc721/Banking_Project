package EXCEPTIONS;

public class PinNotFound extends RuntimeException
{
    public PinNotFound(String s)
    {
        super(s);
    }
}
