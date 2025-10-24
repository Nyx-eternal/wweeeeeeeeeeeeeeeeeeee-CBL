import java.util.*;

public class Boss {

    private int hp;
    private final int maxHp;
    ArrayList<Attacks> bullets = new ArrayList<Attacks>();
    int lowerLimit;
    int upperLimit;
    Random r = new Random();



    public Boss() {
        this.maxHp = 300;
        this.hp = maxHp;
        lowerLimit = 2;
        upperLimit = 5;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return hp > 0;
    }


    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0) hp = 0;
    }

    public int phase(){
        if(hp >= 150){
            return 1;
        }
        else if(hp < 150 && hp > 0){
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

    public ArrayList<Attacks> attack(){
        for( Attacks a : bullets){
            a.move();
        }
        return bullets;
    }
        public java.util.List<Attacks> getBullets() { return bullets; }
    
}


