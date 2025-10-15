class MainGame implements Runnable{
    GameWindow window;
    GameScreen screen;
     Thread gameLoop;

    //TO DO: add player object and all UI
    public MainGame(){
        screen = new GameScreen();
        screen.gameTime();
        window = new GameWindow();
        window.buildGame(screen);
        
        System.out.println("GAME READY FOR ACTION");
    }

    //TO DO: build + run methods
    private void startGameLoop(){
        gameLoop = new Thread(this);
        gameLoop.start();
    }

    @Override
    public void run(){
        // a game loop that runs in the bg for animation loop
        double timePerFrame = 1000000000.0 / 120;
        long lastFrame = System.nanoTime();
        long now;
        while (true) { 
            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame){
                screen.repaint();
                lastFrame = now;
            }
        }
    }




    public static void main(String arg[]){
        new MainGame();
    }
}