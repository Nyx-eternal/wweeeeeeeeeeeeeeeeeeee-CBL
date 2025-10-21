import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GameScreen extends JPanel implements KeyListener{
    Player player;
    Boss boss;
    private Image start = new ImageIcon("./images/startscreen.jpeg").getImage();
    private boolean begin;
    private Image boss1 = new ImageIcon("./images/boss1.jpeg").getImage();
    private Image boss2 = new ImageIcon("./images/boss2.jpeg").getImage();
    private Image bossBeat = new ImageIcon("./images/bossBeat.jpeg").getImage();

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
    }
    @Override
    protected  void paintComponent(Graphics g){
        super.paintComponent(g);

        //background first
        if(!begin){
        g.drawImage(start, 0, 0, getWidth(), getHeight(), this);
        }
        else{
            if(!boss.isAlive()){
                g.drawImage(bossBeat, 0, 0, getWidth(), getHeight(), this);
            }
            else if(boss.phase() == 1)
            {
                g.drawImage(boss1, 0, 0 ,getWidth(), getHeight(), this);
            }
            else{
                g.drawImage(boss2, 0, 0, getWidth(), getHeight(), this);
            }
        //the man, the myth, the legendary player sprite itself
        //currently placeholder
        g.drawImage(player.getSprite(), player.getX(), player.getY(), 160, 160, this);

        //hp bar
        g.setColor(Color.red);
        g.fillRect(20, 20, player.getHP()*2, 15);
        }

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
        begin = true;
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
