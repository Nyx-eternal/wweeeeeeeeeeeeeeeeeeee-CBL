import java.util.Random;

class Attacks extends Movement {
    //Class that should generate little objects that will move by themselves so that they are bullets
    //TURNS
    public Attacks(int spd){
        x =
        y = 
        speed = spd;
    }
    private int dmg;
    //keys
    public void attack(Player player) {
        if (player.isAlive()) {
            player.takeDamage(dmg);
        }
    }

    public void move(){
        Random r = new Random();
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

}
