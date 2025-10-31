package utils;

import taxLogic.ContractType;

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
        } catch (IOException ex) {
            throw new IllegalArgumentException("Incorrect contract type input", ex);
        }
        return income;
    }

    public static ContractType getContractType() {
        ContractType contractType = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.print("Contract Type: (E)mployment, (C)ivil: ");
            contractType = ContractType.fromCode(br.readLine().charAt(0));
        } catch (IllegalArgumentException e) {
            System.out.println("Unknown type of contract!");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error reading input!");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return contractType;
    }
}
