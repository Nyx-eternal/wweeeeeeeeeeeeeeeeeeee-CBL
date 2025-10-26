import java.awt.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

class Player extends Movement{
    //The player character 
    int maxHP;
    int hp; //all other vars are declared in Movement class so i erased them here
    private final int maxHP = 100;
    Image sprite;
    Image hurtSprite = new ImageIcon("./images/playerHurt.png").getImage();
    Image spriteN = new ImageIcon("./images/player.png").getImage();

    //Constructor w/ factory settings < we need to be able to affect only from outside
    public Player(){
        x = 460;
        y = 570;
        hp = maxHP;
        speed = 20;
        sprite = spriteN;
    }
    //DOESNT TURN / DOESNT USE TURN METHODS
    //TO DO hp fluctuation + add the item button here? where should it go?
    public Image getSprite(){
        return sprite;
    }


    public void moveLeft(){
        super.moveLeft();
        sprite = spriteL;
    }
    public void moveRight(){
        super.moveRight();
        sprite = spriteR;
    }

    public void takeDamage(int i){
        hp -= i;
    }

    public void heal(int i){
        hp += i;
        if(hp > maxHP){
            hp = maxHP;
        }
    }
    public int getHP(){
        return hp;
    }

    public int getHP() {
        return hp;
    }

    public int getMaxHP() {
        return maxHP;
    }


    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0){
            hp = 0;
            try{
            File soundFile = new File("./sfx/gameover.aiff");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(-900.0f);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
        }
        }
        sprite = hurtSprite;
        try{
            File soundFile = new File("./sfx/playerDmg.aiff");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(-10.0f);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
        }
        
    }

    public void setY(int i) {
        y = i;
        }
    public void setX(int i) {
        x = i;
    }

    public Rectangle getBounds() {
        // keep it simple; tune the 48x48 later if you want
        return new Rectangle(x, y, 70, 55);
    }
    
    public void restart(){
        x = 460;
        y = 570;
        hp = maxHP;
        speed = 20;
        sprite = spriteN;
        }


    @Override
    public void moveUp(){
        super.moveUp();
        sprite = spriteN;
    }
    @Override
    public void moveDown(){
        super.moveDown();
        sprite = spriteN;
    }
    @Override
    public void moveLeft(){
        super.moveLeft();
        sprite = spriteN;
    }
    @Override
    public void moveRight(){
        super.moveRight();
        sprite = spriteN;
    }
}

