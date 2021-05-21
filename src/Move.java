import java.awt.*;

public class Move {

    private Position from;
    private Position to;
    private boolean capture;
    private Position capturePosition;

    public Move(Position from, Position to) {
        this.from = from;
        this.to = to;
        this.capture = false;
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
