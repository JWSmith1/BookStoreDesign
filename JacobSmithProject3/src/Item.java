public abstract class Item{

    // Fields for Item Class
    private String name;
    private int quantity;
    private double price;

    /**
     *
     * @return Name of Item
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Set name of given Item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return Quantity of item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity Sets new quantity of Item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return Returns price of item
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price Sets new price of item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String typeOfItem();

    /**
     *
     * @param name Title of Item
     * @param quantity Quantity of Item
     * @param price Price of Item
     */
    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }




}
