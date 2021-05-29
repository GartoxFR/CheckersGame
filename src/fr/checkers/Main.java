package fr.checkers;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        Main.mainLoop(board, new Display(board));
    }

    public static void mainLoop(Board board, Display display) {
        while (true) {
            board.update();
            display.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
