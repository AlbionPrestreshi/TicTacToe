public class Box {
    private Player player;

    public void clear() {
        player = null;
    }

    public boolean isEmpty() {
        return player == null;
    }

    public Player getPlayer() {
        if (isEmpty()) {
            return new Player(' ');
        }
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String toString() {
        return player.toString();
    }

}