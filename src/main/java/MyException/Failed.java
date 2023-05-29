package MyException;

/**
 * clasa in care implementez viitoarele exceptii ce vor fi aruncate
 */

public class Failed extends RuntimeException{
    public Failed(String s) {
        super(s);
    }
}