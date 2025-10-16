import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GameScreen extends JPanel implements KeyListener{
    Player player;
    private Image backgroundImage;

    //Main Game Screen where the battle would happen
    public GameScreen(){
        setBackground(Color.black);
        backgroundImage = new ImageIcon("./images/placeholder.jpg").getImage();
        System.out.println("game screen reaady");
    }
    //Added KeyListener + player movements
    //TO DO: add the player sprite + movements in Player class to be used here
     
    public void gameTime(){
        this.player = new Player();
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(this);
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

        //the man, the myth, the legendary player sprite itself
        //currently placeholder
        g.drawImage(player.getSprite(), player.getX(), player.getY(), 160, 160, this);

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
    }
    @Override
    public void keyReleased(KeyEvent e){
        //TO DO: placeholder code
    }
    
    @Override
    public void keyTyped(KeyEvent e){
        //TO DO: placeholder code
    }
}
