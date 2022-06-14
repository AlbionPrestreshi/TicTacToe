public class Game {

    private Board board;
    private Display ui;
    private Player[] players = new Player[2];
    private Player currentPlayer;
    private Player winner;
    private int turn = 0;

    public Game(Player[] players) {
        board = new Board();
        ui = new Display();

        ui.showMessage(board.toString());
        this.players = players;

    }

    public void play() {

        boolean wantsToPlay = true;
        while (wantsToPlay) {

            do {
                currentPlayer = currentPlayer();
                Position newPosition = ui.readPosition(currentPlayer);
                if (board.isValidPosition(newPosition)) {
                    board.updatePosition(currentPlayer, newPosition);
                    ui.showMessage(board.toString());
                    if (board.checkWinner(currentPlayer)) {
                        winner = currentPlayer;
                    }
                    switchTurn();// edhe nese ka fitues, nderro rradhen
                } else {
                    ui.showMessage("Pozite jo valide!!!");
                }

            }
            while (notOver());

            ui.showResult(winner);

            wantsToPlay = ui.wantsToPlayMore();

            if (wantsToPlay) {
                reset();

            }

        }

    }

    public void reset() {
        board.reset();
        ui.showMessage(board.toString());
        winner = null;
    }

    public boolean notOver() {
        return winner == null && board.hasEmptyBoxes();
    }

    private void switchTurn() {
        turn = 1 - turn;
    }

    private Player currentPlayer() {
        return players[turn];
    }

    public static void main(String[] args) {

        Player[] players = {new Player('X'), new Player('O')};

        Game tictactoe = new Game(players);
        tictactoe.play();

    }

}
