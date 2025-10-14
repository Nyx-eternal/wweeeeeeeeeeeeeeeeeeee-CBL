import java.awt.*;
import javax.swing.*;

class GameScreen extends JPanel implements KeyListener{
    private Player player;

    //Main Game Screen where the battle would happen
    public GameScreen(){
        setBackground(Color.BLACK);
        JLabel bg = new JLabel(new ImageIcon("./images/placeholder.png"));
        add(bg);
    }
    //Added KeyListener + player movements
    //TO DO: add the player sprite + movements in Player class to be used here
     
    public void GameTime(){
        this.player = new Player();
        setFocusable(true);
        addKeyListener(this);
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        int pressed = e.getKeyCode();
        if(pressed == KeyEvent.VK_W){
            player.moveUp();

        }
        if(pressed == KeyEvent.VK_A){
            player.moveLeft();
        }
        if(pressed == KeyEvent.VK_S){
            player.moveDown();
        }
        if(pressed == KeyEvent.VK_D){
            player.moveRight();
        }
    }
    @Override
    public void keyReleased(KeyEvent e){

    }
    @Override
    public void keyTyped(KeyEvent e){

    }
}
