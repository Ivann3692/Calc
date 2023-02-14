package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws Exception {
        Calculate calculate = new Calculate();
        GetArabNambs conv = new GetArabNambs();
        Roman roman = new Roman();
        String hello = " (oT-T)尸 \nВведите 2 целых числа(римских или арабских) от 1 до 10 вкл-но и один из операторов (+, -, /, *) через пробел\n";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(hello);
        String input = br.readLine();
        String[] exp = input.split(" ");
        if (exp.length <= 3 && exp.length >= 3) {
            boolean roNumbs = roman.check(exp);
            int[] operands;
            String operator;
            int result;
            if (roNumbs) {
                roman.convertRoToAr(exp);
                operands = conv.convertNumbs(exp);
                operator = conv.getOperator(exp);
                result = calculate.calc(operands, operator);
                if (result < 0) {
                    throw new Exception("В римской системе нет отрицательных чисел");
                } else {
                    System.out.println("(: Будет :)");
                    System.out.println(roman.arToRo(result));
                }
            } else {
                operands = conv.convertNumbs(exp);
                operator = conv.getOperator(exp);
                result = calculate.calc(operands, operator);
                System.out.println("(: Будет :)");
                System.out.println(result);
            }
        } else {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
    }
}


