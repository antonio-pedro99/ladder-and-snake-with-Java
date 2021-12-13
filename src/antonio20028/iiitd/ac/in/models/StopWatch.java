    package antonio20028.iiitd.ac.in.models;

    public class StopWatch {
        private long startTime;
        private long endTime;
        private float elapsedTime;

        private String minutes;
        private String seconds;
        private String hours;

        public void reset() {
            this.startTime = 0;
            this.endTime = 0;
            this.hours = "0";
            this.minutes = "0";
            this.seconds = "0";
        }

        public void startCount() {
            this.startTime = System.currentTimeMillis();
        }

        public void stopCount() {
            this.endTime = System.currentTimeMillis();
            this.elapsedTime = (float) (this.endTime - this.startTime)/1000F;
        }

        public String getTotalTime() {

            this.seconds = Integer.toString((int) (this.elapsedTime % 60));
            this.minutes = Integer.toString((int) ((this.elapsedTime % 3600) / 60));
            this.hours = Integer.toString((int) (this.elapsedTime / 3600));

            hours = (hours.length() < 2) ? "0" + hours : "00";
            minutes = (minutes.length() < 2) ? "0" + minutes: "00";
            seconds = (seconds.length() < 2) ? "0" + seconds : seconds;

            return hours + ":" + minutes + ":" + seconds;
        }
    }
