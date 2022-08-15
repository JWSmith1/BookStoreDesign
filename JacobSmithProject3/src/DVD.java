
/**
 * DVD Class for Product Management System(Project 1)
 * ITSC 1213 Spring 22
 *
 * @author Jacob Smith
 * @version Spring 22
 */

public class DVD extends Item{
    /**
     *
     * @param dvdName String name of new DVD
     * @param dvdQuant Quantity of new DVD in stock
     * @param dvdPrice Price of new DVD
     */
    public DVD(String dvdName, int dvdQuant, double dvdPrice){
        super(dvdName,dvdQuant,dvdPrice);
    }

    @Override
    public String typeOfItem() {
        return "DVD Item";
    }

    @Override
    public String toString(){
        return typeOfItem() + " ---> Title: " + getName() + " Quantity: " + getQuantity() + " Price: " + getPrice();
    }



}
