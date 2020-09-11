import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barrier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrier extends Actor
{
    private int life = 4;
    private GreenfootImage img1 = new GreenfootImage ("barrier1.gif");
    private GreenfootImage img2 = new GreenfootImage ("barrier2.gif");
    private GreenfootImage img3 = new GreenfootImage ("barrier3.gif");
    private GreenfootImage img4 = new GreenfootImage ("barrier4.gif");
    /**
     * Act - do whatever the Barrier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getsHit();
    }    
    
    /*
     * If the barrier gets hit by either Mario's fireballs,
     * or by the monster's bullets.
     */
    public void getsHit()
    {
        Actor fb = getOneIntersectingObject(Fireball.class);
        Actor mb = getOneIntersectingObject(monsterBullet.class);

        if(fb!=null)
        {
            life--;
            getWorld().addObject(fb, fb.getX(), fb.getY());
            getWorld().removeObject(fb);
            if (life == 4)
            {
                setImage(img1);
            }
            else if (life == 3)
            {
                setImage (img2);
            }
            else if (life == 2)
            {
                setImage (img3);
            }
            else if (life == 1)
            {
                setImage (img4);
            }
            else if (life ==0)
            {
                getWorld().removeObject(this);
            }
        }
        else if (mb!=null)
        {
            life--;
            getWorld().addObject(mb, mb.getX(),mb.getY());
            getWorld().removeObject(mb);  
            if (life == 4)
            {
                setImage(img1);
            }
            else if (life == 3)
            {
                setImage (img2);
            }
            else if (life == 2)
            {
                setImage (img3);
            }
            else if (life == 1)
            {
                setImage (img4);
            }
            else if (life ==0)
            {
                getWorld().removeObject(this);
            }
        }
    }
}
