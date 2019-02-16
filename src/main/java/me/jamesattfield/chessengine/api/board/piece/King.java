package me.jamesattfield.chessengine.api.board.piece;

import me.jamesattfield.chessengine.api.board.ChessBoard;
import me.jamesattfield.chessengine.api.board.location.Coordinate;

import java.util.Collection;

public class King extends GamePiece {

    public King(PieceColour colour) {
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

    public boolean canDoCastling(ChessBoard chessBoard, Coordinate rookLoc){
        return false;
    }

    @Override
    public char getIcon() {
        return getPieceColour() == PieceColour.WHITE ? '♔' : '♚';
    }
}
