
/**
 * Write a description of class Dinosaur here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Dinosaur
{
    // instance variables - replace the example below with your own
    private String type;
    private int age;
    private String gender;
    private int health; // a range between 0 and 100
    private int wins;
    private int battleCount;
    private static int population;

    /**
     * Default Constructor for objects of class Dinosaur
     */
    public Dinosaur()
    {
        // initialise instance variables
        type = "Dino";
        age = 0;
        wins = 0;
        battleCount = 0;
        this.health = 10;
    }

    /**
     * Explicit constructor for the Dino class
     */

    public Dinosaur (String t)
    {
        this.type = t;
        this.age = 0;
        this.health = 10;
        if (Math.random() > 0.5)
        {
            gender = "M";
        }
        else
        {
            gender = "F";
        }
        this.wins = 0;
        this.battleCount = 0;
    //    Dinosaur.population=25;
    }

    /******** Getters **************/
    // Getters return the private instance data
    public String getType()
    {
        return this.type;
    }

    public String getGender()
    {
        return this.gender;
    }

    public int getHealth()
    {
        return this.health;
    }

    public int getAge()
    {
        return this.age;
    }
    
    public static int getPopulation()
    {
        return DinoDriver2.dinoPop.size();
    }
    
    public int getWins()
    {
        return this.wins;
    }

    public int getbattleCount()
    {
        return this.battleCount;
    }

    //

    /******* Setters *************/

    public void setType(String t)
    {
        this.type = t;
    }

    public static void setPopulation(int p)
    {
        Dinosaur.population = p;
    }
    
    public void setHealth(int h)
    {
        this.health = h;
    }

    public void setAge(int a)
    {
        this.age = a;
    }
    //make setter for gender
    public void setGender(String g)
    {
        this.gender = g;
    }

    public void setWins(int w)
    {
        this.wins = w;
    }

    public void setbattleCount(int b)
    {
        this.battleCount = b;
    }

    public double battleFactor(Dinosaur other)
    {
        double healthperc = (double) other.getHealth() * 0.0067;
        double exp;
        if (this.getbattleCount()+other.getbattleCount()>0)
        {
            exp = (double) this.getbattleCount()/(this.getbattleCount() + other.getbattleCount());
        }
        else
            exp = 0;
        return healthperc + 0.33*exp;
    }

    public boolean equals(Dinosaur d)
    {
        //write code that will return true if two dinos are "equal"
        //return true if they're equal, false otherwise
        if (d.type.equals(this.type) && d.age==this.age)
        {
            if (d.getHealth()==this.health)
                return true;
        }
        return false;
    }

    public void ageUp()
    {
        if(this.health > 0)
        {
            this.age++;
            if (this.age < 10)
            {
                this.health+=10;
            }
            else if (25<=this.age && this.age<=30)
            {
                this.health-=5;//check if health is negative or 0
                // if so, increment population
                if (this.health<=0)
                    {
                        DinoDriver2.dinoPop.remove(this);
                    }
            }
            else if (this.age>30)
            {
                this.health-=10;
                if (this.health<=0)
                    {
                        DinoDriver2.dinoPop.remove(this);
                    }
            }
        }   

    }

    public void update(Dinosaur loser)
    {
        // reduce health of the losing dino
        // can decide what to do with health of winning dino
        // increase the wins for "this" dino
        // increase battleCount for both
        this.setHealth(this.getHealth() - 2);
        loser.setHealth(loser.getHealth() - 20);
        this.setWins(this.getWins() + 1);
        this.setbattleCount(this.getbattleCount() + 1);
        loser.setbattleCount(loser.getbattleCount() + 1);
        if (loser.getHealth() <= 0)
            {
                System.out.println("\t" + loser);
                DinoDriver2.dinoPop.remove(loser);
            }
            //change population
    }

    public abstract boolean attack(Dinosaur other);

    //Return this Dino as a string
    public String toString()
    {
        String answer = this.type + " " + this.age + " " + this.health + " " + this.gender + " " + this.wins + " " + this.battleCount;
        return answer;
    }
}
