package me.jamesattfield.chessengine.api.board.location;

public class Vector2D {
    private int x, y;

    public Vector2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Vector2D add(Vector2D toAdd) {
        return new Vector2D(getX() + toAdd.getX(), getY() + toAdd.getY());
    }

    public Vector2D subtract(Vector2D toSub)  {
        return new Vector2D(getX() - toSub.getX(), getY() - toSub.getY());
    }

    public Coordinate toCoordinate() throws InvalidCoordinateException{
        return new Coordinate(this);
    }

    @Override
    public String toString() {
        return "("+x+", "+y+")";
    }
}
