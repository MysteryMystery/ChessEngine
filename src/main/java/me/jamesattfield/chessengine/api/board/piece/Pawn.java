package me.jamesattfield.chessengine.api.board.piece;

import me.jamesattfield.chessengine.api.board.ChessBoard;
import me.jamesattfield.chessengine.api.board.location.Coordinate;
import me.jamesattfield.chessengine.api.board.location.Vector2D;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
                    locations.add(currentLocation.add(new Vector2D(0, 2)));
                locations.add(currentLocation.add(new Vector2D(0, 1)));
                if (canTake(currentLocation.add(new Vector2D(1, 1)), chessBoard))
                    locations.add(currentLocation.add(new Vector2D(1, 1)));
                if (canTake(currentLocation.add(new Vector2D(-1, 1)), chessBoard))
                    locations.add(currentLocation.add(new Vector2D(-1, 1)));
            }else {
                if (notYetMoved)
                    locations.add(currentLocation.subtract(new Vector2D(0, 2)));
                locations.add(currentLocation.subtract(new Vector2D(0, 1)));
                if (canTake(currentLocation.add(new Vector2D(1, -1)), chessBoard))
                    locations.add(currentLocation.add(new Vector2D(1, -1)));
                if (canTake(currentLocation.add(new Vector2D(-1, -1)), chessBoard))
                    locations.add(currentLocation.add(new Vector2D(-1, -1)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return locations;
    }

    private boolean canTake(Coordinate coordinate, ChessBoard chessBoard){
        Optional<GamePiece> cell = chessBoard.getPieceAt(coordinate);
        return cell.isPresent() && getPieceColour() != cell.get().getPieceColour();
    }

    @Override
    public char getIcon() {
        return getPieceColour() == PieceColour.WHITE ? '♙' : '♟';
    }
}
