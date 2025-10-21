class Attacks {
    //Class that should generate little objects that will move by themselves so that they are bullets
    //TURNS
    //keys
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) up = true;
        if (code == KeyEvent.VK_DOWN) down = true;
        if (code == KeyEvent.VK_LEFT) left = true;
        if (code == KeyEvent.VK_RIGHT) right = true;

        //attack
        if (code == KeyEvent.VK_SPACE) {
            if (Math.abs(playerX - bossX) < 80 && Math.abs(playerY - bossY) < 80) {
                bossHp -= 10;
                if (bossHp <= 0) bossHp = 0;
            }
        }
    }
}
