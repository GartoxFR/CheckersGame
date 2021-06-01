package fr.checkers;

import java.awt.Color;

public enum Team {
    BLACK(1, 9, "Noires",  new Color(55, 55, 55)),
    WHITE(-1, 0, "Blancs", new Color(200, 200, 200));

    private final int forwardDirection;
    private final int promotionRow;
    private final String displayName;
    private final Color displayColor;

    Team(int direction, int promotionRow, String displayName, Color displayColor) {
        this.forwardDirection = direction;
        this.promotionRow = promotionRow;
        this.displayName = displayName;
        this.displayColor = displayColor;
    }

    public int getForwardDirection() {
        return this.forwardDirection;
    }

    public int getPromotionRow() {
        return this.promotionRow;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Color getDisplayColor() {
        return this.displayColor;
    }
}
