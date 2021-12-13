    package antonio20028.iiitd.ac.in.models;

    public class NormalFloor extends Floor {

        public NormalFloor(int position, int pointWorth) {
            super(position, pointWorth);
        }

        public void increasePlayerPoint(Player player) {
            player.increasePoint(super.getPointWorth());
        }

        @Override
        public int getPosition() {
            return super.getPosition();
        }

        @Override
        public void showPlayerPosition(Player player, String floor) {
            super.showPlayerPosition(player, floor);
        }
    }
