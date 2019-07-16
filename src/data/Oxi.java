package data;

public class Oxi {
    public Atom atom;
    public double minus;
    public int oxidation;
    public int number;

    public boolean isAccurate = true;

    public Oxi(Atom atom, double minus, int oxidation, int number) {
        this.atom = atom;
        this.minus = minus;
        this.oxidation = oxidation;
        this.number = number;
    }

    public String toString() {
        return atom + " 산화수 : " + oxidation + " 원자번호 : " + number + " 전기음성도 : " + minus;
    }
}
