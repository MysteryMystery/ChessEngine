package me.jamesattfield.chessengine.api.board.piece;

import me.jamesattfield.chessengine.api.board.location.Coordinate;

import java.util.Collection;

public abstract class GamePiece {
    private PieceColour pieceColour;

    public GamePiece(PieceColour colour){
        this.pieceColour = colour;
    }

    public abstract boolean canMoveTo(Coordinate from, Coordinate to);

    public abstract Collection<Coordinate> validMoveLocations(Coordinate currentLocation);

    //public abstract boolean canTake(Coordinate coordinate);

    public PieceColour getPieceColour(){
        return pieceColour;
    }

    public abstract char getIcon();

    @Override
    public String toString(){
        return "" + getIcon();
    }
}
