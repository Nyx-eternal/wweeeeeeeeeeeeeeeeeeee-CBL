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
        startGameLoop();
        //just to test if the method was even called when having errors
        System.out.println("GAME READY FOR ACTION");
    }

    //TO DO: build + run methods
    private void startGameLoop(){
        gameLoop = new Thread(this);
        gameLoop.start();
    }

    @Override
    public void run(){
        // a game loop that runs in the bg for player repainting
        double timePerFrame = 1000000000.0 / 120;
        long lastFrame = System.nanoTime();
        long now;
        int i = 0;
        while (true) { 
            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame){
                if(i %  50== 0){
                    screen.boss.nextAttack();
                }
                screen.repaint();
                lastFrame = now;
                
                if(i % 20 == 0){
                    for(Attacks a : screen.boss.attack()){
                        
                    java.util.List<Attacks> bs = screen.boss.getBullets();
                    for (java.util.Iterator<Attacks> it = bs.iterator(); it.hasNext(); ) {
                        Attacks b = it.next();
                        if (!b.isActive()) { it.remove(); continue; }

                        if (Collision.rectsIntersect(b.getBounds(), screen.player.getBounds())) {
                            screen.player.takeDamage(b.getDamage());  
                            b.deactivate();
                            it.remove(); 
                    }
                }

                        a.faster();
                    }
                }
                i++;
            }
        }
    }




    public static void main(String arg[]){
        new MainGame();
    }
}
