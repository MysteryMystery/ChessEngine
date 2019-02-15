package me.jamesattfield.chessengine.api.board.piece;

import me.jamesattfield.chessengine.api.board.location.Coordinate;

public abstract class GamePiece {
    private PieceColour pieceColour;

    public GamePiece(PieceColour colour){
        this.pieceColour = colour;
    }

    public abstract void moveTo(Coordinate coordinate);

    public abstract void canMoveTo(Coordinate coordinate);

    public abstract void canTake(Coordinate coordinate);

    public PieceColour getPieceColour(){
        return pieceColour;
    }

    public abstract char getIcon();

    @Override
    public String toString(){
        return "" + getIcon();
    }
}
