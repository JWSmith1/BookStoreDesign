import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main Class for Product Management System(Project 3)
 *
 *
 * ITSC 1213 Spring 22
 *
 * @author Jacob Smith
 * @version Spring 22
 */

public class BookStoreMain {



    public static void main(String[] args) {
        Inventory bookStoreInv = new Inventory();
        StoreManager firstManager = new StoreManager();


        int exit = 1;
        while (exit == 1) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Welcome to the Book Store, please choose from the following menu options: ");
            System.out.println("\t 1. Register as a Customer. You must register to place an order.");
            System.out.println("\t 2. View Inventory");
            System.out.println("\t 3. Place an Order");
            System.out.println("\t 4. Store Manager");
            System.out.println("\t 5. Exit Store");

            int num = scan.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Please enter your name: ");
                    String name = scan.next();
                    System.out.println("Please enter your 8 digit card number: ");
                    int payMethod = scan.nextInt();
                    System.out.println("Would you like to be a premium member? Premium membership is 10.99 a month ");
                    System.out.println("\t Please press 1 for premium or 2 to not become a member:  ");
                    int prem = scan.nextInt();
                    boolean premMem;
                    double moneySpent;
                    // Control structure to determine if a member wants premium or not, sets variable moneySpent
                    if (prem == 1) {
                        premMem = true;
                        moneySpent = 10.99;
                    } else {
                        premMem = false;
                        moneySpent = 0.0;
                    }

                    // Creates new customer object & uses Manager method to add customer to customer database
                    Customer createCustomer = new Customer(name, payMethod, premMem, moneySpent);
                    firstManager.addCustomer(name, payMethod, premMem, moneySpent);
                    break;
                case 2:
                    System.out.println("Below you will find a list of our Iventory of Books, CDs and DVDs");
                    System.out.println("\t Books, CDs, and DVDs are listed by Title, Quantity and Price");
                    System.out.println("***************************************************************");
                    // Print all Books inside BookArrayList
                    for (int i = 0; i < bookStoreInv.bookArrayList.size(); i++) {
                        System.out.println(bookStoreInv.bookArrayList.get(i));
                    }
                    System.out.println("***************************************************************");
                    // Print all Books inside CDArrayList
                    for (int x = 0; x < bookStoreInv.cdArrayList.size(); x++) {
                        System.out.println(bookStoreInv.cdArrayList.get(x));
                    }
                    System.out.println("***************************************************************");
                    // Print all DVDs inside DVD ArrayList
                    for (int x = 0; x < bookStoreInv.dvdArrayList.size(); x++) {
                        System.out.println(bookStoreInv.dvdArrayList.get(x));
                    }
                    System.out.println("***************************************************************");
                    System.out.println("You can also view the Iventory by Price(Low to High) ");
                    System.out.println("\t Press 1 to view Inventory sorted by Price or Press 0 to continue  ");
                    int invenNum = scan.nextInt();
                    if (invenNum == 1) {
                        bookStoreInv.bookSelectionSort();
                        System.out.println("Book Inventory(Price: Low to High)");
                        for (int i = 0; i < bookStoreInv.bookArrayList.size(); i++) {
                            System.out.println(bookStoreInv.bookArrayList.get(i));
                        }
                        System.out.println("***************************************************************");
                        bookStoreInv.cdSelectionSort();
                        System.out.println("CD Inventory(Price: Low to High)");
                        for (int x = 0; x < bookStoreInv.cdArrayList.size(); x++) {
                            System.out.println(bookStoreInv.cdArrayList.get(x));
                        }
                        System.out.println("***************************************************************");
                        bookStoreInv.dvdSelectionSort();
                        System.out.println("DVD Inventory(Price: Low to High)");
                        for (int x = 0; x < bookStoreInv.dvdArrayList.size(); x++) {
                            System.out.println(bookStoreInv.dvdArrayList.get(x));
                        }
                    }
                    else {
                        break;
                    }
                    break;
                case 3:
                    ShoppingCart newCart = new ShoppingCart();
                    System.out.println("Please Enter your name: ");
                    String customerName = scan.next();
                    newCart.setCustomerName(customerName);
                    int customerIndex = firstManager.findCustomer(customerName);


                    int cartControl = 0;
                    while (cartControl == 0){
                        System.out.println("When asked the name of Book, CD or DVD, please enter title with no spaces.");
                        System.out.println("Please choose to order from Books, CDs or DVDs");
                        System.out.println("\t 1. Order Books");
                        System.out.println("\t 2. Order CDs");
                        System.out.println("\t 3. Order DVDs");
                        System.out.println("\t 4. View Shopping Cart");
                        System.out.println("\t 5. Exit Shopping Cart");


                        int orderType = scan.nextInt();
                        if (orderType == 1){
                            System.out.println("Please enter the name of the Book you wish to order: ");
                            String nameBook = scan.next();
                            newCart.addtoBookOrder(nameBook);
                            // Updates Inventory as Customer Places Order, Removes Book from ArrayList
                            int remove = bookStoreInv.findBook(nameBook);
                            bookStoreInv.getBookArrayList().remove(remove);
                            // Updates Total Spent based on Book Order
                            double totalSpent = firstManager.getCustomerDataBase().get(customerIndex).getTotalSpent();
                            for (int i = 0; i < newCart.getBookOrder().size(); i++){
                                double amount = newCart.getBookOrder().get(i).getPrice();
                                totalSpent = totalSpent + amount;
                                firstManager.getCustomerDataBase().get(customerIndex).setTotalSpent(totalSpent);
                            }
                        }
                        else if (orderType == 2){
                            System.out.println("Please enter the name of the CD you wish to order: ");
                            String nameCD = scan.next();
                            newCart.addtoCDOrder(nameCD);
                            // Removes CD inventory as Customer Orders
                            int remove = bookStoreInv.findCD(nameCD);
                            bookStoreInv.getCdArrayList().remove(remove);
                            // Updates Total Spent after CD Order
                            double totalSpent = firstManager.getCustomerDataBase().get(customerIndex).getTotalSpent();
                            for (int i = 0; i < newCart.getCdOrder().size(); i++){
                                double amount = newCart.getCdOrder().get(i).getPrice();
                                totalSpent = totalSpent + amount;
                                firstManager.getCustomerDataBase().get(customerIndex).setTotalSpent(totalSpent);
                            }
                        }
                        else if (orderType == 3){
                            System.out.println("Please enter the name of the DVD you wish to order: ");
                            String nameDVD = scan.next();
                            newCart.addtoDVDOrder(nameDVD);
                            // Updates DVD Inventory as Customer orders
                            int remove = bookStoreInv.findDVD(nameDVD);
                            bookStoreInv.getDvdArrayList().remove(remove);
                            // Updates Total Spent after DVD Order
                            double totalSpent = firstManager.getCustomerDataBase().get(customerIndex).getTotalSpent();
                            for (int i = 0; i < newCart.getDvdOrder().size() - 1; i++){
                                double amount = newCart.getDvdOrder().get(i).getPrice();
                                totalSpent = totalSpent + amount;
                                firstManager.getCustomerDataBase().get(customerIndex).setTotalSpent(totalSpent);
                            }

                        }
                        else if (orderType == 4){
                            // Display Book, CD, and DVD shopping Carts
                            System.out.println("Your Current Shopping Cart: ");
                            // Books
                            double total = 0.0;
                            if (newCart.getBookOrder().size() >= 1) {
                                for (int i = 0; i < newCart.getBookOrder().size(); i++) {
                                    System.out.println(newCart.getBookOrder().get(i));
                                    total += newCart.getBookOrder().get(i).getPrice();
                                }
                            }
                            else{
                                System.out.println("You have no Books in your cart!");
                            }
                            System.out.println("***************************************************************");
                            // CDs
                            if (newCart.getCdOrder().size() >= 1) {
                                for (int i = 0; i < newCart.getCdOrder().size(); i++) {
                                    System.out.println(newCart.getCdOrder().get(i));
                                    total += newCart.getBookOrder().get(i).getPrice();
                                }
                            }
                            else{
                                System.out.println("You have no CDs in your cart!");
                            }
                            // DVDs
                            System.out.println("***************************************************************");
                            if (newCart.getDvdOrder().size() >= 1) {
                                for (int i = 0; i < newCart.getDvdOrder().size(); i++) {
                                    System.out.println(newCart.getDvdOrder().get(i));
                                    total += newCart.getDvdOrder().get(i).getPrice();
                                }
                            }
                            else{
                                System.out.println("You have no DVDs in your cart!");
                            }
                            System.out.println("***************************************************************");
                            System.out.println("Your total order cost is: " + (total + firstManager.getCustomerDataBase().get(customerIndex).applyDiscount()));

                        }
                        else if (orderType == 5){
                            cartControl += 1;
                        }
                    }
                    break;
                case 4:
                    int control = 0;
                    while (control == 0) {
                        System.out.println("Managers!!! Enter names of books to add/ remove with no spaces!!!!");
                        System.out.println("Manager Options: ");
                        System.out.println("\t 1. View Customers");
                        System.out.println("\t 2. Add Inventory");
                        System.out.println("\t 3. Remove Inventory");
                        System.out.println("\t 4. Import Items/ Customers From File");
                        System.out.println("\t 5. Exit Manager Menu");

                        int managerSelection = scan.nextInt();
                        if (managerSelection == 1) {
                            if (firstManager.getCustomerDataBase().size() >= 1) {
                                for (int i = 0; i < firstManager.getCustomerDataBase().size(); i++) {
                                    System.out.println(firstManager.getCustomerDataBase().get(i));
                                }
                            }
                            else{
                                System.out.println("You currently have no customers in the DataBase!");
                            }
                        } else if (managerSelection == 2) {
                            System.out.println("Enter the type of Inventory you would like to add: ");
                            System.out.println("\t 1. Books");
                            System.out.println("\t 2. DVDs");
                            System.out.println("\t 3. CDs");

                            int invenAdd = scan.nextInt();
                            if (invenAdd == 1) {
                                System.out.println("Enter the name of the book : ");
                                String extraBookName = scan.next();
                                System.out.println("Enter the quantity you will have in stock of the book : ");
                                int extraBookQuant = scan.nextInt();
                                System.out.println("Enter the price of the book : ");
                                double extraBookPrice = scan.nextDouble();

                                bookStoreInv.addBook(extraBookName, extraBookQuant, extraBookPrice);
                                break;

                            } else if (invenAdd == 2) {
                                System.out.println("Enter the name of the DVD : ");
                                String extraDvdName = scan.next();
                                System.out.println("Enter the quantity you will have in stock of the DVD : ");
                                int extraDvdQuant = scan.nextInt();
                                System.out.println("Enter the price of the DVD : ");
                                double extraDvdPrice = scan.nextDouble();

                                bookStoreInv.addDvd(extraDvdName, extraDvdQuant, extraDvdPrice);
                                break;

                            } else if (invenAdd == 3) {
                                System.out.println("Enter the name of the CD : ");
                                String extraCdName = scan.next();
                                System.out.println("Enter the quantity you will have in stock of the CD : ");
                                int extraCdQuant = scan.nextInt();
                                System.out.println("Enter the price of the CD : ");
                                double extraCdPrice = scan.nextDouble();

                                bookStoreInv.addCD(extraCdName, extraCdQuant, extraCdPrice);
                                break;

                            }
                        } else if (managerSelection == 3) {
                            System.out.println("Enter the type of Inventory you would like to Remove: ");
                            System.out.println("Please remember Inventory is removed as Customers order!!! ");
                            System.out.println("\t 1. Books");
                            System.out.println("\t 2. DVDs");
                            System.out.println("\t 3. CDs");

                            int invenRemove = scan.nextInt();
                            if (invenRemove == 1) {
                                System.out.println("Please enter the name of the book you would like to remove : ");
                                String bookRemove = scan.next();
                                System.out.println("Please enter the new quantity for the book you want to remove : ");
                                int bookRemoveQuant = scan.nextInt();

                                bookStoreInv.removeBookInventory(bookRemove, bookRemoveQuant);
                                break;

                            } else if (invenRemove == 2) {
                                System.out.println("Please enter the name of the DVD you would like to remove or reduce : ");
                                String dvdRemove = scan.next();
                                System.out.println("Please enter the new quantity for the DVD you want to remove : ");
                                int dvdRemoveQuant = scan.nextInt();

                                bookStoreInv.removeDVDInventory(dvdRemove, dvdRemoveQuant);
                                //bookStoreInv.getDvdArrayList().get(bookStoreInv.findDVD(dvdRemove)).setQuantity(dvdRemoveQuant);
                                break;

                            } else if (invenRemove == 3) {
                                System.out.println("Please enter the name of the CD you would like to remove or reduce : ");
                                String cdRemove = scan.next();
                                System.out.println("Please enter the new quantity for the CD you want to remove : ");
                                int cdRemoveQuant = scan.nextInt();

                                bookStoreInv.removeCdInventory(cdRemove, cdRemoveQuant);
                                break;
                            }
                        } else if (managerSelection == 4) {
                            System.out.println("Manager, would you like to add Items or Customers?");
                            System.out.println("\t 1. Items");
                            System.out.println("\t 2. Customers");
                            int choice = scan.nextInt();
                            if (choice == 1){
                                System.out.println("Enter the name of the file in the project folder(include .txt)");
                                System.out.println("\t File MUST BE IN PROJECT FOLDER!");
                                String scanFile = scan.next();
                                System.out.println("Please enter the line of the file that has an item you wish to import: ");
                                System.out.println("\t Please enter the line number minus 1(i.e. if line 1 is desired, enter 0.)");
                                int line = scan.nextInt();
                                try {
                                    Item importItem = InputFile.createItems(scanFile, line);
                                    if (importItem.typeOfItem().equals("Book Item")){
                                        bookStoreInv.addBook(importItem.getName(), importItem.getQuantity(), importItem.getPrice());
                                    }
                                    else if (importItem.typeOfItem().equals("CD Item")){
                                        bookStoreInv.addCD(importItem.getName(), importItem.getQuantity(), importItem.getPrice());
                                    }
                                    else if (importItem.typeOfItem().equals("DVD Item")){
                                        bookStoreInv.addDvd(importItem.getName(), importItem.getQuantity(), importItem.getPrice());
                                    }
                                } catch (FileNotFoundException | InputMismatchException e) {
                                    e.printStackTrace();
                                } catch (EmptyDataSetException | MissingParameterException e) {
                                    System.out.println(e.getMessage());
                                }

                            }
                            else if (choice == 2){
                                System.out.println("Enter the name of the file in the project folder(include .txt)");
                                System.out.println("\t File MUST BE IN PROJECT FOLDER!");
                                String scanFile = scan.next();
                                System.out.println("Please enter the line of the file that has a Customer you wish to import: ");
                                System.out.println("\t Please enter the line number minus 1(i.e. if line 1 is desired, enter 0.)");
                                int line = scan.nextInt();
                                try{
                                    Customer importCustomer = InputFile.createCustomer(scanFile, line);
                                    firstManager.addCustomer(importCustomer.getCustomername(), importCustomer.getPaymentMethod(), importCustomer.isPremiumMember(), importCustomer.getTotalSpent());
                                } catch (FileNotFoundException | InputMismatchException e){
                                    e.printStackTrace();
                                } catch (EmptyDataSetException | MissingParameterException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                        else if (managerSelection == 5){
                            control += 1;
                        }

                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    exit += 2;


            }

        }

    }
}
