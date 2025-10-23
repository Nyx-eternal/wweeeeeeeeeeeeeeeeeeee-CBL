public class Boss {

    private int hp;
    private final int maxHp;



    public Boss() {
        this.maxHp = 300;
        this.hp = maxHp;
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

    
}


