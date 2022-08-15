import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreManagerTest {

    StoreManager testManager = new StoreManager();

    @Test
    void getCustomerDataBase() {
        testManager.addCustomer("Example", 12345678, false, 0.00);
        System.out.println("Output should show example customer...");
        System.out.println(testManager.getCustomerDataBase());
    }

    @Test
    void getManagerName() {
        System.out.println("Output will be null until set");
        System.out.println(testManager.getManagerName());

    }

    @Test
    void setManagerName() {
        testManager.setManagerName("Jacob");
        System.out.println("Output will now be Jacob for Manager name....");
        System.out.println(testManager.getManagerName());

    }

    @Test
    void findCustomer() {
        // Create Three Customers for example database and search for them
        testManager.addCustomer("Jack", 12345678, true, 10.99);
        testManager.addCustomer("Tyler", 12345678, true, 10.99);
        testManager.addCustomer("Zack", 12345678, true, 10.99);
        System.out.println(testManager.findCustomer("Jack"));
        System.out.println(testManager.findCustomer("Zack"));
        System.out.println(testManager.findCustomer("Tyler"));
        System.out.println("Output should be 0, 2, 1");

    }

    @Test
    void addCustomer() {
        testManager.addCustomer("Bob", 12345678, true, 10.99);
        System.out.println("Output should display customer Bob who has been added to the database...");
        System.out.println(testManager.getCustomerDataBase());
    }

    @Test
    void testToString() {
        // Manager name will be null, and Customer database will be an empty arrayList
        System.out.println(testManager.toString());
    }
}