/**
 * Custom exception for an input file with missing data
 *
 * @author Jacob Smith
 * @version Spring 22 - ITSC 1213
 */

public class EmptyDataSetException extends Exception{
    // Exception with custom message for an empty dataset
    public EmptyDataSetException(String msg){
        super(msg);
    }


}
