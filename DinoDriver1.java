 


  
/**
 * Write a description of class DinoDriver1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver1
{  
    public static void main(String[] args)
    {
    //    Dinosaur d1 = new Dinosaur();
       // Dinosaur d2 = new Dinosaur("TRex");
        
        Dinosaur[] pop = new Dinosaur [5];
        
        //age up all of the dinos to a random age between 0 and 35
        
        int rand;
        for (int i = 0; i < pop.length; i++)
        {
            rand = (int) (35*Math.random());
            for (int c = 0; c<rand; c++)
            {
                pop[i].ageUp();
            }
        }
        
        for (int i = 0; i< pop.length; i++)
        {
            System.out.println(pop[i]);
        }
    }
}