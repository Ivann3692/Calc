package com.company;

public class Calculate {
    String[] operators = {"+", "-", "*", "/"};

    int calc (int[] operands, String operator){

        int result=0;

        if (operator.equals(operators[0])){
            result = operands[0]+operands[1];
        }else if(operator.equals(operators[1])){
            result = operands[0]-operands[1];
        }else if(operator.equals(operators[2])){
            result = operands[0]*operands[1];
        }else if(operator.equals(operators[3])){
            result = operands[0]/operands[1];
        } return result;
    }
}
