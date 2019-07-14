package model;

public class BohrEnergyCalculator {

    public static void main(String[] args) {
        System.out.println(calculate(999, 2));
    }

    public static double calculate(int start, int end){

        if(start == 0 || end == 0) {
            return 0;
        }

        double result = getEnergy(start) - getEnergy(end);
        return Math.round(result * 10) / 10.0;
    }

    private static double getEnergy(int floor) {
        return -1312.0 / Math.pow(floor, 2.0);
    }
}
