package fr.checkers;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Piece {

    private static final int SIZE = 60;
    private static BufferedImage CROWN;

    static {
        try {
            Piece.CROWN = ImageIO.read(new File("assets/crown.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final Team team;
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

    public void draw(Graphics g, int x, int y) {
        g.setColor(this.team.getDisplayColor());

        g.fillOval(x + 6, y + 6, Piece.SIZE, Piece.SIZE);

        if (this.isQueen()) {
            g.drawImage(Piece.CROWN, x + 6, y + 6, null);
        }
    }
}