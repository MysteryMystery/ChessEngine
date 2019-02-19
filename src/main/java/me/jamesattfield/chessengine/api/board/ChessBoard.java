package me.jamesattfield.chessengine.api.board;

import me.jamesattfield.chessengine.api.board.location.Coordinate;
import me.jamesattfield.chessengine.api.board.location.Vector2D;
import me.jamesattfield.chessengine.api.board.piece.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChessBoard {
    private GamePiece[][] board = new GamePiece[8][8];
    private List<GamePiece> takenPieces = new ArrayList<>();
    private ChessBoardEvaluator evaluator;

    public ChessBoard(){
        setupBoard();
        evaluator = new ChessBoardEvaluator(this);
    }

    public ChessBoardEvaluator getEvaluator() {
        return evaluator;
    }

    public Optional<GamePiece> getPieceAt(Coordinate coordinate){
        GamePiece gamePiece = board[coordinate.getVector2D().getX()][coordinate.getVector2D().getY()];
        return gamePiece == null ? Optional.empty() : Optional.of(gamePiece);
    }

    public boolean isOccupied(Coordinate coordinate){
        return getPieceAt(coordinate).isPresent();
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

    public void movePiece(Coordinate from, Coordinate to) throws Exception{
        Optional<GamePiece> gamePieceOptional = getPieceAt(from);
        if (!gamePieceOptional.isPresent())
            throw new Exception("Coordinate " + from.toString() + " contains no chess piece.");

        GamePiece gamePiece = gamePieceOptional.get();
        if (gamePiece.canMoveTo(from, to, this)){
            board[from.getVector2D().getX()][from.getVector2D().getY()] = null;
            board[to.getVector2D().getX()][to.getVector2D().getY()] = gamePiece;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i ++){
            for (int j = 0; j < 8; j ++)
                sb.append(board[i][j] == null ? " " : board[i][j]);
            sb.append("\n");
        }
        return sb.toString();
    }

    public GamePiece[][] getBoard() {
        return board;
    }

    public Map<GamePiece, Coordinate> getOccupiedCells(){
        Map<GamePiece, Coordinate> cells = new HashMap<>();
        for (int i = 0; i < 8; i ++){
            for (int j = 0; j < 8; j ++){
                GamePiece gamePiece = board[i][j];
                if (gamePiece != null)
                    try {
                        cells.put(gamePiece, new Coordinate(new Vector2D(i, j)));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
            }
        }
        return cells;
    }

    public Collection<GamePiece> getPieces(){
        return getOccupiedCells().keySet();
    }

    public Stream<GamePiece> getPieces(PieceColour pieceColour){
        return  getPieces().stream().filter(p -> p.getPieceColour() == pieceColour);
    }

    public List<GamePiece> getTakenPieces() {
        return takenPieces;
    }

    public Stream<GamePiece> getTakenPieces(PieceColour pieceColour){
        return getTakenPieces().stream().filter(p -> p.getPieceColour() == pieceColour);
    }
}
