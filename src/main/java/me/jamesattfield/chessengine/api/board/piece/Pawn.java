package me.jamesattfield.chessengine.api.board.piece;

import me.jamesattfield.chessengine.api.board.ChessBoard;
import me.jamesattfield.chessengine.api.board.location.Coordinate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pawn extends GamePiece{
    private boolean notYetMoved = true;

    public Pawn(PieceColour colour) {
        super(colour);
    }

    @Override
    public Collection<Coordinate> validMoveLocations(Coordinate currentLocation, ChessBoard chessBoard) {
        List<Coordinate> locations = new ArrayList<>();

        try {
            if (getPieceColour() == PieceColour.WHITE){
                if (notYetMoved)
                    locations.add(currentLocation.add(new Coordinate(0, 2)));
                locations.add(currentLocation.add(new Coordinate(0, 1)));
            }else {
                if (notYetMoved)
                    locations.add(currentLocation.subtract(new Coordinate(0, 2)));
                locations.add(currentLocation.subtract(new Coordinate(0, 1)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public char getIcon() {
        return getPieceColour() == PieceColour.WHITE ? '♙' : '♟';
    }
}
