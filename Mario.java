import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mario extends Actor
{
    //This variable delays each shot.
    private int shotTimer = 0;
    private int speedTimer = 0;
    public static int speed = 4;
    /**
     * Act - do whatever the Mario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        shoot();
        touchSpeedPowerUp();
    }   

    /*
     * Moves Mario left and/or right.
     */
    public void move()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            move(-speed);
        }
        if (Greenfoot.isKeyDown("right"))
        {
            move(speed);
        }
    }

    /*
     * If Mario touches the Speed power up, then
     * his speed is increased for a duration of time.
     */
    public void touchSpeedPowerUp()
    {
        SpeedPowerUp powerUp = (SpeedPowerUp)getOneIntersectingObject(SpeedPowerUp.class);
        if (powerUp != null)
        {
            speed = 8; //increases his speed.
            speedTimer = 80; //declares the amount of time that Mario will have increased speed.
            getWorld().removeObject(powerUp);
            Greenfoot.playSound("speedboost.wav");  
        }
        //The code belows sets a timer for the speed power up for Mario.
        if (speedTimer > 0)
        {
            speedTimer--;
            if (speedTimer == 0) //one the timer is at 0, set Mario's speed back to original.
            {
                speed = 4;
            }
        }
    }

    /*
     *This allows Mario to fire a fireball, with a delay 
     *in between each shot.
     */
    public void shoot()
    {
        if (shotTimer > 0) 
        {
            shotTimer = shotTimer - 1;
        }
        else if (Greenfoot.isKeyDown("space"))
        {
            Fireball fireball = new Fireball();
            getWorld().addObject(fireball, getX(), getY()-30);
            shotTimer = 50; 
            Greenfoot.playSound("shoot1.wav");     
        }
    }
}
