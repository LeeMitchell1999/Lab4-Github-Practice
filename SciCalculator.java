/***************************************************************************************************************
 * Written By: Mitchell Lee
 * Partner: N/A
 * Lab 03: ScientificCalculator
 * Objective: Create a scientific calculator to practice input, output, math libraries, and control structures
 ***************************************************************************************************************/


//ADDED COMMENT TO SHOW CHANGE THROUGH SOURCETREE


import java.util.Scanner;

public class SciCalculator {
    //Main method houses all the statements necessary for the calculator: switch statement, errors, variables, etc
    public static void main(String[] args) {

        //Allow for user input
        Scanner calculator = new Scanner(System.in);

        //Create variables
        double result = 0.0;
        int menuSelect = 0;
        double firstOperand = 0.0;
        double secondOperand = 0.0;
        final String RESULT = "RESULT";
        String response = "Result";
        double allCalculations = 0.0;
        int numberCalculations = 0;
        double average = 0.0;

        do {
            //Show result from previous calculation if average option isn't picked
            if (menuSelect != 7) {
                System.out.println("Current Result: " + result);
                System.out.println();
            }

            //Show menu to user
            if (menuSelect != 7) {
                System.out.println("Calculator Menu");
                System.out.println("---------------");
                System.out.println("0. Exit Program");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Exponentiation");
                System.out.println("6. Logarithm");
                System.out.println("7. Display Average");
                System.out.println();
            }

            //Ask user for input
            System.out.print("Enter Menu Selection: ");
            try {
                menuSelect = calculator.nextInt();
            }
            catch (Exception e) {
                System.out.println("error");
            }

            //Error if menu option 7 picked immediately
            if ((menuSelect == 7) && (numberCalculations == 0)) {
                do {
                    System.out.println();
                    System.out.println("Error: No calculations yet to average!");
                    System.out.println();
                    System.out.print("Enter Menu Selection: ");
                    menuSelect = calculator.nextInt();
                }
                while (menuSelect == 7);
            }

            //Error message for invalid menu selection
            if ((menuSelect < 0) || (menuSelect > 7)) {
                do {
                    System.out.println();
                    System.out.println("Error: Invalid selection!");
                    System.out.println();
                    System.out.print("Enter Menu Selection: ");
                    menuSelect = calculator.nextInt();
                }
                while ((menuSelect < 0) || (menuSelect > 7));
            }


            /************************************************************************************
             * Citation for comparing strings (found in block below)
             * Title: Compare two Strings in Java
             * Author: GeeksforGeeks
             * Date: 5/23/2019
             * Code Version: Not listed
             * Availability: https://www.geeksforgeeks.org/compare-two-strings-in-java/
             ************************************************************************************/

            //Asking for first and second operands will only happen if exit is not the chosen option
            if (menuSelect != 0 && menuSelect != 7) {
                //Request the first operand
                System.out.print("Enter first operand: ");

                //EC Portion: will take "RESULT" to mean use value from previous calculation
                if (calculator.hasNextDouble() == false) {  //Checks to see if a string is input instead of digits

                    response = calculator.next();
                    if (response.equals(RESULT))        //Syntax for (response == "RESULT");
                        firstOperand = result;

                        //If the input string is not "RESULT" then we loop until we get an appropriate input
                    else {
                        do {
                            //Keeps outputting error until valid input is received
                            System.out.println("Error: Invalid Input!");
                            System.out.println();
                            System.out.print("Enter first operand: ");

                            //If user decides to put digits instead of "RESULT" we exit and use the inputted value
                            if (calculator.hasNextDouble() == true) {
                                firstOperand = calculator.nextDouble();
                                break;
                            }

                            //Assigns first operand to previous calculation if "RESULT" is typed in
                            else {
                                response = calculator.next();
                                if (response.equals(RESULT)) firstOperand = result;
                            }

                        }
                        while (!response.equals(RESULT));      //Syntax for (response != "RESULT);
                    }
                } else firstOperand = calculator.nextDouble();

                //Request the second operand
                System.out.print("Enter second operand: ");

                //EC Portion: Will take "RESULT" to mean use value from previous calculation
                if (calculator.hasNextDouble() == false) {
                    response = calculator.next();
                    if (response.equals(RESULT))        //Syntax for (response == "RESULT");
                        secondOperand = result;

                        //If the input string is not "RESULT" then we loop until we get an appropriate input
                    else {
                        do {
                            //Keeps outputting error until valid input is received
                            System.out.println("Error: Invalid Input!");
                            System.out.println();
                            System.out.print("Enter second operand: ");

                            //If user decides to put digits instead of "RESULT" we exit and use the inputted value
                            if (calculator.hasNextDouble() == true) {
                                secondOperand = calculator.nextDouble();
                                break;
                            }

                            //Assigns second operand to previous calculation if "RESULT" is typed in
                            else {
                                response = calculator.next();
                                if (response.equals(RESULT)) secondOperand = result;
                            }

                        }
                        while (!response.equals(RESULT));      //Syntax for (response != "RESULT);
                    }
                } else secondOperand = calculator.nextDouble();

            }

            //Switch statements for corresponding results
            switch (menuSelect) {
                case 0: //Exit
                    System.out.println();
                    System.out.println("Thanks for using this calculator. Goodbye!");
                    System.exit(1);
                    break;

                case 1: //Add
                    System.out.println();
                    try {
                        result = firstOperand + secondOperand;
                        numberCalculations++;
                        allCalculations += result;
                    }
                    catch (Exception e) {
                        System.out.println("error");
                }
                    break;

                case 2: //Subtract
                    System.out.println();
                    result = firstOperand - secondOperand;
                    numberCalculations++;
                    allCalculations += result;
                    break;

                case 3: //Multiply
                    System.out.println();
                    result = firstOperand * secondOperand;
                    numberCalculations++;
                    allCalculations += result;
                    break;

                case 4: //Divide
                    System.out.println();
                    result = firstOperand / secondOperand;
                    numberCalculations++;
                    allCalculations += result;
                    break;

                case 5: //Exponent
                    System.out.println();
                    result = Math.pow(firstOperand, secondOperand);
                    numberCalculations++;
                    allCalculations += result;
                    break;

                case 6: //Log
                    System.out.println();
                    result = (Math.log(secondOperand) / (Math.log(firstOperand)));
                    numberCalculations++;
                    allCalculations += result;
                    break;

                case 7: //Average
                    System.out.println();
                    System.out.println("Sum of calculations: " + allCalculations);
                    System.out.println("Number of calculations: " + numberCalculations);
                    average = allCalculations / numberCalculations;
                    System.out.print("Average of calculations: ");
                    System.out.printf("%.2f", average);
                    System.out.println();
                    System.out.println();
                    break;
            }
        }
        while (menuSelect != 0);
    }
}
