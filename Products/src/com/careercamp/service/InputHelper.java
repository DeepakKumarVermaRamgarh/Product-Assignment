package com.careercamp.service;

import java.util.Scanner;
import java.util.InputMismatchException;

public class InputHelper {

    public static <T> T takeValidInput(String variableName, Class<T> dataType, Scanner scanner) {
        System.out.print("Enter value for " + variableName + " (" + dataType.getSimpleName() + "): ");
        while (true) {
            try {
                T inputValue = null;
                if (dataType == Integer.class) {
                    inputValue = dataType.cast(scanner.nextInt());
                } else if (dataType == Double.class) {
                    inputValue = dataType.cast(scanner.nextDouble());
                } else if (dataType == String.class) {
                    inputValue = dataType.cast(scanner.nextLine());
                } else {
                    System.out.println("Unsupported data type. Please enter a valid data type.");
                    break;
                }
                return inputValue;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Try again.");
                scanner.next();
            }
        }
        return null;
    }
}
