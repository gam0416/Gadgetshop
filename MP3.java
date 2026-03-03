
/**
 * Write a description of class MP3 here.
 *
 * @author Gadaf Malik-Abbas
 * Student ID - 25000098
 */
public class MP3 extends Gadget
{
    // this is to store avialabe memory on the MP3 player
    private int availableMemory;

    /**
     * Constructor for objects of class MP3
     * it will accept 5 parameters and passes common value to the Gadget constructor
     * price - in £ (Pounds)
     * Weight - in g (Gram)
     * Size - in mm (milemeter)
     */
    public MP3(String model, double price, int weight, String size, int availableMemory)
    {
        // this will pass gadget details to the Gadget class contructor
        super(model, price,weight,size);
        this.availableMemory=availableMemory;
    }

    //get method to return avaialble memory
    public int getAvailableMemory()
    {
        return availableMemory;
    }
    //mothod to ebable user to download music to MP3 player
    public void downloadMusic(int downloadSize)
    {
        //check for available memory (Memory left)
        if (availableMemory >= downloadSize)
        {
            //reduce availabe momory after download completed
            availableMemory = availableMemory - downloadSize;
            //display downlaod confirmation and available memory
            System.out.println("Download completed.");
            System.out.println("Availble Memory: " + availableMemory +"MB");
        }

        if (downloadSize <=0)
        {   //error check (doownload size must be greater than zero)
            System.out.println("Please enter a download size greater than zero");
            return;
        }
        else
        {
            //display error message if their is insuffcient memory
            System.out.println("Insufficient memory to downlaod this music.");
            System.out.println("Add 2G SD card to increase memory");
            //Avaialble memory after inserting 2G SD card
            availableMemory = availableMemory +3048;
            System.out.println("SD Card successfully added");
            System.out.println("Availble Memory: " + availableMemory +"MB");
            //redownload music after 3G SD is added 
            if (availableMemory >= downloadSize)
            {
                availableMemory = availableMemory - downloadSize;
                System.out.println("Music successfully downloaded.");
                System.out.println("Availble Memory: " + availableMemory +"MB");
            }
        }
    }
    // This method to alow user to delete music on their MP3
    public void deleteMusic(int deleteSize)
    {
        //delete size must be greater than zero
        if (deleteSize <=0)
        {
            System.out.println("Enter a delete size greater than zero.");
            return;
        }
        //increase memory once delete is complated
        availableMemory=availableMemory+deleteSize;
        //delete confirmation and display current available memeory
        System.out.println("Music Successfully deleted.");
        System.out.println("Availble Memory: " + availableMemory +"MB");
    }

    //Method to display details of MP3 player
    public void display()
    {
        super.display();
        //display available memory
        System.out.println("Availble Memory: " + availableMemory +"MB");
    }
}
