import java.util.Random;

class Attacks extends Movement {
    Random r = new Random();
    //Class that should generate little objects that will move by themselves so that they are bullets
    //TURNS
    public Attacks(){
        x = r.nextInt(1000);
        y = r.nextInt(425, 766);
        speed = 1;
    }
    private int dmg;

    //keys
    public void attack(Player player) {
        if (player.isAlive()) {
            player.takeDamage(dmg);
        }
    }

    public void faster(){
        speed++;
    }

    public void move(){
        int i = r.nextInt(1, 5);
        switch(i){
            case 1:
            moveUp();
            case 2:
            moveDown();
            case 3:
            moveLeft();
            case 4:
            moveRight();
        }
    }

    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
        public java.awt.Rectangle getBounds() {
        return new java.awt.Rectangle(x, y, width, height);
    }

    public int getDamage() { return dmg; }

    public boolean isActive() { return active; }

    public void deactivate() { active = false; }

    // Boss attack calls
    public void move() {
        // bullets travel left
        x -= speed;
    }

}
