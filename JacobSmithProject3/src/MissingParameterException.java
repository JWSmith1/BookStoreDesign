/**
 * Customer exception for a missing parameter from the line created from input file
 *
 * @author Jacob Smith
 * @version Spring 22 - ITSC 1213
 */
public class MissingParameterException extends Exception{
    // Exception for missing parameters of Lines from input file
    public MissingParameterException(String msg){
        super(msg);
    }
}
