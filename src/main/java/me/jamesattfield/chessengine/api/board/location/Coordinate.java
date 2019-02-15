package me.jamesattfield.chessengine.api.board.location;

public class Coordinate {
    private int x, y;

    public Coordinate(int x, int y) throws Exception{
        if ((x < 0 || x > 8) || (y < 0 || y > 8))
            throw new Exception("Coordinate restraints must be within -1 < x < 9.");

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
