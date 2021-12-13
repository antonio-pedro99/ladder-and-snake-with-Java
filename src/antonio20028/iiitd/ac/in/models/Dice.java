    package antonio20028.iiitd.ac.in.models;

    import java.util.Random;

    public class Dice {
        private int nFaces;
        private int currentFace;

        public Dice(int nFaces) {
            this.nFaces = nFaces;
        }

        public void roll() {
            setCurrentFace(1 + new Random().nextInt(nFaces));
        }

        private void setCurrentFace(int value) {
            this.currentFace = (value <= nFaces) ? value : this.currentFace;
        }

        public int getCurrentFace() {
            return currentFace;
        }

        public int getnFaces() {
            return nFaces;
        }

    }
