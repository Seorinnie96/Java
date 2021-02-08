package com.habsida;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int a, b;
        String num1, num2, resultRoman;
        char operation;
        boolean checkStatement = false;
        int result;
        while(true){
            System.out.println("Enter statement and use +, -, /, * :");

            if(in.hasNextInt()) {
                a = in.nextInt();
                checkStatement = in.hasNextInt();
                operation = in.next().charAt(0);
                b = in.nextInt();
                Latin state = new Latin();
                if (state.checkNum(a) == true && state.checkNum(b) == true) {
                    result = state.calculate(a, b, operation);
                    System.out.println("Result is: " + result);
                    System.out.println("Left is: " + state.getLeft());
                } else {
                    System.out.println("Your statement is wrong!");
                }
            }
            else if(!in.hasNextInt()) {
                num1 = in.next();
                operation = in.next().charAt(0);
                num2 = in.next();
                Roman roman = new Roman();
                if (roman.checkNum(num1) == true && roman.checkNum(num2) == true) {
                    resultRoman = roman.calculate(num1, num2, operation);
                    System.out.println("Result is: " + resultRoman);
                    System.out.println("Left is: " + roman.getLeftRoman());
                } else {
                    System.out.println("Your statement is wrong!");
                }


            }
            else {
                System.out.println("Please check your request first!");
            }
        }
        // write your code here
    }

}