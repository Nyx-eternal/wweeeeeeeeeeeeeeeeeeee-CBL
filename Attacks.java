class Attacks {
    //Class that should generate little objects that will move by themselves so that they are bullets
    //TURNS
    private int dmg;
    //keys
    public void attack(Player player) {
        if (player.isAlive()) {
            player.takeDamage(dmg);
        }
    }

}
