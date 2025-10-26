import java.awt.*;
import java.util.Random;
import javax.swing.ImageIcon;

class Attacks extends Movement {
    Random r = new Random();
    Image sprite;
    private final int width;
    private final int height;
    Boolean active = true;
    private int dmg;
    //Class that should generate little objects that will move by themselves so that they are bullets
    //TURNS
    public Attacks(){
        x = r.nextInt(1000);
        y = r.nextInt(425, 766);
        width = r.nextInt(25, 75);
        height = r.nextInt(30, 80);
        dmg = 1;
        speed = 1;
        int i = r.nextInt(1, 4);
        switch (i) {
            case 1:
            sprite = new ImageIcon( "./images/bullet/lightning1.png").getImage();
            case 2:
            sprite = new ImageIcon( "./images/bullet/lightning2.png").getImage();
            case 3:
            sprite = new ImageIcon( "./images/bullet/lightning3.png").getImage();
            case 4:
            sprite = new ImageIcon( "./images/bullet/lightning4.png").getImage();
        }
    }
    

    //keys
    public void faster(){
        speed++;
    }

    public void move(){
        int i = r.nextInt(1, 5);
        switch(i){
            case 1:
            moveUp();
            case 2:
            moveDown();
            case 3:
            moveLeft();
            case 4:
            moveRight();
        }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public Image getSprite(){
        return sprite;
    }


    public java.awt.Rectangle getBounds() {
        return new java.awt.Rectangle(x, y, width, height);
    }

    public int getDamage() { 
        return dmg; 
    }

    public boolean isActive() {
        return active; 
    }

    public void deactivate() {
        active = false;
    }
        public java.awt.Rectangle getBounds() {
        return new java.awt.Rectangle(x, y, width, height);
    }

    public int getDamage() { return dmg; }

    public boolean isActive() { return active; }

    public void deactivate() { active = false; }

    // Boss attack calls
    public void move() {
        // bullets travel left
        x -= speed;
    }

}
