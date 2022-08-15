import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest{

    ShoppingCart testCart = new ShoppingCart();

    @Test
    void getDvdOrder() {
        testCart.addtoDVDOrder("Deadpool");
        System.out.println("Output should display DVD order with Deadpool");
        System.out.println(testCart.getDvdOrder());
    }

    @Test
    void getCdOrder() {
        testCart.addtoCDOrder("Bad");
        System.out.println("Output should display CD order with Bad");
        System.out.println(testCart.getCdOrder());
    }

    @Test
    void getBookOrder() {
        testCart.addtoBookOrder("WarAndPeace");
        System.out.println("Output should display Book order with WarAndPeace");
        System.out.println(testCart.getBookOrder());
    }

    @Test
    void getCustomerName() {
        // Output will be null, Customer name for shopping cart is created when customers place an order
        System.out.println(testCart.getCustomerName());
    }

    @Test
    void setCustomerName() {
        testCart.setCustomerName("John");
        System.out.println("Output : John");
        System.out.println(testCart.getCustomerName());

    }

    @Test
    void getDate() {
        // Will return null, until date is set
        System.out.println(testCart.getDate());
    }

    @Test
    void setDate() {
        testCart.setDate("03-31-2022");
        System.out.println("Output : 03-31-2022");
        System.out.println(testCart.getDate());

    }

    @Test
    void addtoCDOrder() {
        testCart.addtoCDOrder("BackInBlack");
        System.out.println("Output should display CD order with BackInBlack");
        System.out.println(testCart.getCdOrder());
    }

    @Test
    void addtoDVDOrder() {
        testCart.addtoDVDOrder("Moana");
        System.out.println("Output should display DVD order with Moana");
        System.out.println(testCart.getDvdOrder());
    }

    @Test
    void addtoBookOrder() {
        testCart.addtoBookOrder("MacBeth");
        System.out.println("Output should display Book order with MacBeth");
        System.out.println(testCart.getBookOrder());
    }
}