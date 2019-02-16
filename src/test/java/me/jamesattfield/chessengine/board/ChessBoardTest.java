package me.jamesattfield.chessengine.board;

import me.jamesattfield.chessengine.api.board.ChessBoard;
import me.jamesattfield.chessengine.api.board.location.Coordinate;
import me.jamesattfield.chessengine.api.board.piece.GamePiece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChessBoardTest {

    ChessBoard chessBoard = new ChessBoard();

    @Test
    public void testInitialBoardLayout(){
        assertEquals(1, 1);
    }

    @Test
    public void testPawnMove(){
        chessBoard = new ChessBoard();
        try {
            GamePiece gamePiece = chessBoard.getPieceAt(new Coordinate(1, 1)).get();
            assertTrue(gamePiece.canMoveTo(new Coordinate(1, 1), new Coordinate(1, 2), chessBoard));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
