/**
 * Customer Class for Product Management System(Project 1)
 * Details of Customer
 * ITSC 1213 Spring 22
 *
 * @author Jacob Smith
 * @version Spring 22
 */

public class Customer implements Discount{
    private String customername;
    private int paymentMethod;
    private boolean premiumMember;
    private double totalSpent;


    /**
     *
     * @return Returns Customers name
     */
    public String getCustomername() {
        return customername;
    }

    /**
     *
     * @param customername A new customer name, for updating names
     */
    public void setCustomername(String customername) {
        this.customername = customername;
    }

    /**
     *
     * @return Returns current payment method on file
     */
    public int getPaymentMethod() {
        return paymentMethod;
    }

    /**
     *
     * @param paymentMethod Updates paymentMethod
     */
    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     *
     * @return True if a memeber is a premium member, false if not
     */
    public boolean isPremiumMember() {
        return premiumMember;
    }

    /**
     *
     * @param premiumMember Used for updating a customers status if they choose to be a member
     */
    public void setPremiumMember(boolean premiumMember) {
        this.premiumMember = premiumMember;
    }

    /**
     *
     * @return Returns total amount spent by customer
     */
    public double getTotalSpent() {
        return totalSpent;
    }

    /**
     *
     * @param totalSpent New amount to add to customers account based on membership purchase or order.
     */
    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }

    @Override
    public double applyDiscount() {
        if (premiumMember) {
            double discount = getTotalSpent() * .10;
            return getTotalSpent() - discount;
        }
        else{
            return getTotalSpent();
        }

    }

    /**
     *
     * @param newName Customers name
     * @param payMethod Customers payment method
     * @param premMem Is customer a premium member
     * @param amountSpent Current amount spent by Customer
     */
    public Customer(String newName, int payMethod, boolean premMem, double amountSpent) {
        this.customername = newName;
        this.paymentMethod = payMethod;
        this.premiumMember = premMem;
        this.totalSpent = amountSpent;

    }

    @Override
    public String toString() {
        return "Customer{" +
                "customername='" + customername + '\'' +
                ", paymentMethod=" + paymentMethod +
                ", premiumMember=" + premiumMember +
                ", totalSpent=" + totalSpent +
                '}';
    }
}
