import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest{

    Book testBook = new Book("Example", 1, 2.99);

    @Test
    void testTypeOfItem() {
        System.out.println("Should output : Book Item");
        System.out.println(testBook.typeOfItem());
    }

    @Test
    void testToString() {
        System.out.println("Should output:  Type of item ---> Title: Quantity: Price: ");
        System.out.println(testBook.toString());


    }
}