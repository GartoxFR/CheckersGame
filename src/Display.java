import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Graphics;

public class Display extends JPanel {

    private final int BOARD_SIZE = 10;
    private final int FRAME_SIZE = 720;
    private final int CELL_SIZE = this.FRAME_SIZE / this.BOARD_SIZE;

    private Board board;

    public Display(Board board) {
        this.board = board;
        JFrame frame = new JFrame("Jeu de dame");
        frame.setSize(this.FRAME_SIZE + 14, this.FRAME_SIZE + 34);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(this);
        this.addMouseListener(new MouseListener(board));
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            for (int j = 0; j < this.BOARD_SIZE; j++) {
                if ((i + j) % 2 == 0) {
                    g.setColor(new Color(23, 96, 153));
                } else {
                    g.setColor(new Color(144, 213, 189));
                }

                g.fillRect(i * this.CELL_SIZE, j * this.CELL_SIZE, this.CELL_SIZE, this.CELL_SIZE);
            }
        }

        this.board.draw(g);
    }
}
