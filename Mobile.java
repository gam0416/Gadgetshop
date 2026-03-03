
/**
 * Write a description of class Mobile here.
 *
 * @author (Gadaf Malik-Abbas)
 * Student ID - 25000098
 */
public class Mobile extends Gadget
{
    // this is to store the amount of munutes left (Calling credit)
    private int callingCredits;

    /**
     * Constructor for class mobile 
     * it will accept 5 parameters and passes 4 of the 5 to the Gadget constructor using super()
     * price - in £ (Pounds)
     * Weight - in g (Gram)
     * Size - in mm (milemeter)
     */
    public Mobile(String model, double price, int weight, String size, int callingCredits)
    {
        super(model,price,weight,size);
        this.callingCredits=callingCredits;

    }
    // this is get method to return calling credits
    public int getCallingCredits()
    {
        return callingCredits;
    }

    //this method enable user to load calling credit onto their mobile
    public void addCallingCredit(int credit)
    // error checking (only allow positive credit to be loaded on the mobile)
    {
        if (credit > 0)
        {
            callingCredits = callingCredits +credit;
        }
        else
        {
            System.out.println("Please load a positive amount of calling credit");   
        }
    }

    public void makeCall(String number, int duration)
    {
        //error checking, duration must be greater than Zero
        if (duration <=0)
        {
            System.out.println("Please enter a calling duration greater than zero");
            return;
        }
        if (callingCredits >= duration)
        {
            //display message showing phone number and dusration
            System.out.println("Calling number: " + number + " for " + duration +"munites.");

            //error checing if the credit minutes is greater than duration then make a call, if not tell the user that thier is inssuficient credit
            callingCredits = callingCredits-duration;

            // display remaining credit (Credit balance) after each call
            System.out.println("Remaning Calling Credit (mins): " + callingCredits);
        }

        else 
        //display message if user have insufficient credit
        { 
            System.out.println("Insufficient calling credit to initiate this call. please load more credit.");
            System.out.println("Current Calling Credit (mins): " + callingCredits);
        }
    }
    //methos to display all the mobile detail
    public void display()
    {
        //display the gadget detail first
        super.display();
        //display calling calling credit balance
        System.out.println("CallingCredits" + callingCredits);
    }
}
