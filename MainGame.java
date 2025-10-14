import java.awt.*;
import javax.swing.*;
class MainGame {
    //TO DO: add player object and all UI
    GameScreen gameScreen = new GameScreen();
    //TO DO: build + run methods
    void buildStart() {
        JFrame mainScreen = new JFrame("main");
        JPanel startScreen = new JPanel();
        startScreen.setBackground(Color.black);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton start = new JButton("START GAME");
        start.setPreferredSize(new Dimension(250, 150));
        startScreen.add(start, BorderLayout.CENTER);
        mainScreen.add(startScreen);
        mainScreen.setSize(800, 600);
        mainScreen.setVisible(true);
    }

    public static void main(String arg[]){
        new MainGame().buildStart();
    }
}


