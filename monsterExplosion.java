import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MonsterExplosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class monsterExplosion extends Actor
{
    private GreenfootImage img1 = new GreenfootImage ("monsterexplosion.gif"); //1st animation
    private GreenfootImage img2 = new GreenfootImage ("monsterexplosion2.gif"); //2nd animation
    private int timer = 1;
    /**
     * Act - do whatever the MonsterExplosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animateExplosion();
    }   

    /*
     * This is the animation for the explosion.
     */
    public void animateExplosion()
    {
        if (timer == 10) 
        {
            setImage(img1);
        } 
        else if (timer == 12)
        {
            setImage(img2);
        }
        else if (timer == 15)
        {
            getWorld().removeObject(this);
        }
        timer++;
    }
}
