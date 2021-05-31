package fr.checkers;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        Main.mainLoop(new Display(board));
    }

    private static void mainLoop(Display display) {
        while (true) {
            display.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
