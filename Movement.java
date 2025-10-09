class Movement{
    //Goal is generic class with ability to move so we can extend to Player + Attacks w/ mith more specific abilities
    int x; //x-coord
    int y; //y-coord
    //TO DO: move ←, →, ↓, ↑ all different - NO INPUTS JUST THE METHODS ++ TURNING L/R
    void moveUp(){
        y++;
    }
    void moveDown(){
        y--;
    }
    int getX(){
        return x;
    }
    int getY(){
        return y;
    }
    void moveRight(){
        x++;
    }
    void moveLeft(){
        x--;
    }
}