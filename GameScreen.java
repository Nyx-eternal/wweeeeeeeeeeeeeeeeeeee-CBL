import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GameScreen extends JPanel implements KeyListener{
    Player player;
    Boss boss;
    private final Image startScreen = new ImageIcon("./images/startscreen.jpeg").getImage();
    private boolean begin;
    private final Image boss1 = new ImageIcon("./images/boss1.jpeg").getImage();
    private final Image boss2 = new ImageIcon("./images/boss2.jpeg").getImage();
    private final Image bossBeat = new ImageIcon("./images/bossBeat.jpeg").getImage();

    //Main Game Screen where the battle would happen
    public GameScreen(){
        setBackground(Color.black);
        System.out.println("game screen reaady");
    }
    //Added KeyListener + player movements
    //TO DO: add the player sprite + movements in Player class to be used here
     
    public void gameTime(){
        this.player = new Player();
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(this);
        this.boss = new Boss();
    }





    @Override
    protected  void paintComponent(Graphics g){
        super.paintComponent(g);
        //just to test if the method was even called when having errors
        System.out.println("painting?");

        //background first
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        //ia set of string just to see if it works
        g.setColor(Color.black);
        g.drawString("...Father?", 100, 100);

        }
        //the man, the myth, the legendary player sprite itself
        //currently placeholder

        //hp bar
    

        //hp bar
        g.setColor(Color.red);
        g.fillRect(20, 20, player.getHP()*2, 15);

    }
    
    @Override
    public void keyPressed(KeyEvent e){
        int pressed = e.getKeyCode();
        if(pressed == KeyEvent.VK_W){
            player.moveUp();
            repaint();

        }
        if(pressed == KeyEvent.VK_A){
            player.moveLeft();
            repaint();
        }
        if(pressed == KeyEvent.VK_S){
            player.moveDown();
            repaint();
        }
        if(pressed == KeyEvent.VK_D){
            player.moveRight();
            repaint();
        }
        begin = true;
    }
    @Override
    public void keyReleased(KeyEvent e){
        //TO DO: placeholder code
        begin = true;
    }

    @Override
    public void keyTyped(KeyEvent e){
        //TO DO: placeholder code
    }
}
