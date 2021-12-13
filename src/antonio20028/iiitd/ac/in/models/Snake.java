package antonio20028.iiitd.ac.in.models;

abstract class Snake extends Floor {

    private final int positionWorth;

    public Snake(int position, int positionWorth, int pointWorth) {
        super(position, pointWorth);
        this.positionWorth = positionWorth;
    }

    @Override
    public int getPosition() {
        return super.getPosition();
    }


    @Override
    public void showPlayerPosition(Player player, String floor) {
        super.showPlayerPosition(player, floor);
        System.out.println("Player position Floor-" + player.getPosition());
    }

    public void decreasePlayerPosition(Player player) {
        player.decreasePosition(positionWorth);
    }

    public void decreasePlayerPoint(Player player) {
        player.decreasePoint(super.getPointWorth());
    }


}
