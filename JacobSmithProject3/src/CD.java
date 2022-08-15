
/**
 * CD Class for Product Management System(Project 1)
 * ITSC 1213 Spring 22
 *
 * @author Jacob Smith
 * @version Spring 22
 */

public class CD extends Item{

    /**
     *
     * @param cdName Name for CD to add to inventory
     * @param cdQuant Quantity of CD
     * @param cdPrice Price of CD
     */
    public CD(String cdName, int cdQuant, double cdPrice){
        super(cdName, cdQuant, cdPrice);

    }

    @Override
    public String typeOfItem() {
        return "CD Item";
    }

    @Override
    public String toString(){
        return typeOfItem() + " ---> Title: " + getName() + " Quantity: " + getQuantity() + " Price: " + getPrice();
    }

}
