import java.awt.*;
import javax.swing.*;

class Player extends Movement{
    //The player character 
    int hp; //all other vars are declared in Movement class so i erased them here
    Image sprite;

    //Constructor w/ factory settings < we need to be able to affect only from outside
    public Player(){
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
    
}

