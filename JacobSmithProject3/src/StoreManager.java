import java.util.ArrayList;

/**
 * StoreManager Class for Product Management System(Project 1)
 *
 * Track Customers(Payment, Memberships/ Fees Due, Amount Spent)
 * Manages Inventory
 * ITSC 1213 Spring 22
 *
 * @author Jacob Smith
 * @version Spring 22
 */

public class StoreManager {
    private ArrayList<Customer> customerDataBase = new ArrayList<>();
    private String managerName;

    /**
     *
     * @return Returns list of customer data detailing all current customers
     */
    public ArrayList<Customer> getCustomerDataBase() {
        return customerDataBase;
    }

    /**
     *
     * @return Returns managers name
     */
    public String getManagerName() {
        return managerName;
    }

    public StoreManager(){
        ArrayList<Customer> updateCustomers = customerDataBase;
    }

    /**
     *
     * @param managerName Inputs String to set a manager
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    /**
     *
     * @param name Name of Customer to find in database
     * @return Returns the index of that customer in datebase
     */
    public int findCustomer(String name){
        for (int i = 0; i < customerDataBase.size(); i++){
            if (customerDataBase.get(i).getCustomername().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }

    public void addCustomer(String name, int pay, boolean premium, double spentMoney){
        Customer cust = new Customer(name, pay, premium, spentMoney);
        customerDataBase.add(cust);
    }

    @Override
    public String toString() {
        return "StoreManager{" + "Manager Name = " + managerName +
                "customerDataBase=" + customerDataBase +
                '}';
    }
}
