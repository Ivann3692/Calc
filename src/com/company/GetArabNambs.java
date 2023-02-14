package com.company;

class GetArabNambs {


    String[] arab = {"10", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String[] operators = {"+", "-", "*", "/"};

    int[] operands = {0, 0};
    String operator = "";

    int[] convertNumbs(String[] exp) throws Exception {

        for (int i = 0; i < exp.length; i++) {
            for (int j = 0; j < arab.length; j++) {
                if (exp[i].equals(arab[j])) {
                    if (operands[0] == 0) {
                        operands[0] = Integer.parseInt(exp[i], 10);
                    } else if (operands[1] == 0) {
                        operands[1] = Integer.parseInt(exp[i], 10);
                    }
                }
            }
        }

        if (operands[0] == 0) {
            throw new Exception("неверное число");//неверное число !!! return
        } else if (operands[1] == 0) {
            throw new Exception("неверное число");//неверное число !!! return
        }

        return operands;
    }

    String getOperator(String[] exp) throws Exception {

        for (int i = 0; i < exp.length; i++) {
            for (int j = 0; j < operators.length; j++) {
                if (exp[i].equals(operators[j])) {
                    operator = exp[i];
                }
            }
        }
        if (operator.equals("")) {
            throw new Exception("неверный оператор");//неверная операция !!! return
        }
        return operator;
    }


}