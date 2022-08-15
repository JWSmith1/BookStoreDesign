import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest{

    // Test Customer, starts with 10.99 since Premium member
    Customer testCustomer = new Customer("John", 23243678, true, 10.99);

    @Test
    void getCustomername() {
        System.out.println("Output should be: John");
        System.out.println(testCustomer.getCustomername());
    }

    @Test
    void setCustomername() {
        String updatedName = "Johny";
        testCustomer.setCustomername(updatedName);
        System.out.println("Output should be: Johny");
        System.out.println(testCustomer.getCustomername());
    }

    @Test
    void getPaymentMethod() {
        System.out.println("Output should be: 23243678");
        System.out.println(testCustomer.getPaymentMethod());
    }

    @Test
    void setPaymentMethod() {
        // New 8 digit card number
        int updateCard = 12345678;
        testCustomer.setPaymentMethod(updateCard);
        System.out.println("Output should be: 12345678");
        System.out.println(testCustomer.getPaymentMethod());
    }

    @Test
    void isPremiumMember() {
        System.out.println("Output should be: true");
        System.out.println(testCustomer.isPremiumMember());
    }

    @Test
    void setPremiumMember() {
        // Test change of memebership
        boolean memberStatus = false;
        testCustomer.setPremiumMember(memberStatus);
        System.out.println("Output should be: false");
        System.out.println(testCustomer.isPremiumMember());
    }

    @Test
    void getTotalSpent() {
        System.out.println("Output should be: 10.99");
        System.out.println(testCustomer.getTotalSpent());
    }

    @Test
    void setTotalSpent() {
        testCustomer.setTotalSpent(25.99);
        System.out.println("Output should be: 25.99");
        System.out.println(testCustomer.getTotalSpent());

    }

    @Test
    void applyDiscount() {
        System.out.println("Since our test customer is a premium member output should be 10.99 with a 10% discount");
        System.out.println(testCustomer.applyDiscount());
    }

    @Test
    void testToString() {
        System.out.println("Should output customer details...");
        System.out.println(testCustomer.toString());
    }
}