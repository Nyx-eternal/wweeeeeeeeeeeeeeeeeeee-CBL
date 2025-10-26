import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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
                if(i %  120 == 0){
                    screen.boss.nextAttack();
                }
                screen.repaint();
                lastFrame = now;
                for(Attacks a : screen.boss.attack()){
                    if(a.isActive()){
                        if (Collision.rectsIntersect(a.getBounds(), screen.player.getBounds())) {
                            screen.player.takeDamage(a.getDamage());
                            a.deactivate(); 
                        }
                    }
                    if(i % 120 == 0){
                        a.faster();
                        if(screen.boss.phase() == 2){
                            a.faster();
                            a.faster();
                            screen.boss.phase2();
                        }
                    }
                }
                if(!screen.boss.isAlive()){
                    for(Attacks a : screen.boss.attack()){
                        a.deactivate();
                    }
                    
                }
                i++;
                if(!screen.player.isAlive()){
                    i = 0;
                }
            }
        }
    }




    public static void main(String arg[]){
        try{
            File soundFile = new File("./sfx/startgame.aiff");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(-10.0f);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
        }
        new MainGame();
    }
}
