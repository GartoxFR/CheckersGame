
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private Piece[][] pieces = new Piece[10][10];
    private List<Move> possibleMoves = new ArrayList<>();
    private Team toPlay;

    public void computePossibleMoves() {
        //TODO Compute possible moves and store them in possibleMoves
    }

    public void draw(Graphics g) {

    }
}
