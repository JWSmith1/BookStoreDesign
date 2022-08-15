import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DVDTest {

    DVD testDVD = new DVD("Example", 2, 7.99);

    @Test
    void typeOfItem() {
        System.out.println("Should output : DVD Item");
        System.out.println(testDVD.typeOfItem());
    }

    @Test
    void testToString() {
        System.out.println("Should output:  Type of item ---> Title: Quantity: Price: ");
        System.out.println(testDVD.toString());
    }
}