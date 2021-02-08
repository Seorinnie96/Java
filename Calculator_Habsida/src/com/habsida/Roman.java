package com.habsida;

import java.util.ArrayList;
import java.util.Arrays;

public class Roman {
    String[] romanNum = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    String[] romanDozen = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
    ArrayList<String> romanNumList= new ArrayList<String>(Arrays.asList(romanNum));
    ArrayList<String> romanDozenList= new ArrayList<String>(Arrays.asList(romanDozen));

    private int num1, num2, number;
    private char operation;
    private int left;
    private String leftRoman = "";

    public  int getLeft() {
        return left;
    }

    public  void setLeft(int left) {
        this.left = left;
    }

    public Roman(int num1, int num2, char operation) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
    }
    public Roman() {
    }

    public boolean checkNum(String a){
        boolean isAvailable = false;
        if(romanNumList.contains(a)) {
            number = romanNumList.indexOf(a) + 1;
            if (number>=1 && number<=10){
                isAvailable = true;
            }
            else {
                System.out.println("Error! Numbers should be from 1 to 10");
                isAvailable = false;
            }
        }
        else{
            number = romanDozenList.indexOf(a) + 1;
            number = number * 10;
            if(number == 10) {
                isAvailable = true;
            }
            else {
                isAvailable = false;
            }
        }
        return isAvailable;
    }

    public String getLeftRoman() {
        return leftRoman;
    }

    public void setLeftRoman(String leftRoman) {
        this.leftRoman = leftRoman;
    }

    public String calculate(String a, String b, char operation){
        int x =0, y=0;

        if(romanNumList.contains(a)){
            x = romanNumList.indexOf(a)+1;
        }
        if(romanNumList.contains(b)){
            y = romanNumList.indexOf(b)+1;
        }
        if(romanDozenList.contains(a)) {
            x = (romanDozenList.indexOf(a)+1)*10;
        }
        if(romanDozenList.contains(b)){
            y = (romanDozenList.indexOf(b)+1)*10;
        }

        int result = 0;
        int firstPart, secondPart;
        String answer = "";

        switch (operation) {
            case '+':
                result = x + y;
                if(result<10){
                    answer = romanNumList.get(result-1);
                }
                else{
                    firstPart = result/10;
                    secondPart = result%10;
                    answer = romanDozenList.get(firstPart-1);
                    if(secondPart!=0){
                        answer = answer + romanNumList.get(secondPart - 1);
                    }
                }
                break;
            case '-':
                result = x - y;
                if(result==0){
                    answer="0";
                }
                else if(x<y){
                    result=result*(-1);
                    answer = "-" + romanNumList.get(result - 1);
                }
                else {
                    answer = romanNumList.get(result - 1);
                }
                break;
            case '/':
                result = x / y;
                left = x % y;
                if(left!=0){
                    answer = romanNumList.get(result-1);
                    leftRoman = romanNumList.get(left-1);
                }
                else {
                    answer = romanNumList.get(result-1);
                    leftRoman = "0";
                }

                break;
            case '*':
                result = x * y;
                if(result<10){
                    answer = romanNumList.get(result-1);
                }
                else{
                    firstPart = result/10;
                    secondPart = result%10;
                    answer = romanDozenList.get(firstPart-1);
                    if(secondPart!=0){
                        answer = answer + romanNumList.get(secondPart - 1);
                    }
                }
                break;
            default:
                System.out.println("Error! Wrong operation! Please try again!");
        }
        return answer;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }


}
