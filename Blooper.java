import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Blooper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blooper extends blueShell
{
    /**
     * Act - do whatever the Blooper wants to do. This method is called whenever
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
        if (Greenfoot.getRandomNumber(1000) < 1 && this.getY()>=110)
        {
            getWorld().addObject(bullet,getX(),getY()+5);
        }
        else if (this.getY()>=190)
        {
            if(Greenfoot.getRandomNumber(80) < 1)
            {
                getWorld().addObject(bullet,getX(),getY()+5);
            }
        }
    }
}
