import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

class InventoryTest {

    Inventory inven = new Inventory();

    @Test
    void getDvdArrayList() {
        System.out.println(inven.getDvdArrayList());
    }

    @Test
    void getCdArrayList() {
        System.out.println(inven.getCdArrayList());
    }

    @Test
    void getBookArrayList() {
        System.out.println(inven.getBookArrayList());
    }

    @Test
    ArrayList<DVD> addDvd() {
        String name = "Example";
        int quant = 1;
        double price = 1.99;
        DVD testDVD = new DVD(name, quant, price);
        inven.dvdArrayList.add(testDVD);
        return inven.dvdArrayList;
    }

    @Test
    ArrayList<CD> addCD() {
        String name = "Example";
        int quant = 1;
        double price = 1.99;
        CD testCD = new CD(name, quant, price);
        inven.cdArrayList.add(testCD);
        return inven.cdArrayList;
    }

    @Test
    ArrayList<Book> addBook() {
        String name = "Example";
        int quant = 1;
        double price = 1.99;
        Book testBook = new Book(name, quant, price);
        inven.bookArrayList.add(testBook);
        return inven.bookArrayList;
    }

    @Test
    void dvdSelectionSort() {
        // Print unsorted dvd list
        System.out.println(inven.getDvdArrayList());
        // Method to sort list
        for (int i = 0; i < inven.dvdArrayList.size() -1; i++){
            int minIndex = i;
            for (int j = i + 1; j < inven.dvdArrayList.size(); j++){
                if (inven.dvdArrayList.get(j).getPrice() < inven.dvdArrayList.get(minIndex).getPrice()){
                    minIndex = j;
                }

            }
            // Swapping element i with new value of minIndex given in if statement in DVD Inventory
            Collections.swap(inven.dvdArrayList, i, minIndex);
        }

        // Output new sorted List
        System.out.println(inven.getDvdArrayList());
    }

    @Test
    void cdSelectionSort() {
        // Print unsorted cd list
        System.out.println(inven.getCdArrayList());
        // Method to sort list
        for (int i = 0; i < inven.cdArrayList.size() -1; i++){
            int minIndex = i;
            for (int j = i + 1; j < inven.cdArrayList.size(); j++){
                if (inven.cdArrayList.get(j).getPrice() < inven.cdArrayList.get(minIndex).getPrice()){
                    minIndex = j;
                }

            }
            // Swapping element i with new value of minIndex given in if statement in CD Inventory
            Collections.swap(inven.cdArrayList, i, minIndex);
        }

        // Output new sorted List
        System.out.println(inven.getCdArrayList());
    }

    @Test
    void bookSelectionSort() {
        // Print unsorted book list
        System.out.println(inven.getBookArrayList());
        // Method to sort list
        for (int i = 0; i < inven.bookArrayList.size() -1; i++){
            int minIndex = i;
            for (int j = i + 1; j < inven.bookArrayList.size(); j++){
                if (inven.bookArrayList.get(j).getPrice() < inven.bookArrayList.get(minIndex).getPrice()){
                    minIndex = j;
                }

            }
            // Swapping element i with new value of minIndex given in if statement in Book Inventory
            Collections.swap(inven.bookArrayList, i, minIndex);
        }

        // Output new sorted List
        System.out.println(inven.getBookArrayList());
    }

    @Test
    int findCD() {
        String name = "Bad";
        for (int i = 0; i < inven.cdArrayList.size(); i++){
            if (inven.cdArrayList.get(i).getName().equals(name)){
                return i;
            }

        }
        return -1;
    }

    @Test
    int findDVD() {
        String name = "Deadpool";
        for (int i = 0; i < inven.dvdArrayList.size(); i++){
            if (inven.dvdArrayList.get(i).getName().equals(name)){
                return i;
            }

        }
        return -1;


    }

    @Test
    int findBook() {
        String name = "WarAndPeace";
        for (int i = 0; i < inven.bookArrayList.size(); i++){
            if (inven.bookArrayList.get(i).getName().equals(name)){
                return i;
            }

        }
        return -1;
    }

    @Test
    void removeCdInventory() {
        // CD List showing current quantity
        System.out.println(inven.getCdArrayList());
        String remove = "Bad";
        int updateQuant = 1;
        int removeCD = inven.findCD(remove);
        inven.cdArrayList.get(removeCD).setQuantity(updateQuant);
        // Output of new quantity
        System.out.println("Bad Quantity changes from two to one. ");
        System.out.println(inven.getCdArrayList());

    }

    @Test
    void removeDVDInventory() {
        // DVD List showing current quantity
        System.out.println(inven.getDvdArrayList());
        String remove = "Deadpool";
        int updateQuant = 1;
        int removeDVD = inven.findDVD(remove);
        inven.dvdArrayList.get(removeDVD).setQuantity(updateQuant);
        // Output of new quantity
        System.out.println("Deadpool Quantity changes from two to one. ");
        System.out.println(inven.getDvdArrayList());
    }

    @Test
    void removeBookInventory() {
        // Book List showing current quantity
        System.out.println(inven.getBookArrayList());
        String remove = "WarAndPeace";
        int updateQuant = 1;
        int removeBook = inven.findBook(remove);
        inven.bookArrayList.get(removeBook).setQuantity(updateQuant);
        // Output of new quantity
        System.out.println("WarAndPeace Quantity changes from two to one. ");
        System.out.println(inven.getBookArrayList());
    }
}