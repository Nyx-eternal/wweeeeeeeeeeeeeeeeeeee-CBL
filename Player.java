import java.awt.*;
import javax.swing.*;

class Player extends Movement{
    //The player character 
    int maxHP;
    int hp; //all other vars are declared in Movement class so i erased them here
    Image sprite;

    //Constructor w/ factory settings < we need to be able to affect only from outside
    public Player(){
        x = 0;
        y = 0;
        maxHP = 100;
        hp = maxHP;
        speed = 20;
        sprite = new ImageIcon("./images/robot.png").getImage();
    }

    //DOESNT TURN / DOESNT USE TURN METHODS
    //TO DO hp fluctuation + add the item button here? where should it go?
    public Image getSprite(){
        return sprite;
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
}
