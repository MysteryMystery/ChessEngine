package me.jamesattfield.chessengine.api.board.location;

import java.util.Vector;

public class Coordinate {
    private Vector2D vector2D;

    public Coordinate(Vector2D vector2D) throws InvalidCoordinateException{
        this.vector2D = vector2D;

        int x = vector2D.getX();
        int y = vector2D.getY();

        if ((x < 0 || x > 8) || (y < 0 || y > 8))
            throw new InvalidCoordinateException("Coordinate restraints must be within -1 < x < 9.");
    }

    public boolean isValid(){
        return !(vector2D.getX() < 0 || vector2D.getX() > 8) || (vector2D.getY() < 0 || vector2D.getY() > 8);
    }

    public Coordinate add(Vector2D toAdd) {
        vector2D = vector2D.add(toAdd);
        return this;
    }

    public Coordinate subtract(Vector2D toSub)  {
        vector2D = vector2D.subtract(toSub);
        return this;
    }

    public Vector2D getVector2D() {
        return vector2D;
    }
}
