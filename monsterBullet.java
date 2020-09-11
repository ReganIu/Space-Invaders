import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class invaderBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class monsterBullet extends Fireball
{
    monsterExplosion explosion = new monsterExplosion();
    /**
     * Act - do whatever the invaderBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        hitMario();
    }    

    /*
     * Moves the monster bullet downwards until it hits Mario
     * or until it reaches the end of the world.
     */
    public void move()
    {
        int y = getY()+3;
        if (y > 0) 
        {
            setLocation(getX(), y);
        }
    }

    /*
     * Checks to see if the monster's bullet has 
     * reached the bottom of the screen. If it has,
     * it removes it and adds an explosion animation.
     */
    public String bottomEdge()
    {
        if (getY()>=595)
        {
            getWorld().addObject(explosion,getX(),getY());
            getWorld().removeObject(this);
        }
        return null;
    }
    
    /*
     * This method will check to see if the monster bullet hits Mario or not,
     * if it does it Mario, he and the monster bullet will be removed
     * then the "GAME OVER" text will appear.
     */
    public void hitMario()
    {
        Actor Mario = getOneIntersectingObject(Mario.class);
        Background background = (Background) getWorld(); //gets a reference to the world
        Background bg = (Background) getWorld();
        
        if (Mario!=null)
        {
            bg.marioLife--;
            getWorld().addObject(explosion,Mario.getX(),Mario.getY());
            getWorld().removeObject(Mario);      
            getWorld().removeObject(this); //Removes the monster's bullet.
        } 
        else if(bottomEdge()!=null)
        {
            bottomEdge();
        }
    }
}
