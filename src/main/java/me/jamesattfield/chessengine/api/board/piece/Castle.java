package me.jamesattfield.chessengine.api.board.piece;

import me.jamesattfield.chessengine.api.board.ChessBoard;
import me.jamesattfield.chessengine.api.board.location.Coordinate;
import me.jamesattfield.chessengine.api.board.location.Vector2D;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Castle extends GamePiece {

    public Castle(PieceColour colour) {
        super(colour);
    }

    @Override
    public Collection<Coordinate> validMoveLocations(Coordinate currentLocation, ChessBoard chessBoard) {
        List<Coordinate> coordinates = new ArrayList<>();

        Vector2D pieceLoc = currentLocation.getVector2D();

        for (int x = pieceLoc.getX(); x < 8; x++){
            Coordinate newLoc = new Coordinate(new Vector2D(x, pieceLoc.getY()));
            coordinates.add(newLoc);
            if (chessBoard.getPieceAt(newLoc).isPresent())
                break;
        }

        for (int x = pieceLoc.getX(); x > -1; x --){
            Coordinate newLoc = new Coordinate(new Vector2D(x, pieceLoc.getY()));
            coordinates.add(newLoc);
            if (chessBoard.getPieceAt(newLoc).isPresent())
                break;
        }

        for (int y = pieceLoc.getY(); y < 8; y++){
            Coordinate newLoc = new Coordinate(new Vector2D(pieceLoc.getX(), y));
            coordinates.add(newLoc);
            if (chessBoard.getPieceAt(newLoc).isPresent())
                break;
        }

        for (int y = pieceLoc.getY(); y > -1; y--){
            Coordinate newLoc = new Coordinate(new Vector2D(pieceLoc.getX(), y));
            coordinates.add(newLoc);
            if (chessBoard.getPieceAt(newLoc).isPresent())
                break;
        }

        return coordinates;
    }

    @Override
    public char getIcon() {
        return getPieceColour() == PieceColour.WHITE ? '♖' : '♜';
    }
}
