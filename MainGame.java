import javax.swing;

public void MainGame(){
    public void run(){
        JFrame mainScreen = new JFrame("main");
        mainScreen.add(JFrame.EXIT_ON_CLOSE);
        JButton start = new JButton("START GAME");
        mainScreen.getContentPane().add(start, BorderLayout.CENTER);
    }
}
