import java.awt.*;

public class Piece {

    private Team team;
    private boolean queen;

    public Piece(Team team) {
        this.team = team;
        this.queen = false;
    }

    public Team getTeam() {
        return this.team;
    }

    public boolean isQueen() {
        return this.queen;
    }

    public void setQueen(boolean queen) {
        this.queen = queen;
    }

    public void draw(Graphics g) {

    }
}
