package fr.checkers;

public enum Team {
    BLACK(1, 9),
    WHITE(-1, 0);

    private final int forwardDirection;
    private final int promotionRow;

    Team(int direction, int promotionRow) {
        this.forwardDirection = direction;
        this.promotionRow = promotionRow;
    }

    public int getForwardDirection() {
        return this.forwardDirection;
    }

    public int getPromotionRow() {
        return this.promotionRow;
    }
}
