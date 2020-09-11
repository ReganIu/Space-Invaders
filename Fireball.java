
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Actor
{
    monsterExplosion explosion = new monsterExplosion();
    /**
     * Act - do whatever the Fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        hitObject();
    }  

    /*
     * Moves the fireball upwards until it hits a monster
     * or until it reaches the end of the world.
     */
    public void move()
    {
        int y = getY()-5;
        if (y > 0) 
        {
            setLocation(getX(), y);
        }
    }

    /*
     * Checks to see if the fireball has hit the edge
     * of the world or not. Returns null if it has not
     * reached the edge.
     */
    public String topEdge()
    {
        if (getY() == 5)
        {
            getWorld().addObject(explosion,getX(),getY());
            getWorld().removeObject(this); 
        }
        return null; //null means the fireball is not at the edge.
    }

    /*
     * If Mario's fireball hits this the Blue Shell, then it
     * will explode and then both the fireball and
     * blue shell will disappear.
     */
    public void hitObject()
    {
        Actor blueShell = getOneIntersectingObject(blueShell.class);//returns an object that intersects the fireball 
        Actor Blooper = getOneIntersectingObject(Blooper.class);
        Actor Mushroom = getOneIntersectingObject(Mushroom.class);
        Actor Lakitu = getOneIntersectingObject(Lakitu.class);

        Background background = (Background) getWorld(); //gets a reference to the world
        Background bg = (Background) getWorld();
        
        Counter counter = background.getCounter(); //reference to the Counter class.

        //The code below will give us null if this object isn't touching the fireball
        //so if it does does not equal to null then run the code below.
        if(blueShell!=null)
        {
            getWorld().addObject(explosion, blueShell.getX(), blueShell.getY());
            getWorld().removeObject(blueShell);
            counter.bumpScore(5);
            bg.numOfEnemies--; //subtracts 1 from int variable numOfEnemies
            getWorld().removeObject(this);
        }
        else if (Blooper!=null)
        {
            getWorld().addObject(explosion, Blooper.getX(),Blooper.getY());
            getWorld().removeObject(Blooper);
            counter.bumpScore(5);
            bg.numOfEnemies--; //subtracts 1 from int variable numOfEnemies
            getWorld().removeObject(this);
        }
        else if (Mushroom!=null)
        {
            getWorld().addObject(explosion, Mushroom.getX(),Mushroom.getY());
            getWorld().removeObject(Mushroom);
            counter.bumpScore(5);
            bg.numOfEnemies--; //subtracts 1 from int variable numOfEnemies
            getWorld().removeObject(this);
        }
        else if (Lakitu!=null)
        {
            getWorld().addObject(explosion, Lakitu.getX(),Lakitu.getY());
            getWorld().removeObject(Lakitu);
            counter.bumpScore(50);
            getWorld().removeObject(this); 
        }
        else if (topEdge()!=null)//if the fireball is touching the edge, then run topEdge() method.
        {
            topEdge();
        }
    }

}
