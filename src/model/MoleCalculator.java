package model;

import data.Atom;

import java.util.Map;
import java.util.Scanner;

public class MoleCalculator {
    private static Map<String, Atom> atoms;

    private static Scanner scanner;

    public static void main(String[] args) {

        atoms = Atom.getAtoms();
        scanner = new Scanner(System.in);
//
//        System.out.println("용질의 몰수를 입력하세요");
//        int answerMole = scanner.nextInt();
//        System.out.println("용액의 부피를 입력하세요.(리터L)/(밀리리터mL)");//리터 버튼, 밀리리터 버튼 만들고
//        int answerVolume = scanner.nextInt();//밀리리터면 1000으로 나누고
//        int answer = answerMole / answerVolume;
//        System.out.println("용질의 몰수를 모르고 있나요?");
        System.out.println(calculateMass(""));
    }

    public static int calculateMass(String synthetic) {
        char[] solute = synthetic.toCharArray();
        int massResult = 0;
        int i = 0;
        while (i < solute.length) {
            char[] chars = new char[3];

            int count = 0;
            if(solute[i] >= 'A' && solute[i] <= 'Z') {
                chars[0] = solute[i];
                if(solute[i+1] >= 'a' && solute[i+1] <= 'z') {
                    chars[1] = solute[i+1];
                    if(solute[i+2] >= '1' && solute[i+2] <= '9') {
                        Character temp = solute[i+2];
                        count = Integer.parseInt(temp.toString());
                        i+=2;
                    }
                } else if(solute[i+1] >= '1' && solute[i+1] <= '9') {
                    Character temp = solute[i+1];
                    count = Integer.parseInt(temp.toString());
                } else {
                    count = 1;
                }
            }
            massResult += Atom.getMassByString(String.copyValueOf(chars).trim()) * count;
            i++;
            System.out.println(massResult);
        }

        return massResult;
    }
}
