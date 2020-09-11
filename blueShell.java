import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.*;

/**
 * Write a description of class BlueShell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class blueShell extends Actor
{
    public int dir = 1; // 1 = right, 2 = left.
    public int timer = 0;
    public boolean shouldMove = false;
    public int edgeCheck = 0;
    private int shotTimer=0;
    /**
     * Act - do whatever the BlueShell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //fix movement and timer for explosion    
    public void act() 
    {
        move();
        shoot(); 
        checkBorder();
    }    

    public void moveRight()
    {
        setLocation(getX(),getY()+20);
        dir = 1; 
    }

    public void moveLeft()
    {
        setLocation(getX(),getY()+20);
        dir = 2; 
        //reference to Game Over screen if getX() is past around 500
    }

    public void move()
    {
        if (dir == 1 && edgeCheck == 1) //Stops the blueShell if it is going right and reaches the edge of the world.
        {
            if (getX()+5 >= 395)
            {
                moveLeft();
                bringAlliesLeft(); //calls this method
                timer = 0; //resets timer
                shouldMove = false; //false means the monster cannot move.
            }
        }
        else if (dir == 2 && edgeCheck == 1)//Stops the blueShell if it is going left and reaches the edge of the world.
        {
            if (getX()-5 <= 0)
            {
                moveRight();
                bringAlliesRight(); //calls this method
                timer = 0; //resets move timer
                shouldMove = false;
            }
        }
        if (dir == 1 && shouldMove == true)//Moving right without being at the edge of the world.
        {
            setLocation(getX()+15, getY());
            shouldMove = false; // should not move.
        }
        else if (dir == 2 && shouldMove == true)//Moving left without being at the edge of the world.
        {
            setLocation(getX()-15, getY());
            shouldMove = false; // should not move.
        }
        else if (shouldMove == false) //If the monster cannot move.
        {
            timer+=1; 
            if (timer == 26)
            {
                edgeCheck = 1; //checks to see if the monster is at the edge, if not, then it moves again.
            }
            else if (timer == 27)
            {
                shouldMove = true; //true means the monster can move.
                edgeCheck = 0; //resets the edge checker.
                timer = 0; //resets move timer.
            }
        }
    }

    /*
     * This method checks to see if there are any Actors 
     * next to it, then moves all of the monsters 
     * to the right at the same time.
     */

    private void bringAlliesRight()
    {
        List allies = getWorld().getObjects(blueShell.class);//Lists all of the other enemies.
        Iterator i = allies.iterator();
        while(i.hasNext()) //If there are more enemies to move, this loop runs.
        {
            blueShell r = (blueShell) i.next(); //puts the Actor into a variable.
            if ( r != this) //if the Actor hasn't already moved yet
            {
                r.moveRight(); //moves the Actor down 
                r.setLocation(r.getX(), r.getY());
                r.shouldMove = false;
                r.timer = 0;
            }
        }
    }

    /*
     * This method checks to see if there are any Actors 
     * next to it, then moves all of the monsters 
     * to the right at the same time.
     */
    private void bringAlliesLeft()
    {
        List allies = getWorld().getObjects(blueShell.class);
        Iterator i = allies.iterator();
        while(i.hasNext())//If there are more enemies to move, this loop runs.
        {
            blueShell l = (blueShell) i.next();//puts the Actor into a variable.
            if ( l != this) //if the Actor hasn't already moved yet
            { 
                l.moveLeft();//moves the Actor down
                l.setLocation(l.getX(), l.getY());
                l.shouldMove = false;
                l.timer = 0;
            }
        }
    }

    /*
     * This method allows the blueShell 
     * to shoot if the given random number
     * is less than 3 and if blueShell is 
     * past a certain y-coordinate. This means
     * there is a 1 in 1000 chance for the 
     * blueShell to shoot.
     */
    public void shoot()
    {
        monsterBullet bullet = new monsterBullet();
        if (Greenfoot.getRandomNumber(1000) < 1 && this.getY()>=150)
        {
            getWorld().addObject(bullet,getX(),getY()+5);
        }
        else if (this.getY()>=200)
        {
            if(Greenfoot.getRandomNumber(80) < 1)
            {
                getWorld().addObject(bullet,getX(),getY()+5);
            }
        }
    }
    
    /*
     * If the monsters go past 
     */
    
    public void checkBorder()
    {
        Background background = (Background) getWorld(); //gets a reference to the world
        Background bg = (Background) getWorld();
        if (this.getY()>=350)
        {
            bg.marioLife--;
        }
    }
}
