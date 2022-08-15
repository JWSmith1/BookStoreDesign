import java.util.ArrayList;
import java.util.Collections;

/**
 * Inventory Class for Product Management System(Project 1)
 *
 * Customers can view and select from Books, CDs and DVDs to add to shopping cart
 * Store Manager can add / remove Books, CDs and DVDs
 *
 * Contains ArrayList of DVDs, CDs and Books
 * ITSC 1213 Spring 22
 *
 * @author Jacob Smith
 * @version Spring 22
 */

public class Inventory {
    public ArrayList<DVD> dvdArrayList = new ArrayList<>();
    public ArrayList<CD> cdArrayList = new ArrayList<>();
    public ArrayList<Book> bookArrayList = new ArrayList<>();

    /**
     *
     * @return DVD Inventory
     */
    public ArrayList<DVD> getDvdArrayList() {
        return dvdArrayList;
    }

    /**
     *
     * @return CD Inventory
     */
    public ArrayList<CD> getCdArrayList() {
        return cdArrayList;
    }

    /**
     *
     * @return Book Inventory
     */
    public ArrayList<Book> getBookArrayList() {
        return bookArrayList;
    }

    /**
     *
     * @param name Name of new DVD
     * @param quantity Amount of the new DVD in stock
     * @param price Price of new DVD
     * @return Returns updated DVD Inventory with new DVD
     */
    public ArrayList<DVD> addDvd(String name, int quantity, double price){
        DVD extraDvd = new DVD(name, quantity, price);
        dvdArrayList.add(extraDvd);
        return dvdArrayList;
    }

    /**
     *
     * @param name Name of new CD
     * @param quantity Amount of new CD in stock
     * @param price Price of new CD
     * @return Returns updated CD Inventory with new CD
     */
    public ArrayList<CD> addCD(String name, int quantity, double price){
        CD extraCD = new CD(name, quantity, price);
        cdArrayList.add(extraCD);
        return cdArrayList;
    }

    /**
     *
     * @param name Name of new Book to add
     * @param quantity Amount of the new book in Stock
     * @param price Price of the new Book
     * @return Returns updated Book Inventory with a new Book
     */
    public ArrayList<Book> addBook(String name, int quantity, double price){
        Book extraBook = new Book(name, quantity, price);
        bookArrayList.add(extraBook);
        return bookArrayList;
    }

    // Sorting Method for Customer to view each Inventory by Price low to high

    /**
     * Sorting Prices low to high for DVD Inventory
     */
    public void dvdSelectionSort(){
        for (int i = 0; i < dvdArrayList.size() -1; i++){
            int minIndex = i;
            for (int j = i + 1; j < dvdArrayList.size(); j++){
                if (dvdArrayList.get(j).getPrice() < dvdArrayList.get(minIndex).getPrice()){
                    minIndex = j;
                }

            }
            // Swapping element i with new value of minIndex given in if statement in DVD Inventory
            Collections.swap(dvdArrayList, i, minIndex);
        }
    }

    /**
     * Sorting Prices low to high for CD Inventory
     */
    public void cdSelectionSort(){
        for (int i = 0; i < cdArrayList.size() -1; i++){
            int minIndex = i;
            for (int j = i + 1; j < cdArrayList.size(); j++){
                if (cdArrayList.get(j).getPrice() < cdArrayList.get(minIndex).getPrice()){
                    minIndex = j;
                }

            }
            // Swapping element i with new value of minIndex given in if statement in CD Inventory
            Collections.swap(cdArrayList, i, minIndex);
        }
    }

    /**
     * Sorting Prices low to high for Book Inventory
     */
    public void bookSelectionSort(){
        for (int i = 0; i < bookArrayList.size() -1; i++){
            int minIndex = i;
            for (int j = i + 1; j < bookArrayList.size(); j++){
                if (bookArrayList.get(j).getPrice() < bookArrayList.get(minIndex).getPrice()){
                    minIndex = j;
                }

            }
            // Swapping element i with new value of minIndex given in if statement in Book Inventory
            Collections.swap(bookArrayList, i, minIndex);
        }
    }

