package exceptions;

public class NoResourceInitException extends Exception {
    public NoResourceInitException(){
        super();
    }

    public NoResourceInitException(String message){
        super(message);
    }

}