import javax.swing.ImageIcon;

public class Boss {

    private int hp;
    private final int maxHp;
    private int damage;
    private Image sprite;
    private int x, y;
    public int getX() { return x; }
    public int getY() { return y; }


    public Boss(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.maxHp = 300;
        this.hp = maxHp;
        this.damage = 25;
        this.sprite = new ImageIcon("./images/boss.png").getImage();
    }

    public Image getSprite() {
        return sprite;
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

    public void attack(Player player) {
        if (player.isAlive()) {
            player.takeDamage(damage);
        }
    }

    
}


