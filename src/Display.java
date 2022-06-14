import java.util.Scanner;

public class Display {

    private Scanner in;

    public Display() {
        in = new Scanner(System.in);
    }

    public void showMessage(String s) {
        System.out.print(s);
    }

    public void showResult(Player player) {
        if (player != null) {
            showMessage("Fitoi " + player + "\n");

        } else {
            showMessage("Nuk ka fitues kesaj rradhe.");

        }

        showMessage("=======================================\n");
    }

    public Position readPosition(Player player) {
        Position position = null;

        int oneDimPosition;
        boolean validInput;
        do {

            showMessage("'" + player + "', sheno poziten ku luan: ");
            oneDimPosition = in.nextInt();
            oneDimPosition--;

            in.nextLine();
            if (validInput = Board.isInsideBounds(oneDimPosition)) {

                position = new Position();
                position.setCoordinateFromPosition(oneDimPosition);

            } else {
                showMessage("Pozita jasht rangut!!\n");

            }
        } while (!validInput);
        return position;

    }

    public boolean wantsToPlayMore() {

        boolean vazhdo = true;// flag
        String line;
        do {
            showMessage("Deshiron te luash prap (Y/N)?\n");
            line = in.nextLine();

            if (line.length() > 0) {
                line = line.substring(0, 1);
                if (line.equalsIgnoreCase("Y") || line.equalsIgnoreCase("N")) {
                    vazhdo = false;
                } else {
                    showMessage("Hyrja eshte gabim sheno Y ose N!!\n");
                }

            }
        } while (vazhdo);
        return line.equalsIgnoreCase("Y");

    }

}
