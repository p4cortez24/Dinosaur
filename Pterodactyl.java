
/**
 * Write a description of class Pterodactyl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pterodactyl extends Dinosaur
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Pterodactyl
     */
    public Pterodactyl()
    {
        // initialise instance variables
        super("Pterodactyl");
        x = 0;
    }
    
    
    public boolean attack(Dinosaur other)
    {
        // Code this method such that if other is a TRex, this wins
        // 50%. If other is a Ptero, this wins 60%, if a bronto, this wins
        // 75%
        boolean result = false;
        if (other.getType().equals("Pterodactyl")&& other.getHealth()!=0 && this.equals(other) == false)
        {
            if (Math.random() > 0.5)
                result = true;
        }
        else if (other.getType().equals("Brontosaurus")&& other.getHealth()!=0 && this.equals(other) == false)
        {
            if (Math.random() > 0.4)
                result = true;
        }
        else if (other.getType().equals("TRex")&& other.getHealth()!=0 && this.equals(other) == false)
        {
            if (Math.random() > 0.25)
                result = true;
        }
        return result;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
        // put your code here
        if (this.getAge() == 0)
        {
            return super.toString(); // super. calls the method of the parent class
        }
        else
            return this.getType() + " " + this.getAge() + " "+ this.getHealth() +" " + this.getGender() + " " + this.getbattleCount();
    }
}
