import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lakitu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lakitu extends Actor
{
    private int timer = 0;
    /**
     * Act - do whatever the Lakitu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        remove();
    }

    /*
     * This moves Lakitu across the screen.
     */
    public void move()
    {
        if (getY() >= 0 )
        {
            move(1);
        }
    }

    /*
     * This removes Lakitu when he reaches the end of the world.
     */
    public void remove()
    {
        int x = getX();
        if (x >= 395)
        {
            getWorld().removeObject(this);
        }
    }
}
