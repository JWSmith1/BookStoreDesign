import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CDTest {

    CD testCD = new CD("Example", 3, 4.99);

    @Test
    void testTypeOfItem() {
        System.out.println("Should output : CD Item");
        System.out.println(testCD.typeOfItem());
    }

    @Test
    void testToString() {
        System.out.println("Should output:  Type of item ---> Title: Quantity: Price: ");
        System.out.println(testCD.toString());
    }
}