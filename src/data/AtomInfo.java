package data;

import java.util.HashMap;
import java.util.Map;

public class AtomInfo {
    private String name;
    private int number;
    private int mass;

    private static Map<String, AtomInfo> atoms;

    private AtomInfo(String name, int number, int mass) {
        this.name = name;
        this.number = number;
        this.mass = mass;
    }

    static {
        atoms = new HashMap<>();
        atoms.put(null, new AtomInfo(null, 0, 0));
        atoms.put("H", new AtomInfo("H", 1, 1));
        atoms.put("He", new AtomInfo("He", 2, 4));
        atoms.put("Li", new AtomInfo("Li", 3, 7));
        atoms.put("Be", new AtomInfo("Be", 4, 9));
        atoms.put("B", new AtomInfo("B", 5, 11));
        atoms.put("C", new AtomInfo("C", 6, 12));
        atoms.put("N", new AtomInfo("N", 7, 14));
        atoms.put("O", new AtomInfo("O", 8, 16));
        atoms.put("F", new AtomInfo("F", 9, 19));
        atoms.put("Ne", new AtomInfo("Ne", 10, 20));
        atoms.put("Na", new AtomInfo("Na", 11, 23));
        atoms.put("Mg", new AtomInfo("Mg", 12, 24));
        atoms.put("Al", new AtomInfo("Al", 13, 27));
        atoms.put("Si", new AtomInfo("Si", 14, 28));
        atoms.put("P", new AtomInfo("P", 15, 31));
        atoms.put("S", new AtomInfo("S", 16, 32));
        atoms.put("Cl", new AtomInfo("Cl", 17, 35));
        atoms.put("Ar", new AtomInfo("Ar", 18, 40));
        atoms.put("K", new AtomInfo("K", 19, 39));
        atoms.put("Ca", new AtomInfo("Ca", 20, 40));
    }

    public static Map<String, AtomInfo> getAtoms() {
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
