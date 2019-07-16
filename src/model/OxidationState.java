package model;

import data.Atom;
import data.AtomInfo;
import data.ElectroneGativity;
import data.Oxi;

import java.util.ArrayList;
import java.util.List;

public class OxidationState {

    public static void main(String[] args) {
        List<Oxi> result = sanhwa("CH3OH", 0);
        for (Oxi oxi : result) {
            System.out.println(oxi);
        }
    }


    public static List<Oxi> sanhwa(String synthetic, int electric) {
        List<Atom> atoms = Separator.getAtomsByString(synthetic);
        List<Oxi> oxidation = new ArrayList<>();

        int entire = electric;
        boolean isThereMetal = false;

        for (Atom value : atoms) {
            oxidation.add(new Oxi(value, ElectroneGativity.getOxygenBySymbol(value.symbol), -10000, AtomInfo.getNumber(value.symbol)));
        }

        if (oxidation.size() == 1) {
            oxidation.get(0).oxidation = 0;
            return oxidation;
        }

        for(Oxi oxi : oxidation) {
            if(oxi.minus < ElectroneGativity.getOxygenBySymbol("H")) {
                isThereMetal = true;
                break;
            }
        }

        if(isThereMetal) {
            for (Oxi oxi : oxidation) {

                if (oxi.number >= 1 && oxi.number <= 20 && oxi.oxidation == -10000) {
                    if (oxi.number % 8 == 3) {
                        oxi.oxidation = 1;
                        entire -= oxi.oxidation * oxi.atom.number;
                    } else if (oxi.number % 8 == 4) {
                        oxi.oxidation = 2;
                        entire -= oxi.oxidation * oxi.atom.number;
                    } else if (oxi.number == 13) {
                        oxi.oxidation = 3;
                        entire -= oxi.oxidation * oxi.atom.number;
                    } else if (oxi.number == 1) {
                        oxi.oxidation = -1;
                        entire -= oxi.oxidation * oxi.atom.number;
                    }
                }
            }
        } else {
            for(Oxi oxi : oxidation) {
                if (oxi.number == 1) {
                    oxi.oxidation = 1;
                    entire -= oxi.oxidation * oxi.atom.number;
                }
            }
        }


        if (checkRemainAtom(oxidation) == 1) {
            for (Oxi oxi : oxidation) {
                if (oxi.oxidation == -10000) {
                    oxi.oxidation = entire / oxi.atom.number;
                }
            }
        }

//        bubbleSort(oxidation);


        int j = 0;
        for (double i = 4.0; i >= 0.0; i -= 0.01) {

            if (j >= oxidation.size()) {
                break;
            }

            for (Oxi oxi : oxidation) {
                if (oxi.minus == (double)Math.round(i*100)/100 && oxi.oxidation == -10000) {
                    if (oxi.number >= 1 && oxi.number <= 20) {
                        if (oxi.number % 8 == 1 && oxi.number != 1) {
                            oxi.oxidation = -1;
                            entire -= oxi.oxidation * oxi.atom.number;
                        } else if (oxi.number % 8 == 0) {
                            oxi.oxidation = -2;
                            entire -= oxi.oxidation * oxi.atom.number;
                        } else if (oxi.number == 7) {
                            oxi.oxidation = -3;
                            entire -= oxi.oxidation * oxi.atom.number;
                        } else if (oxi.number == 1) {
                            oxi.oxidation = +1;
                            entire -= oxi.oxidation * oxi.atom.number;
                        }
                    }
                    j++;
                }
            }

            boolean braek = false;
            if (checkRemainAtom(oxidation) == 1) {
                for (Oxi oxi : oxidation) {
                    if (oxi.oxidation == -10000) {
                        oxi.oxidation = entire / oxi.atom.number;
                        braek = true;
                        break;
                    }
                }
                if (braek) break;
            }
        }




        if(checkRemainAtom(oxidation) >= 2) {
            for (Oxi oxi : oxidation) {
                if(oxi.oxidation == -10000) {
                    oxi.oxidation = entire / checkRemainAtom(oxidation);
                    oxi.isAccurate = false;
                }
            }
        } else {
            for (Oxi oxi : oxidation) {
                if(oxi.oxidation == -10000) {
                    oxi.oxidation = entire / checkRemainAtom(oxidation);
                }
            }
        }

//        for (Oxi oxi : oxidation) {
//            oxi.oxidation /= oxi.atom.number;
//        }
        return oxidation;
    }


    private static int checkRemainAtom(List<Oxi> oxidation) {
        int count = 0;
        for (Oxi key : oxidation) {
            if (key.oxidation == -10000) {
                count++;
            }
        }

        return count;
    }

    private static void bubbleSort(List<Oxi> oxidation) {
        for (int i = 0; i < oxidation.size() - 1; i++) {
            for (int j = i + 1; j < oxidation.size(); j++) {
                if (oxidation.get(i).minus < oxidation.get(j).minus) {
                    Oxi temp;
                    temp = oxidation.get(i);
                    oxidation.set(i, oxidation.get(j));
                    oxidation.set(j, temp);
                }
            }
        }
//        for (Oxi oxi : oxidation) {
//            System.out.println(oxi);
//        }
    }
}
