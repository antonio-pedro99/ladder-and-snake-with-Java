    package antonio20028.iiitd.ac.in.models;

    public class Player {
        private String name;
        private int point;
        private int position;

        public Player(String name) {
            this.name = name;
            this.point = 0;
            this.position = 0;
        }

        public String getName() {
            return name;
        }

        public int getPoint() {
            return point;
        }

        public int getPosition() {
            return position;
        }

        public boolean canMove(int position, int _currentFace) {
            return (position != 12 || _currentFace != 2);
        }
        public void losePoint(Snake snake) {
            snake.decreasePlayerPoint(this);
            snake.decreasePlayerPosition(this);//polymorphism
        }
       public void rollDice(Dice dice) {
             dice.roll();
       }
       public void increasePosition(int value) {
            this.position = this.position + value;
       }
       public void increasePoint(int value) {
            this.point = this.point + value;
       }
       public void decreasePoint(int value) {
            this.point = this.point - value;
       }
       public void decreasePosition(int value) {
            this.position = this.position - value;
       }

    }
