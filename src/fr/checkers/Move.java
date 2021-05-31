package fr.checkers;

public class Move {

    private final Position from;
    private final Position to;
    private final boolean capture;
    private final Position capturePosition;

    public Move(Position from, Position to) {
        this.from = from;
        this.to = to;
        this.capture = false;
        this.capturePosition = null;
    }

    public Move(Position from, Position to, Position toCapture) {
        this.from = from;
        this.to = to;
        this.capturePosition = toCapture;
        this.capture = true;
    }

    public Position getFrom() {
        return this.from;
    }

    public Position getTo() {
        return this.to;
    }

    public boolean isCapture() {
        return this.capture;
    }

    public Position getCapturePosition() {
        return this.capturePosition;
    }


}
