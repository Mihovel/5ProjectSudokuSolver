import java.util.List;

public class EntidyList {
    public EntidyList(List<String> possiblePoints, int i, int j) {
        this.possiblePoints = possiblePoints;
        this.i = i;
        this.j = j;
    }

    private List<String> possiblePoints;
    private int i;
    private int j;

    public List<String> getPossiblePoints() {
        return possiblePoints;
    }

    public void setPossiblePoints(List<String> possiblePoints) {
        this.possiblePoints = possiblePoints;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
