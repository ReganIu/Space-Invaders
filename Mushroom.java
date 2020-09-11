import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mushroom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mushroom extends blueShell
{
    /**
     * Act - do whatever the Mushroom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        shoot();
        checkBorder();
    }  
    
    public void shoot()
    {
        monsterBullet bullet = new monsterBullet();
        if (Greenfoot.getRandomNumber(1000) < 1 && this.getY()>=60)
        {
            getWorld().addObject(bullet,getX(),getY()+5);
        }
        else if (this.getY()>=180)
        {
            if(Greenfoot.getRandomNumber(80) < 1)
            {
                getWorld().addObject(bullet,getX(),getY()+5);
            }
        }
    }
}
