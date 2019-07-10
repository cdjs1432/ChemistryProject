package data;

import java.util.HashMap;
import java.util.Map;

public class Atom {
    private String name;
    private int number;
    private int mass;

    private static Map<String, Atom> atoms;

    private Atom(String name, int number, int mass) {
        this.name = name;
        this.number = number;
        this.mass = mass;
    }

    static {
        atoms = new HashMap<>();
        atoms.put(null, new Atom(null, 0, 0));
        atoms.put("H", new Atom("H", 1, 1));
        atoms.put("He", new Atom("He", 2, 4));
        atoms.put("Li", new Atom("Li", 3, 7));
        atoms.put("Be", new Atom("Be", 4, 9));
        atoms.put("B", new Atom("B", 5, 11));
        atoms.put("C", new Atom("C", 6, 12));
        atoms.put("N", new Atom("N", 7, 14));
        atoms.put("O", new Atom("O", 8, 16));
        atoms.put("F", new Atom("F", 9, 19));
        atoms.put("Ne", new Atom("Ne", 10, 20));
        atoms.put("Na", new Atom("Na", 11, 23));
        atoms.put("Mg", new Atom("Mg", 12, 24));
        atoms.put("Al", new Atom("Al", 13, 27));
        atoms.put("Si", new Atom("Si", 14, 28));
        atoms.put("P", new Atom("P", 15, 31));
        atoms.put("S", new Atom("S", 16, 32));
        atoms.put("Cl", new Atom("Cl", 17, 35));
        atoms.put("Ar", new Atom("Ar", 18, 40));
        atoms.put("K", new Atom("K", 19, 39));
        atoms.put("Ca", new Atom("Ca", 20, 40));
    }

    public static Map<String, Atom> getAtoms() {
        return atoms;
    }

    public static int getMassByString(String name) {
        return atoms.get(name).getMass();
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getMass() {
        return mass;
    }

}
