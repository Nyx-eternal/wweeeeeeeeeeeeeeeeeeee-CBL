import java.awt.*;
import javax.swing.*;

class GameWindow {
    JFrame jframe;
    GameScreen jpanel;

    public GameWindow(){
        jframe = new JFrame("main");
        jframe.setSize(800, 600);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("frame exists");
    }
    void buildStart() {
        JPanel startScreen = new JPanel();
        startScreen.setBackground(Color.black);
        JButton start = new JButton("START GAME");
        start.setPreferredSize(new Dimension(250, 150));
        startScreen.add(start, BorderLayout.SOUTH);
        jframe.add(startScreen);
        
    }
    public void buildGame(GameScreen gameScreen){
        jpanel = gameScreen;
        jframe.add(jpanel);
        jframe.setVisible(true);
        
        System.out.println("panel shiuld be added");
    }
}
