class Player extends Movement{
    //The player character
    int x;
    int y; 
    int hp; 
    //All it needs is overriding movement w/ keyboard inputs <--- Not here but in GameScreen now.
    public Player(){
        x = 300;
        y = 400;
        hp = 100;
    }

    //DOESNT TURN / DOESNT USE TURN METHODS
    //TO DO hp fluctuation + add the item button here? where should it go?
}
