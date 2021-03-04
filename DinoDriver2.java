import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class DinoDriver2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver2
{
    public static  List <Dinosaur> dinoPop = new ArrayList<Dinosaur>();  
    
    private static void growUp(Dinosaur d) // d=t1, they are aliases
    {
        int rand = (int)(35*Math.random());
        //d.setbattleCount(rand);
        for (int c = 0; c<rand; c++)
        {
            d.ageUp();
        }
    }

    public static void main(String[] args)
    {

        //Dinosaur[] pop = new Dinosaur [25];
        
        // create an arraylist of dinos called dinoPop
        //double rand1;
        
       for (int i = 0; i< 30; i++)
        {
            double rand = Math.random();
            Dinosaur d = new TRex();
            if (rand < 0.33) // make a TRex
            {
                Dinosaur t = new TRex();
                dinoPop.add(d);
                DinoDriver2.growUp(d);
            }
            else if (rand < 0.67) // make a Brontasaurus
            {
                Dinosaur b = new Brontosaurus(); // use .add(int index, Dinosaur dino) for adding
                // at a specific location
                dinoPop.add(b);
                DinoDriver2.growUp(b);
            }
            else // make a Pterodactyl
            {
                Dinosaur p = new Pterodactyl();
                dinoPop.add(p);
                DinoDriver2.growUp(p);
            }
        }
        
        /*
        Dinosaur.setPopulation(pop.length);
        for(int i = 0; i < pop.length; i++)
        {
            rand1  = Math.random();
            if (rand1<0.33)
                pop[i] = new TRex();
            else if (rand1<0.67)
                pop[i] = new Pterodactyl();
            else
                pop[i] = new Brontosaurus();
            DinoDriver2.growUp(pop[i]);
        }
        */
        int i = 0;
        while(dinoPop.size()>2)
        {
            // keep loop going until there are only two dinos left - find algorithm
            System.out.println("##### Round " + (i+1)+ "#####");
            i++;
            DinoDriver2.battleRound((ArrayList) dinoPop);
        }

        //for (int i =0; i<pop.length; i++)
       // for ( Dinosaur d : dinoPop ) // d gets assigned to pop[i]
       // {
         //       if (d.getHealth() <=0)
           //     {
             //       System.out.println("\t" + d);
               //     dinoPop.remove(d);
              //  }
       // }
    }
    

    private static void battleRound(ArrayList<Dinosaur> p )
    {
        /*
        // Modify this code to call the update method with the correct
        // dinosaurs winning and losing
         */
        // Traverse the array, and have all dino battle one other dino
        // Write code that will prevent a dead dino from attacking
        for (Dinosaur d : p)
        {
            System.out.println(d);
        }
        int attWins = 0;
        int battles = 0;
        for ( Dinosaur d : p )
        {
            int rand = (int)(Math.random()* p.size());

            if (d.getHealth() > 0 && p.get(rand).getHealth()>0)
            {
                while (p.get(rand).getHealth()<=0 || d==p.get(rand))
                    rand = (int)(Math.random()* p.size());

                //modify attack such that you don't attack your self
                // and you don't attack a dead dinosaur
                if (d.attack(p.get(rand)))
                {
                    attWins++;
                    battles++;
                    d.update(p.get(rand));
                }
                else
                {
                    p.get(rand).update(d);
                    battles++;
                }
            }//A given battle is over
        }// round is over
        System.out.println("**** Total battles: " + battles + " & attacker wins "+ attWins);

        System.out.println("\t" + p.get(0));
        System.out.println("\t" + p.get(1));
        
    }

    
}
