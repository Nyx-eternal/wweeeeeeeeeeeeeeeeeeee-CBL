import javax.swing.*;

class GameWindow {
    JFrame jframe;
    GameScreen jpanel;

    public GameWindow(){
        jframe = new JFrame("main");
        jframe.setSize(1000, 1000);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //just to test if the method was even called when having errors
        System.out.println("frame exists");
    }
    public void buildGame(GameScreen gameScreen){
        jpanel = gameScreen;
        jframe.add(jpanel);
        jframe.setVisible(true);
        //just to test if the method was even called when having errors
        System.out.println("panel shiuld be added");
    }
}
