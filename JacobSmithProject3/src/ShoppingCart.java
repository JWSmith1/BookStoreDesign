import java.util.ArrayList;

/**
 * ShoppingCart Class for Product Management System(Project 1)
 * Details of Order
 * Uses ArrayList to store customers order
 * ITSC 1213 Spring 22
 *
 * @author Jacob Smith
 * @version Spring 22
 */

public class ShoppingCart {

    // Fields for shopping Cart Class
    private String customerName;
    private String date;
    private ArrayList<DVD> dvdOrder = new ArrayList<>();
    private ArrayList<CD> cdOrder = new ArrayList<>();
    private ArrayList<Book> bookOrder = new ArrayList<>();

    Inventory orderInven = new Inventory();

    /**
     *
     * @return Returns DVD order ArrayList
     */
    public ArrayList<DVD> getDvdOrder() {

        return dvdOrder;
    }

    /**
     *
     * @return Returns CD order ArrayList
     */
    public ArrayList<CD> getCdOrder() {
        return cdOrder;
    }

    /**
     *
     * @return Returns Book order ArrayList
     */
    public ArrayList<Book> getBookOrder() {
        return bookOrder;
    }


    /**
     *
     * @return Returns Customer Name for the Shopping Cart
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     *
     * @param customerName Sets Customer name for Shopping Cart
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     *
     * @return Returns Date for Shopping Cart order
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date Sets date for a shopping cart order
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @param addName Takes in name of CD, finds that CD in the Inventory and adds it to CD Order
     */
    public void addtoCDOrder(String addName){
        int result = orderInven.findCD(addName);
        cdOrder.add(orderInven.cdArrayList.get(result));
    }

    /**
     *
     * @param addName Name of DVD, finds DVD in Inventory and adds to DVD order
     */
    public void addtoDVDOrder(String addName){
        int result = orderInven.findDVD(addName);
        dvdOrder.add(orderInven.dvdArrayList.get(result));
    }

    /**
     *
     * @param addName Name of Book, finds Book in Inventory and adds to Book order
     */
    public void addtoBookOrder(String addName){
        int result = orderInven.findBook(addName);
        bookOrder.add(orderInven.bookArrayList.get(result));
    }


}
