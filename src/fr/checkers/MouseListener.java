package fr.checkers;

import java.awt.event.MouseEvent;

public class MouseListener implements java.awt.event.MouseListener {

    private Board board;

    public MouseListener(Board board) {

        this.board = board;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX() / 72;
        int y = e.getY() / 72;
        this.board.onClick(x, y);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
