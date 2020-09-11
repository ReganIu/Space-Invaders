import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    Counter score = new Counter();
    /**
     * This is the Game Over screen, it will display this when Mario dies.
     */
    public GameOver() 
    {
        setImage(new GreenfootImage("GAME OVER", 70, Color.WHITE, Color.BLACK)); //displays the GAME OVER text.
    }    
}
