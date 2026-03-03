
/**
 * Write a description of class GadgetShop here.
 *
 * @author (Gadaf Malik-Abbas)
 * Student ID - 25000098
 */
public class Gadget
{
    private String model;
    private double price;
    private int weight;
    private String size;
    
    
    public Gadget(String model, double price, int weight, String size)
    {
      // assignment of user pass model to class varaible method
      
      /**
       * Constructor for Class Gadget
       * class variable will be assigned based on the values recieved by user 
       * price - in £ (Pounds)
       * Weight - in g (Gram)
       * Size - in mm (milemeter)
       */
      this.model=model; 
      this.price=price;
      this.weight=weight;
      this.size=size;
    }
    //this is a get method to return the model
    public String getModel()
    {
        return model;
    }
    
    public int getWeight()
    {
        return weight;
    }
    
    public String getSize()
    {
        return size;
    }
    // more get methods
    public void display()
    {
     System.out.println("Model " + model);  
     System.out.println("Price £: "+ price);
     System.out.println("Weight "+ weight + "g");
     System.out.println("Size " + size);
    }
}
