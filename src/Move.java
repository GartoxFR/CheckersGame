import java.awt.*;

public class Move {

    private Position from;
    private Position to;
    private boolean capture;

    public Move(Position from, Position to, boolean capture) {
        this.from = from;
        this.to = to;
        this.capture = capture;
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

    public void draw(Graphics g) {

    }

}
