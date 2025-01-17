import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{
    GreenfootSound themeSong = new GreenfootSound("Super Mario Bros. Theme Song.mp3"); //theme song
    int lakituSpawnTimer = 1100; //Spawn timer until Lakitu spawns
    public int numOfEnemies = 24; //Total number of enemies
    public int marioLife = 1; //Life of Mario
    private Counter counter; 
    /**
     * Constructor for objects of class Background. 
     * 
     */
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 600, 1); 
        prepare();  
        counter = new Counter();
        addObject(counter, 50, 580);
    }

    /*
     * Returns the counter, so we can access it.
     */
    public Counter getCounter()
    {
        return counter;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Mario mario = new Mario(); //Places Mario into the game.
        addObject(mario,200,582);
        mario.setLocation(200,570);

        //First row of monsters.
        Mushroom [] MushroomRow = new Mushroom [10];
        for (int i=0;i<8;i++)
        {
            MushroomRow[i] = new Mushroom();
            addObject(MushroomRow[i], (i*40)+60, 50);
        }  

        //Second row of monsters.
        Blooper [] BlooperRow = new Blooper [10];
        for (int i=0;i<8;i++)
        {
            BlooperRow[i] = new Blooper();
            addObject(BlooperRow[i], (i*40)+60, 100);
        }

        //Third row of monsters.
        blueShell [] blueShellRow = new blueShell [10];
        for (int i=0;i<8;i++)
        {
            blueShellRow[i] = new blueShell();
            addObject(blueShellRow[i], (i*40)+60, 150);
        }

        //Places the 3 barriers at the beginning of the game.
        addObject(new Barrier(), 100, 480);
        addObject(new Barrier(), 200, 480);
        addObject(new Barrier(), 300, 480);

        //This loops the theme song once the game starts!
        themeSong.playLoop();
    }

    /*
     * Spawns the Lakitu once which offers bonus points if hit.
     * Also spawns the Speed power ups.
     * Also displays the "YOU WIN!" screen if all the enemies are dead.
     */
    public void act()
    {  
        spawnLakitu();
        spawnSpeedBoost();
        YouWin();
        GameOver();
    }

    /*
     * Spawns the speed boosts only if Mario's speed 
     * is at 4 (his original speed).
     */
    public void spawnSpeedBoost()
    { 
        SpeedPowerUp powerup = new SpeedPowerUp();       
        if(Greenfoot.getRandomNumber(5000) < 3 && Mario.speed == 4) 
        {
            addObject(powerup, Greenfoot.getRandomNumber(400), 582);
            Greenfoot.playSound("speedboostappear.wav");  
        }
    }

    /*
     * After a specific time, Lakitu will spawn
     * in the game, offering bonus (50) points if 
     * hit by the user.
     */
    public void spawnLakitu()
    {
        //After a specific interval, Lakitu will spawn.
        if (lakituSpawnTimer > 0)
        {
            lakituSpawnTimer--;
            if (lakituSpawnTimer == 0)
            {
                Lakitu lakitu = new Lakitu();
                addObject(lakitu,5,20);
                Greenfoot.playSound("lakitu.wav");  
            }
        }
    }

    /*
     * If Mario gets loses a life from either getting
     * hit by a monster's bullet or if the monsters
     * reach a certain point, then 
     * it displays the Game Over screen.
     */
    public void GameOver()
    {
        if (marioLife <= 0)
        {
            //The code below displays 
            //the "GAME OVER" text with the final score.
            GameOver gameover = new GameOver();
            addObject(gameover, getWidth()/2, getHeight()/2);
            Greenfoot.playSound("death.wav"); //plays this sound when Mario dies.
            themeSong.stop();//stops the theme song.
            Greenfoot.stop(); //Stops the game.
        }
    }

    /*
     * If all of the enemies on the screen are dead, 
     * then user wins.
     */  
    public void YouWin()
    {
        if (numOfEnemies == 0)
        {
            YouWin youwin = new YouWin();
            addObject(youwin, getWidth()/2, getHeight()/2);
            themeSong.stop(); //stops the theme song.
            Greenfoot.playSound("win.wav"); //plays this sound when user wins.
            Greenfoot.stop();
        }        
    }
}
