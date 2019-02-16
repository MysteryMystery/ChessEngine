package me.jamesattfield.chessengine.api.board.piece;

import me.jamesattfield.chessengine.api.board.ChessBoard;
import me.jamesattfield.chessengine.api.board.location.Coordinate;

import java.util.Collection;

public class Queen extends GamePiece{

    public Queen(PieceColour colour) {
        super(colour);
    }

    @Override
    public Collection<Coordinate> validMoveLocations(Coordinate currentLocation, ChessBoard chessBoard) {
        return null;
    }

    @Override
    public char getIcon() {
        return getPieceColour() == PieceColour.WHITE ? '♕' : '♛';
    }
}
