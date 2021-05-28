
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    private Piece[][] pieces = new Piece[10][10];
    private List<Move> possibleMoves = new ArrayList<>();
    private Team toPlay = Team.WHITE;
    private Position selectedPiece;
    private boolean color;

    public Board() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < this.pieces.length; j++) {
                if ((i + j) % 2 == 0) {
                    this.pieces[i][j] = new Piece(Team.BLACK);
                } else {
                    this.pieces[9-i][j] = new Piece(Team.WHITE);
                }
            }
        }
        this.computePossibleMoves();
    }

    public void computePossibleMoves() {
        boolean capturePossible = false;
        this.possibleMoves.clear();
        int dir = this.toPlay == Team.BLACK ? 1 : -1;
        for (int i = 0; i < this.pieces.length ; i++) {
            for (int j = 0; j < this.pieces[i].length; j++) {
                if (this.pieces[i][j] != null && this.pieces[i][j].getTeam() == this.toPlay) {
                    Position from = new Position(j, i);
                    if(this.addPiecePossibleMoves(from, dir)) {
                        capturePossible = true;
                    }
                }
            }
        }
        if (capturePossible) {
            this.possibleMoves = this.possibleMoves.stream().filter(Move::isCapture).collect(Collectors.toList());
        }
        System.out.println(this.possibleMoves.size());
        //TODO Compute possible moves and store them in possibleMoves
    }

    public boolean addPiecePossibleMoves(Position from, int dir) {
        boolean capturePossible = false;
        for (int i = -1; i <= 1; i += 2) {
            Position to = new Position(from.getX() + i, from.getY() + dir);
            if (!this.isInBoard(to)) {
                continue;
            }

            if (this.getPiece(to) == null) {
                this.possibleMoves.add(new Move(from, to));
            } else if (this.getPiece(to).getTeam() != this.toPlay) {
                if (this.addCapturePossibleMove(from, to)) {
                    capturePossible = true;
                }
            }

            to = new Position(from.getX() + i, from.getY() - dir);
            if (!this.isInBoard(to)) {
                continue;
            }
            if (this.getPiece(to) != null && this.getPiece(to).getTeam() != this.toPlay){
                if(this.addCapturePossibleMove(from, to)){
                    capturePossible = true;
                }
            }
        }
        return capturePossible;
    }

    private boolean addCapturePossibleMove(Position from, Position capture) {
        Position to = new Position(from.getX() + (capture.getX() - from.getX()) * 2, from.getY() + (capture.getY() - from.getY()) * 2);
        if (!this.isInBoard(to) || this.getPiece(to) != null) {
            return false;
        }
        this.possibleMoves.add(new Move(from, to, capture));
        return true;
    }

    public Piece getPiece(Position position) {
        return this.pieces[position.getY()][position.getX()];
    }

    public void setPiece(Position position, Piece piece) {
        this.pieces[position.getY()][position.getX()] = piece;
    }

    public boolean isInBoard(Position position) {
        return position.getX() >= 0 && position.getX() <= 9 && position.getY() >= 0 && position.getY() <= 9;
    }

    public void draw(Graphics g) {
        for (int i = 0; i < this.pieces.length; i++) {
            for (int j = 0; j < this.pieces[i].length; j++) {
                if (this.pieces[j][i] != null) {
                    this.pieces[j][i].draw(g, i * 72, j * 72);
                }
            }
        }

        if (this.selectedPiece == null) {
            return;
        }

        for (Move possibleMove : this.possibleMoves) {
            if (possibleMove.getFrom().equals(this.selectedPiece)) {
                int x = possibleMove.getTo().getX();
                int y = possibleMove.getTo().getY();

                g.setColor(new Color(38, 177, 38));
                g.fillOval(x * 72 + 16, y * 72 + 16, 40, 40);
            }
        }
    }

    public void update() {
    }

    public void onClick(int x, int y) {

        Piece clicked = this.pieces[y][x];
        if (clicked != null && clicked.getTeam() == this.toPlay) {
            this.selectedPiece = new Position(x, y);
            return;
        }

        if (clicked == null) {
            for (Move possibleMove : this.possibleMoves) {
                if (possibleMove.getFrom().equals(this.selectedPiece) && possibleMove.getTo().equals(new Position(x, y))) {
                    this.playMove(possibleMove);
                    return;
                }
            }
            this.selectedPiece = null;
        }
    }

    private void playMove(Move move) {
        Piece piece = this.getPiece(move.getFrom());
        this.setPiece(move.getFrom(), null );
        this.setPiece(move.getTo(), piece );
        if (move.isCapture()) {
            this.setPiece(move.getCapturePosition(), null);
        }

        this.toPlay = this.toPlay == Team.WHITE ? Team.BLACK : Team.WHITE;
        this.computePossibleMoves();
        this.selectedPiece = null;
    }
}
