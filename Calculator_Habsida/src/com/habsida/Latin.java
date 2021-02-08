package com.habsida;

public class Latin {
    private int num1, num2;
    private char operation;
    private int result;
    private int left;

    public Latin() {
    }


    public  int getLeft() {
        return left;
    }

    public  void setLeft(int left) {
        this.left = left;
    }

    public Latin(int num1, int num2, char operation) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
    }

    public boolean checkNum(int a){
        boolean isAvailable = false;
        if (a>=1 && a<=10) {
            isAvailable = true;
        }
        else {
            System.out.println("Error! Numbers should be from 1 to 10");
            isAvailable = false;
        }
        return isAvailable;
    }

    public int calculate(int a, int b, char operation){
        int result = 0;

        switch (operation) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '/':
                result = a / b;
                left = a % b;
                break;
            case '*':
                result = a * b;
                break;
            default:
                System.out.println("Error! Wrong operation! Please try again!");
        }
        return result;
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

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
