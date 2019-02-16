package me.jamesattfield.chessengine.api.board.location;

public class InvalidCoordinateException extends Exception {
    public InvalidCoordinateException(String message){
        super(message);
    }
}
