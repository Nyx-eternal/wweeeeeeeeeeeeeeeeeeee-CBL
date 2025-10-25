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
    private final Image bossBeat = new ImageIcon("./images/bossBeat.png").getImage();
    private final Image gameover = new ImageIcon("./images/gameover.png").getImage();
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

    public void restart(){
        player.restart();
        boss.restart();
        begin = false;
    }




    @Override
    protected  void paintComponent(Graphics g){
        super.paintComponent(g);

        if(!begin){
            g.drawImage(startScreen, 0, 0, getWidth(), getHeight(), this);
        }
        else if(!player.isAlive()){
            //gameover screen
            
           g.drawImage(gameover, 0, 0, getWidth(), getHeight(), this);
        }
        else if(!boss.isAlive()){
            //win screen
            g.drawImage(bossBeat, 0, 0, getWidth(), getHeight(), this);

        }
        else{
        //background + boss
            if(!boss.isAlive()){
                g.drawImage(bossBeat, 0, 0, getWidth(), getHeight(), this);
            }
            else if(boss.phase() == 1)
            {
                g.drawImage(boss1, 0, 0 ,getWidth(), getHeight(), this); 
                for(Attacks a : boss.attack()){
                    g.drawImage(a.getSprite(), a.getX(), a.getY(), a.getWidth(), a.getHeight(), this);
                } 
            }
            else{
                g.drawImage(boss2, 0, 0, getWidth(), getHeight(), this);
                for(Attacks a : boss.attack()){
                    if(a.isActive()){
                    g.drawImage(a.getSprite(), a.getX(), a.getY(), a.getWidth(), a.getHeight(), this);
                    }
                }
            }
            g.drawImage(player.getSprite(), player.getX(), player.getY(), 70, 55, this);
        
        g.setColor(Color.black);
        g.fillRect(25, 865, player.getMaxHP()*4, 15);
        g.fillRect(20, 5, boss.getMaxHp()*17/9, 15);
        g.setColor(Color.blue);
        g.fillRect(20, 5, boss.getHp()*17/9, 15);
        g.setColor(Color.green);
        g.fillRect(25, 865, player.getHP()*4, 15);
        g.setColor(Color.white);
        g.drawString("HP", 5, 877);

        }
        //the man, the myth, the legendary player sprite itself
        //currently placeholder

        //hp bar
    

    }
    
    @Override
    public void keyPressed(KeyEvent e){
        int pressed = e.getKeyCode();
        if(pressed == KeyEvent.VK_W){
            player.moveUp();
            if(player.getY() < 425){
                player.setY(425);
            }

        }
        if(pressed == KeyEvent.VK_A){
            player.moveLeft();
            if(player.getX() < -3){
                player.setX(-3);
            }
        }
        if(pressed == KeyEvent.VK_S){
            player.moveDown();
            if(player.getY() > 765){
                player.setY(765);
            }
        }
        if(pressed == KeyEvent.VK_D){
            player.moveRight();
            if(player.getX() > 952){
                player.setX(952);
            }
        }
        if(pressed ==  KeyEvent.VK_SPACE){
            boss.takeDamage((int)(Math.random()*21)+ 10);
            
        }
        begin = true;

        if(!player.isAlive() || !boss.isAlive()){
            if(pressed == KeyEvent.VK_R){
                restart();
            }
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
