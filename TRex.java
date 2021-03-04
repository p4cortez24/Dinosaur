
/**
 * Write a description of class TRex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TRex extends Dinosaur
{
    // instance variables - replace the example below with your own
    private int numEaten; // specific to the TRex class and not Dinosaur

    /**
     * Constructor for objects of class TRex
     */
    public TRex()
    {
        // super() --> Must be the first line of a constructor
        super("TRex"); //Calls the explicit constructor of the parent class

        this.numEaten = 0;

    }

    public boolean attack(Dinosaur other)
    {
        // Code this method such that if other is a TRex, this wins
        // 50%. If other is a Ptero, this wins 60%, if a bronto, this wins
        // 75%
        boolean result = false;
        if (other.getType().equals("Trex")&& other.getHealth()!=0 && this != other)
        {
            if (this.battleFactor(this)*(50+(int)(Math.random()*51)) > other.battleFactor(other)*(50+(int)(Math.random()*51)))
                result = true;
        }
        else if (other.getType().equals("Pterodactyl") && other.getHealth()!=0 && this!=other)
        {
            if (this.battleFactor(this)*(50+(int)(Math.random()*51)) > other.battleFactor(other)*(35+(int)(Math.random()*51)))
                result = true;
        }
        else if (other.getType().equals("Brontosaurus") && other.getHealth()!=0 && this !=other)
        {
            if (this.battleFactor(this)*(40+(int)(Math.random()*61)) > other.battleFactor(other)*(35+(int)(Math.random()*41)))
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
            return this.getType() + " " + this.getAge() + " " + this.getHealth() + " " + this.getGender() + " " + this.getWins() + " " + this.getbattleCount();
    }
}
