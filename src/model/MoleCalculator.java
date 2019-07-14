package model;

import data.Atom;

import java.util.ArrayList;
import java.util.List;
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

    public static List<String> calculateMass(String synthetic) {
        char[] solute = synthetic.toCharArray();
        List<String> results = new ArrayList<>();

        int i = 0;
        while (i < solute.length) {
            int startIndex = 0;
            if (solute[i] >= 'A' && solute[i] <= 'Z') {
                startIndex = i;
                i++;
                while (!(solute[i] >= 'A' && solute[i] <= 'Z')) {
                    i++;
                }
                results.add(String.copyValueOf(solute).substring(startIndex, i));
            } else {
                i++;
            }
        }

        return results;
    }
}