    public int findCD(String name){
        for (int i = 0; i < cdArrayList.size(); i++){
            if (cdArrayList.get(i).getName().equals(name)){
                return i;
            }

        }
        return -1;

    }

    public int findDVD(String name){
        for (int i = 0; i < dvdArrayList.size(); i++){
            if (dvdArrayList.get(i).getName().equals(name)){
                return i;
            }

        }
        return -1;

    }

    public int findBook(String name){
        for (int i = 0; i < bookArrayList.size(); i++){
            if (bookArrayList.get(i).getName().equals(name)){
                return i;
            }

        }
        return -1;

    }

    /**
     *
     * @param remove Title of CD to remove
     * @param x New Quantity to Set that title too
     */
    public void removeCdInventory(String remove, int x){
        int removeCD = findCD(remove);
        cdArrayList.get(removeCD).setQuantity(x);

    }

    // Remove items from Inventory that have been added to shopping cart, need to finish shopping cart

    /**
     *
     * @param remove Title of DVD to remove
     * @param x New quantity to set title to
     */
    public void removeDVDInventory(String remove, int x){
        int removeDVD = findDVD(remove);
        dvdArrayList.get(removeDVD).setQuantity(x);

    }

    // Remove items from Inventory that have been added to shopping cart, need to finish shopping cart

    /**
     *  @param remove Title of Book to remove
     * @param x New quantity to set title to
     */
    public void removeBookInventory(String remove, int x){
        int removeBook = findBook(remove);
        bookArrayList.get(removeBook).setQuantity(x);
    }



    /**
     * constructs an inventory of 5 dvds, cds, and books and adds them to their respective arraylist
     */
    public Inventory(){
        // Add 5 DVDs
        DVD deadpool = new DVD("Deadpool", 2, 4.99);
        DVD moana = new DVD("Moana", 3, 3.99);
        DVD doctorStrange = new DVD("DoctorStrange", 1, 5.99);
        DVD zootopia = new DVD("Zootopia", 2, 4.99);
        DVD snowden = new DVD("Snowden",1, 7.99);

        // Add 5 CDs
        CD bad = new CD("Bad", 2, 3.99);
        CD darkSideOfMoon = new CD("TheDarkSideofTheMoon",3, 2.99);
        CD backInBlack = new CD("BackInBlack", 2, 1.99);
        CD theBodyGuard = new CD("TheBodyguard", 3, 4.99);
        CD rumours = new CD("Rumours", 4, 2.99);

        // Add 5 Books
        Book warAndPeace = new Book("WarAndPeace", 2, 15.99);
        Book greatGatsby = new Book("TheGreatGatsby", 4, 10.99);
        Book odyssey = new Book("TheOdyssey", 3, 13.99);
        Book theAlchemist = new Book("TheAlchemist",2, 11.99);
        Book macbeth = new Book("MacBeth", 5, 14.99);

        // Add Each DVD to DVD ArrayList
        dvdArrayList.add(deadpool);
        dvdArrayList.add(moana);
        dvdArrayList.add(doctorStrange);
        dvdArrayList.add(zootopia);
        dvdArrayList.add(snowden);

        // Add Each CD to CD ArrayList
        cdArrayList.add(bad);
        cdArrayList.add(darkSideOfMoon);
        cdArrayList.add(backInBlack);
        cdArrayList.add(theBodyGuard);
        cdArrayList.add(rumours);

        // Add Each Book to Book ArrayList
        bookArrayList.add(warAndPeace);
        bookArrayList.add(greatGatsby);
        bookArrayList.add(odyssey);
        bookArrayList.add(theAlchemist);
        bookArrayList.add(macbeth);

    }
}
