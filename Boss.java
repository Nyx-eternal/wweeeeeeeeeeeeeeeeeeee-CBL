import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Boss {

    private int hp;
    private final int maxHp = 500;
    ArrayList<Attacks> bullets = new ArrayList<>();
    int lowerLimit;
    int upperLimit;
    Random r = new Random();



    public Boss() {
        hp = maxHp;
        lowerLimit = 1;
        upperLimit = 3;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }
    

    public boolean isAlive() {
        return hp > 0;
    }


    public void takeDamage(int dmg) {
        hp -= dmg;
        if(hp > 0){
            try {File soundFile = new File("./sfx/bossDmg.aiff");
             AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(-10.0f);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
        }
        }
        if (hp < 0) {
            hp = 0;
            try{
            File soundFile = new File("./sfx/win.aiff");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(-10.0f);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
        }
        }
        
    }

    public int phase(){
        if(hp >= 250){
            return 1;
        }
        else if(hp < 250 && hp > 0){
            return 2;
        }
        else {
            return 0;
        }
    }

    public void nextAttack(){
        for(int i = 0; i < r.nextInt(lowerLimit, upperLimit); i++){
            bullets.add(new Attacks());
        }
    }

    ArrayList<Attacks> attack(){
        for( Attacks a : bullets){
            a.move();
        }
        return bullets;
    }

    void phase2(){
        lowerLimit = 5;
        upperLimit = 7;
    }

    public void restart(){
        hp = maxHp;
        lowerLimit = 1;
        upperLimit = 3;
        bullets.clear();
    }
}


