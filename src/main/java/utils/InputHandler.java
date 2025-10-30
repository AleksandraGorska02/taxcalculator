package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHandler {

    public static double getIncome() {
        double income;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.print("Enter income: ");
               income = Double.parseDouble(br.readLine());
        } catch (IOException ex) {   throw new IllegalArgumentException("Incorrect contract type input", ex);
        }
        return income;
    }

    public static char getContractType() {
        char contractType;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.print("Contract Type: (E)mployment, (C)ivil: ");
            contractType = br.readLine().charAt(0);

            if (contractType != 'E' && contractType != 'C') {
                System.out.println("Unknown type of contract!");
                System.exit(1);
            }

        } catch (IOException ex) {
            throw new IllegalArgumentException("Incorrect contract type input", ex);
        }
        return contractType;
    }
}
