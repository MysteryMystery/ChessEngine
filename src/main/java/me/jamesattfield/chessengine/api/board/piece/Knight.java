package me.jamesattfield.chessengine.api.board.piece;

import me.jamesattfield.chessengine.api.board.location.Coordinate;

public class Knight extends GamePiece {

    public Knight(PieceColour colour) {
        super(colour);
    }

    @Override
    public void moveTo(Coordinate coordinate) {

    }

    @Override
    public void canMoveTo(Coordinate coordinate) {

    }

    @Override
    public void canTake(Coordinate coordinate) {

    }

    @Override
    public char getIcon() {
        return getPieceColour() == PieceColour.WHITE ? '♘' : '♞';
    }
}
