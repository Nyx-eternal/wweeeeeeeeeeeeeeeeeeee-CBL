public class Boss {

    private int hp;
    private final int maxHp;
    private int damage;
    private int x, y;
    public int getX() { return x; }
    public int getY() { return y; }


    public Boss(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.maxHp = 300;
        this.hp = maxHp;
        this.damage = 25;
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
        if(hp >= 50){
            return 1;
        }
        else if(hp < 50 && hp > 0){
            return 2;
        }
        else {
            return 0;
        }
    }

    
}


