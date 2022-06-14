public class Board {

    private Box[][] boxes;
    public static final int ROWS = 3;
    public static final int COLS = 3;

    private Position currentPosition;// pozita ku eshte luajtur se fundmi

    public Board() {
        boxes = new Box[ROWS][COLS];
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                boxes[row][col] = new Box();
            }

        }
    }

    public boolean hasEmptyBoxes() {

        for (Box[] rowBox : boxes) {
            for (Box box : rowBox) {
                if (box.isEmpty()) {
                    return true;
                }

            }
        }
        return false;

    }

    public boolean isValidPosition(Position position) {
        return getBox(position).isEmpty();
    }

    public boolean checkWinner(Player player) {
        boolean winner = isWinnerInRow(player) || isWinnerInCol(player);

        if (currentPosition.getX() == currentPosition.getY()) {
            winner = winner || isWinnerIn1stDiagonal(player);
        }
        if (currentPosition.getX() + currentPosition.getY() == 2) {

            winner = winner || isWinnerIn2ndDiagonal(player);
        }
        return winner;

    }

    private boolean isWinnerInRow(Player p) {
        int rowNumber = currentPosition.getX();
        Box firstBox = getBox(rowNumber, 0);
        Box secondBox = getBox(rowNumber, 1);
        Box thirdBox = getBox(rowNumber, 2);
        return firstBox.getPlayer().equals(p) && secondBox.getPlayer().equals(p) && thirdBox.getPlayer().equals(p);
    }

    private boolean isWinnerInCol(Player p) {
        int colNumber = currentPosition.getY();
        Box firstBox = getBox(0, colNumber);
        Box secondBox = getBox(1, colNumber);
        Box thirdBox = getBox(2, colNumber);
        return firstBox.getPlayer().equals(p) && secondBox.getPlayer().equals(p) && thirdBox.getPlayer().equals(p);
    }

    private boolean isWinnerIn1stDiagonal(Player p) {
        Box firstBox = getBox(0, 0);
        Box secondBox = getBox(1, 1);
        Box thirdBox = getBox(2, 2);
        return firstBox.getPlayer().equals(p) && secondBox.getPlayer().equals(p) && thirdBox.getPlayer().equals(p);
    }

    private boolean isWinnerIn2ndDiagonal(Player p) {
        Box firstBox = getBox(0, 2);
        Box secondBox = getBox(1, 1);
        Box thirdBox = getBox(2, 0);
        return firstBox.getPlayer().equals(p) && secondBox.getPlayer().equals(p) && thirdBox.getPlayer().equals(p);

    }

    public void reset() {
        for (int rreshti = 0; rreshti < ROWS; rreshti++) {
            for (int shtylla = 0; shtylla < COLS; shtylla++) {
                boxes[rreshti][shtylla].clear();
            }

        }
    }

    public Box getBox(Position pozita) {
        return boxes[pozita.getX()][pozita.getY()];
    }

    public Box getBox(int x, int y) {
        Position temp = new Position(x, y);
        return getBox(temp);
    }

    public void updatePosition(Player player, Position position) {
        getBox(position).setPlayer(player);
        this.currentPosition = position;
    }

    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder("");
        for (int row = 0; row < ROWS; row++) {

            for (int col = 0; col < COLS; col++) {
                Box box = boxes[row][col];
                if (box.isEmpty()) {
                    boardString.append(" ");
                } else {
                    boardString.append(" " + box + " ");
                } // nese eshte kolona e fundit mos e shtyp
                 if (col < boxes[row].length - 1) { boardString.append("|"); }

            }
            boardString.append("\n");
            if (row < boxes.length - 1) {

                boardString.append("-----------");

                boardString.append("\n");
            }

        }
        boardString.append("\n");
        return boardString.toString();

    }

    public static boolean areInsideBounds(int xPosition, int yPosition) {

        return xPosition >= 0 && xPosition <= ROWS && yPosition >= 0 && yPosition <= COLS;

    }

    public static boolean isInsideBounds(int oneDimPosition) {
        return oneDimPosition >= 0 && oneDimPosition < 9;

    }

}