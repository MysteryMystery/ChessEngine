package me.jamesattfield.chessengine.api.board.location;

public class Coordinate {
    private int x, y;

    public Coordinate(int x, int y) throws InvalidCoordinateException{
        if ((x < 0 || x > 8) || (y < 0 || y > 8))
            throw new InvalidCoordinateException("Coordinate restraints must be within -1 < x < 9.");

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinate add(Coordinate toAdd) throws InvalidCoordinateException{
        return new Coordinate(getX() + toAdd.getX(), getY() + toAdd.getY());
    }

    public Coordinate subtract(Coordinate toSub) throws InvalidCoordinateException {
        return new Coordinate(getX() - toSub.getX(), getY() - toSub.getY());
    }
}
