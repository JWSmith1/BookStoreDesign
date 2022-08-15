/**
 * Book Class for Product Management System(Project 1)
 * ITSC 1213 Spring 22
 *
 * @author Jacob Smith
 * @version Spring 22
 */

public class Book extends Item{

    /**
     *
     * @param bookName Name of new Book object
     * @param bookQuant Quantity of new Book object
     * @param bookPrice Price of new Book object
     */
    public Book(String bookName, int bookQuant, double bookPrice){
        super(bookName, bookQuant, bookPrice);
    }

    @Override
    public String typeOfItem() {
        return "Book Item";
    }

    @Override
    public String toString(){
        return typeOfItem() + " ---> Title: " + getName() + " Quantity: " + getQuantity() + " Price: " + getPrice();
    }

}
