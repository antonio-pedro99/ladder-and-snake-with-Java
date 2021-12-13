package antonio20028.iiitd.ac.in.models;

abstract class Floor {
    private final int position;
    private int pointWorth;

    public Floor(int position, int pointWorth) {
        this.position = position;
        this.pointWorth = pointWorth;
    }

    public int getPosition() {
        return position;
    }

    public int getPointWorth() {
        return pointWorth;
    }

    public void showPlayerPosition(Player player, String floor) {
        System.out.println(player.getName() + " has reached " + floor);
    }
}
