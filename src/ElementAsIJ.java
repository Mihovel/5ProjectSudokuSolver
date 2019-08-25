public class ElementAsIJ {
    int i;
    int j;

    public ElementAsIJ(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {return i;}
    public int getJ() {return j;}
    @Override
    public String toString() { return "{i=" + i + ", j=" + j + "}"; }
}
