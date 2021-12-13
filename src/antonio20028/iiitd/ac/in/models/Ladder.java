    package antonio20028.iiitd.ac.in.models;

    abstract class Ladder extends Floor {
        private int positionWorth;

        public Ladder(int position, int positionWorth, int pointWorth) {
            super(position, pointWorth);
            this.positionWorth = positionWorth;
        }

        public void increasePlayerPoint(Player player) {
            player.increasePoint(super.getPointWorth());
        }

        public void increasePlayerPosition(Player player) {
            player.increasePosition(positionWorth);
        }

        @Override
        public int getPosition() {
            return super.getPosition();
        }

        @Override
        public int getPointWorth() {
            return super.getPointWorth();
        }

        @Override
        public void showPlayerPosition(Player player, String floor) {
            super.showPlayerPosition(player, floor);
            System.out.println("Player position Floor-" + player.getPosition());
        }
    }
