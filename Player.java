import java.awt.*;
import javax.swing.*;

class Player extends Movement{
    //The player character 
    int maxHP;
    int hp; //all other vars are declared in Movement class so i erased them here
    Image spriteL;
    Image spriteR;
    Image sprite;

    //Constructor w/ factory settings < we need to be able to affect only from outside
    public Player(){
<<<<<<< HEAD
        x = 0;
        y = 0;
        maxHP = 100;
        hp = maxHP;
        speed = 20;
        spriteR = new ImageIcon("./images/robot.png").getImage();
        spriteL = new ImageIcon("./images/robotLeft.png").getImage();
        sprite = spriteR;

        x = 460;
        y = 570;
        hp = 100;
        speed = 20;
        sprite = new ImageIcon("./images/player1/right/playerIdleR.jpeg").getImage();

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

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0) hp = 0;
    }
    public void setY(int i) {
        y = i;
        }
    public void setX(int i) {
        x = i;
    }
    

    public boolean isAlive() {
        return hp > 0;
    }

    public Rectangle getBounds() {
        // keep it simple; tune the 48x48 later if you want
        return new Rectangle(x, y, 48, 48);
    }

}

