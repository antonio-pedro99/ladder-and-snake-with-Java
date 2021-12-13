package antonio20028.iiitd.ac.in.models;

public class Record {
    private String player;
    private int point;
    private String time;

    public Record(String player , int point, String time) {
        this.player = player;
        this.point = point;
        this.time = time;
    }

    public String getPlayer() {
        return player;
    }

    public int getPoint() {
        return point;
    }

    public String getTime() {
        return time;
    }
}
