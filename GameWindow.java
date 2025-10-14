import java.awt.*;
import javax.swing.*;

class GameWindow {
    private JFrame jframe;
    private GameScreen gameScreen;

    public GameWindow(){
        jframe = new JFrame("main");
        jframe.setSize(800, 600);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
    void buildStart() {
        JPanel startScreen = new JPanel();
        startScreen.setBackground(Color.black);
        JButton start = new JButton("START GAME");
        start.setPreferredSize(new Dimension(250, 150));
        startScreen.add(start, BorderLayout.SOUTH);
        jframe.add(startScreen);
        
    }
    void buildGame(){
        jframe.add(new GameScreen());
    }
}
