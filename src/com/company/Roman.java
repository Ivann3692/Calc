package com.company;

public class Roman {

    String[] roman = {"X", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    String[] romanTen = {"C", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] arab = {"10", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    int[] convertRoToAr(String[] exp) throws Exception {
        int[] operands = {0, 0};
        for (int i = 0; i < exp.length; i++) {
            for (int j = 0; j < roman.length; j++) {
                if (exp[i].equals(roman[j])) {
                    exp[i] = arab[j];
                    if (operands[0] == 0) {
                        operands[0] = Integer.parseInt(exp[i], 10);
                    } else if (operands[1] == 0) {
                        operands[1] = Integer.parseInt(exp[i], 10);
                    }
                }
            }
        }if (operands[0] <= 0) {
            throw new Exception("неверное число");
        } else if (operands[1] <= 0) {
            throw new Exception("неверное число");
        }
        return operands;
    }

    boolean check(String[] exp) {
        boolean roNumbs = false;
        for (String s : exp) {
            for (String value : roman) {
                if (s.equals(value)) {
                    roNumbs = true;
                    break;
                }
            }
        }
        return roNumbs;
    }


    String arToRo (int result) {

        String strResult = String.valueOf(result);
        String roResult = "";
        String[] split;


        if (result == 100) {
            roResult = romanTen[0];
        }

        for (int i = 1; i<=9; i=i+1) {
            int num = i * 10;
            if (result == num){
                roResult = romanTen[i];

                return roResult;
            }
        }

        for (int j = 10; j <= 80; j=j+10){
            int a = j / 10;
            int b = j + 10;

            boolean A = result > j;
            boolean B = result < b;
            if (A & B) {

                split = strResult.split("");
                split[0] = romanTen[a];
                for (int i = 0; i < roman.length; i++) {
                    if (split[1].equals(arab[i])) {
                        split[1] = roman[i];

                        roResult = split[0] + split[1];
                        return  roResult;
                    }
                }
            }
        }
        if (result < 10 ){
            for (int i = 1; i < arab.length; i++){
                if (result == i){
                    roResult = roman[i];
                    return roResult;
                }
            }
        }
        return roResult;
    }
}
