package me.jamesattfield.chessengine.api.board;

import me.jamesattfield.chessengine.api.board.piece.*;

public class ChessBoard {
    private GamePiece[][] board = new GamePiece[8][8];

    public ChessBoard(){
        setupBoard();
    }

    private void setupBoard(){
        for (int i = 0; i < 8; i ++){
            board[1][i] = new Pawn(PieceColour.WHITE);
            board[6][i] = new Pawn(PieceColour.BLACK);
        }

        board[0][0] = new Castle(PieceColour.WHITE);
        board[0][1] = new Knight(PieceColour.WHITE);
        board[0][2] = new Bishop(PieceColour.WHITE);
        board[0][3] = new King(PieceColour.WHITE);
        board[0][4] = new Queen(PieceColour.WHITE);
        board[0][5] = new Bishop(PieceColour.WHITE);
        board[0][6] = new Knight(PieceColour.WHITE);
        board[0][7] = new Castle(PieceColour.WHITE);

        board[7][0] = new Castle(PieceColour.BLACK);
        board[7][1] = new Knight(PieceColour.BLACK);
        board[7][2] = new Bishop(PieceColour.BLACK);
        board[7][3] = new King(PieceColour.BLACK);
        board[7][4] = new Queen(PieceColour.BLACK);
        board[7][5] = new Bishop(PieceColour.BLACK);
        board[7][6] = new Knight(PieceColour.BLACK);
        board[7][7] = new Castle(PieceColour.BLACK);
    }

    public void cliPrint(){
        for (int i = 0; i < 8; i ++){
            for (int j = 0; j < 8; j ++)
                System.out.print(board[i][j] == null ? " " : board[i][j]);
            System.out.println();
        }
    }
}
