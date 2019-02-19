package me.jamesattfield.chessengine.api.game;

import me.jamesattfield.chessengine.api.board.piece.PieceColour;

public class Player {
    private PieceColour pieceColour;

    public Player(PieceColour pieceColour){
        this.pieceColour = pieceColour;
    }

    public PieceColour getPieceColour() {
        return pieceColour;
    }
}
