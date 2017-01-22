public class UnsolvableException extends Exception {
/**
* Personal exception for unsolvable Equations
*/
    public UnsolvableExceptionException () {

    }

    public UnsolvableException (String message) {
        super (message);
    }

    public UnsolvableException (Throwable cause) {
        super (cause);
    }

    public UnsolvableException (String message, Throwable cause) {
        super (message, cause);
    }
}
