package com.vrevankar.java.sample;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculator {
  public static void main(String[] args) {
    Scanner scanner;
    double num1, num2;
    String operator;

    System.out.println("This calculator application supports Addition(+), Subtraction(-), Multiplication(*), Division(/), Exponential(^) and Modulus(%) operations."); 

    while(true){
      try { 
        System.out.print("Enter 1st number: ");
	scanner = new Scanner(System.in);
        num1 = scanner.nextDouble();
        break;
      } catch (InputMismatchException exc){
        System.err.println("Invalid Number");
      }
    }

    while(true){
      try {
        System.out.print("Enter 2nd number: ");
        scanner = new Scanner(System.in);
        num2 = scanner.nextDouble();
        break;
      } catch(InputMismatchException exc){
        System.err.println("Invalid number");
      }
    }

    double result;
    loop: while(true) {
      scanner = new Scanner(System.in);
      System.out.print("Enter operator: ");
      operator = scanner.next();
      switch (operator)  {
      case "+":
      	result = num1 + num2;
      	break loop;
      case "-":
	result = num1 - num2;
      	break loop;
      case "*":
      	result = num1*num2;
      	break loop;
      case "/":
      	result = num1 / num2;
      	break loop;
      case "^":
      	result = Math.pow(num1, num2);
      	break loop;
      case "%":
      	result = num1 % num2;
      	break loop;
      default:
      	System.err.println("Invalid Operator");
      }
    }
    System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
  }
}

