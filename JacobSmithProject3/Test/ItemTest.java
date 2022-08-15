import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest{
    // Item class is abstract, can't generate Item object, using Book object for Item class test
    Item testItem = new Book("Item", 1, 4.99);

    @Test
    void testGetName() {
        System.out.println("Output should be: Item");
        System.out.println(testItem.getName());
    }

    @Test
    void testSetName() {
        testItem.setName("NewName");
        System.out.println("Output should be: NewName");
        System.out.println(testItem.getName());

    }

    @Test
    void testGetQuantity() {
        System.out.println("Output should be: 1");
        System.out.println(testItem.getQuantity());

    }

    @Test
    void testSetQuantity() {
        testItem.setQuantity(4);
        System.out.println("Output should be: 4");
        System.out.println(testItem.getQuantity());
    }

    @Test
    void testGetPrice() {
        System.out.println("Output should be: 4.99");
        System.out.println(testItem.getPrice());
    }

    @Test
    void testSetPrice() {
        testItem.setPrice(10.99);
        System.out.println("Output should be: 10.99");
        System.out.println(testItem.getPrice());
    }


}