package me.jamesattfield.chessengine.api.board.piece;

import me.jamesattfield.chessengine.api.board.ChessBoard;
import me.jamesattfield.chessengine.api.board.location.Coordinate;
import me.jamesattfield.chessengine.api.board.location.Vector2D;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Bishop extends GamePiece {

    public Bishop(PieceColour colour) {
        super(colour);
    }

    @Override
    public Collection<Coordinate> validMoveLocations(Coordinate currentLocation, ChessBoard chessBoard){
        List<Coordinate> coordinates = new ArrayList<>();

        Coordinate coordinateInQuestion = currentLocation;
        for (int ur = 0; ur < 8; ur ++){
            coordinateInQuestion = coordinateInQuestion.add(new Vector2D(1, 1));
            coordinates.add(coordinateInQuestion);
            if (chessBoard.getPieceAt(coordinateInQuestion).isPresent()){
                break;
            }
        }

        for (int ul = 0; ul < 8; ul ++){
            coordinateInQuestion = coordinateInQuestion.add(new Vector2D(-1, 1));
            coordinates.add(coordinateInQuestion);
            if (chessBoard.getPieceAt(coordinateInQuestion).isPresent()){
                break;
            }
        }

        for (int dl = 0; dl < 8; dl ++){
            coordinateInQuestion = coordinateInQuestion.add(new Vector2D(-1, -1));
            coordinates.add(coordinateInQuestion);
            if (chessBoard.getPieceAt(coordinateInQuestion).isPresent()){
                break;
            }
        }

        for (int dr = 0; dr < 8; dr ++){
            coordinateInQuestion = coordinateInQuestion.add(new Vector2D(1, -1));
            coordinates.add(coordinateInQuestion);
            if (chessBoard.getPieceAt(coordinateInQuestion).isPresent()){
                break;
            }
        }

        return coordinates;
    }

    @Override
    public char getIcon() {
        return getPieceColour() == PieceColour.WHITE ? '♗' : '♝';
    }
}
