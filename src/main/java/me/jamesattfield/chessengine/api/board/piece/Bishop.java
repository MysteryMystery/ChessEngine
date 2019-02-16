package me.jamesattfield.chessengine.api.board.piece;

import me.jamesattfield.chessengine.api.board.location.Coordinate;

import java.util.Collection;

public class Bishop extends GamePiece {

    public Bishop(PieceColour colour) {
        super(colour);
    }

    @Override
    public boolean canMoveTo(Coordinate from, Coordinate to) {
        return false;
    }

    @Override
    public Collection<Coordinate> validMoveLocations(Coordinate currentLocation) {
        return null;
    }

    @Override
    public char getIcon() {
        return getPieceColour() == PieceColour.WHITE ? '♗' : '♝';
    }
}
