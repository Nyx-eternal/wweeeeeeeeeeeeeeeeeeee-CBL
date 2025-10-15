class Movement{
    //Goal is generic class with ability to move so we can extend to Player + Attacks w/ more specific abilities
    int x; //x-coord
    int y; //y-coord
    int speed; // +1 was a bit too slow
    //TO DO: move ←, →, ↓, ↑ all different - NO INPUTS JUST THE METHODS ++ TURNING L/R
    void moveUp(){
        y -= speed;
    }
    void moveDown(){
        y += speed;
    }
    void moveRight(){
        x += speed;
    }
    void moveLeft(){
        x -= speed;
    }
    int getX(){
        return x;
    }
    int getY(){
        return y;
    }
}