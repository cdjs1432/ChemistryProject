package data;

import java.util.HashMap;
import java.util.Map;

public class ElectroneGativity {

    private static Map<String, Double> atoms;

    public static double getOxygenBySymbol(String symbol) {
        try {
            return atoms.get(symbol);
        } catch(Throwable t) {
            return 0.0;
        }

    }

    static {
        atoms = new HashMap<>();

        atoms.put("H", 2.20);
        atoms.put("Li", 0.98);
        atoms.put("Be", 1.57);
        atoms.put("B", 2.04);
        atoms.put("C", 2.55);
        atoms.put("N", 3.04);
        atoms.put("O", 3.44);
        atoms.put("F", 3.98);
        atoms.put("Na", 0.93);
        atoms.put("Mg", 1.31);
        atoms.put("Al", 1.61);
        atoms.put("Si", 1.90);
        atoms.put("P", 2.19);
        atoms.put("S", 2.58);
        atoms.put("Cl", 3.16);
        atoms.put("K", 0.82);
        atoms.put("Ca", 1.00);
    }
}
