/**
 * Class that defines how to import Items or Members from a file following the structure
 * defined in Project 3 Information on Canvas
 *
 * @author Jacob Smith
 * @version Spring 22 - ITSC 1213
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputFile{

    /**
     *
     * @param filename Input File Manager wants to import from
     * @param index Line of File to read in
     * @return Returns a String Array of each line from the file for the manager to parse and import from.
     * @throws FileNotFoundException if filename entered does not exist
     * @throws InputMismatchException if input other than what is defined is found
     */
    public static String[] linesOfFile(String filename, int index) throws FileNotFoundException{
        ArrayList<String> file = new ArrayList<>();
        String[] lineData;
        Scanner input = new Scanner(new File(filename));
        while(input.hasNextLine()){
            file.add(input.nextLine());
        }
        String line = file.get(index);
        lineData = line.split(",");

        return lineData;

    }

    /**
     *
     * @param index Line of file Manager wants to import, only Items
     * @param filename File inside of Project folder you want to import. Must Follow structure defined in Project 3.
     * @return Returns Item for manager to add to inventory
     * @throws FileNotFoundException if input file is not found
     * @throws InputMismatchException if other input than standard is inputted
     * @throws EmptyDataSetException if the data String array created is empty from the lineOfFile created
     * @throws MissingParameterException if a index of the String array data is empty
     */
    public static Item createItems(String filename, int index) throws FileNotFoundException, InputMismatchException, EmptyDataSetException, MissingParameterException {
        Item fileItem = null;
        String[] data = linesOfFile(filename, index);
        if (data.length == 0){
            throw new EmptyDataSetException("Line is empty.");
        }
        for (String dataIndex : data) {
            if (dataIndex.isEmpty()) {
                throw new MissingParameterException("Missing Parameter");
            }
        }

        if (data[0].equals("Item")){
            if (data[1].equals("[book")){
                String name = data[2];
                String quant = data[4];
                String[] quantForBook = quant.split("]");
                int quantity = Integer.parseInt(quantForBook[0]);
                double price = Double.parseDouble(data[3]);
                fileItem = new Book(name, quantity, price);

            }
            else if(data[1].equals("[DVD")){
                String name = data[2];
                String quant = data[4];
                String[] quantForDVD = quant.split("]");
                int quantity = Integer.parseInt(quantForDVD[0]);
                double price = Double.parseDouble(data[3]);
                fileItem = new DVD(name, quantity, price);

            }
            else if(data[1].equals("[CD")){
                String name = data[2];
                String quant = data[4];
                String[] quantForCD = quant.split("]");
                int quantity = Integer.parseInt(quantForCD[0]);
                double price = Double.parseDouble(data[3]);
                fileItem = new CD(name, quantity, price);

            }

        }
        return fileItem;

    }

    /**
     *
     * @param index Line of file that holds customer data
     * @param filename File inside of Project folder you want to import. Must Follow structure defined in Project 3.
     * @return Returns a customer object that can be added to customer database by manager
     * @throws FileNotFoundException if input.txt is not found
     * @throws EmptyDataSetException if the data String array created is empty from the lineOfFile created
     * @throws InputMismatchException if other input than standard is inputted
     * @throws MissingParameterException if a index of the String array data is empty
     */
    public static Customer createCustomer(String filename, int index) throws FileNotFoundException, InputMismatchException, EmptyDataSetException, MissingParameterException {
        Customer fileCustomer = null;
        String[] data = linesOfFile(filename, index);
        if (data.length == 0){
            throw new EmptyDataSetException("Line is empty.");
        }
        for (String datum : data) {
            if (datum.isEmpty()) {
                throw new MissingParameterException("Missing Parameter");
            }
        }
        if (data[0].equals("Member")){
            if (data[1].equals("[free")){
                String payMethod = data[2];
                String[] cardNum = payMethod.split("]");
                int customerNum = Integer.parseInt(cardNum[0]);
                fileCustomer = new Customer("N/A", customerNum, false, 0.0);
            }
            else if(data[1].equals("[Premium")){
                String payMethod = data[2];
                String[] cardNum = payMethod.split("]");
                int customerNum = Integer.parseInt(cardNum[0]);
                fileCustomer = new Customer("N/A", customerNum, true, 0.0);

            }
        }
        return fileCustomer;
    }





}


