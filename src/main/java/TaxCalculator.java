

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class TaxCalculator {

    public static double income = 0;
    public static char contractType = ' ';
    // social security taxes
    public static double socialSecurityTax = 0; // 9,76% of basis
    public static double socialSecurityHealthTax = 0; // 1,5% of basis
    public static double socialSecuritySicknessTax = 0; // 2,45% of basis
    // health-related taxes
    public static double deductibleExpensesTax = 111.25;
    public static double primaryHealthTax = 0; // of basis up to 9%
    public static double secondaryHealthTax = 0; // of basis up to  7,75 %
    public static double advanceTaxPaidadvanceTax = 0; // advance tax 18%
    public static double taxFreeIncome = 46.33; // tax-free income monthly 46,33 PLN
    public static double advanceTaxPaid0 = 0;
    public static double advanceTax = 0;
    public static double advanceTaxPaid = 0;
    public static double taxPaid = 0;
    public static double netIncome = 0;

    public static DecimalFormat df00 = new DecimalFormat(".00");
    public static DecimalFormat df = new DecimalFormat("#");

    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.print("Enter income: ");
            income = Double.parseDouble(br.readLine());

            System.out.print("Contract Type: (E)mployment, (C)ivil: ");
            contractType = br.readLine().charAt(0);

        } catch (Exception ex) {
            System.out.println("Incorrect");
            System.err.println(ex);
            return;
        }

        if (contractType == 'E') {
            calculateEmploymentTax();

        } else if (contractType == 'C') {
            calculateCivilTax();
        } else {
            System.out.println("Unknown type of contract!");
        }
    }

    public static void calculateAdvanceTax() {
        advanceTaxPaidadvanceTax = advanceTax - secondaryHealthTax - taxFreeIncome;
    }

    public static void calculateTax(double income) {
        advanceTax = (income * 18) / 100;
    }

    public static double calculateIncome(double income) {
        socialSecurityTax = (income * 9.76) / 100;
        socialSecurityHealthTax = (income * 1.5) / 100;
        double soc_sick_secur = (income * 2.45) / 100;
        return (income - socialSecurityTax - socialSecurityHealthTax - soc_sick_secur);
    }

    public static void calculateOtherTaxes(double income) {
        primaryHealthTax = (income * 9) / 100;
        secondaryHealthTax = (income * 7.75) / 100;
    }

    private static void printSocialSecurityTaxes() {
        System.out.println("Social security tax "
                + df00.format(socialSecurityTax));

        System.out.println("Health social security tax    "
                + df00.format(socialSecurityHealthTax));
        System.out.println("Sickness social security tax  "
                + df00.format(socialSecuritySicknessTax));
        System.out
                .println("Income basis for health social security: "
                        + income);
    }

    public static void printHealthTaxes() {
        System.out.println("Health social security tax: 9% = "
                + df00.format(primaryHealthTax) + " 7,75% = " + df00.format(secondaryHealthTax));

    }

    public static void printDeductibleExpensesTaxes() {

        System.out.println("Tax deductible expenses "
                + deductibleExpensesTax
        );

    }

    public static void calculateEmploymentTax() {
        System.out.println("EMPLOYMENT");
        System.out.println("Income " + income);
       income = calculateIncome(income);
        printSocialSecurityTaxes();

        calculateOtherTaxes(income);
        printHealthTaxes();

        double taxedIncome = income - deductibleExpensesTax;
        double taxedIncome0 = Double.parseDouble(df.format(taxedIncome));
        calculateTax(taxedIncome0);
        double taxPaid = advanceTax - taxFreeIncome;

        calculateAdvanceTax();
        advanceTaxPaid0 = Double.parseDouble(df.format(advanceTaxPaid));
         netIncome = income - ((socialSecurityTax + socialSecurityHealthTax + socialSecuritySicknessTax) + primaryHealthTax + advanceTaxPaid0);

        System.out.println("income " + taxedIncome + " rounded " + df.format(taxedIncome0));
        System.out.println("Advance tax 18 % = " + advanceTax);
        System.out.println("Tax free income = " + taxFreeIncome);

        System.out.println("Reduced tax = " + df00.format(taxPaid));
        System.out.println("Advance tax paid = " + df00.format(advanceTaxPaid) + " rounded = " + df.format(advanceTaxPaid0));
        System.out.println();
        System.out.println("Net income = " + df00.format(netIncome));

    }

    public static void calculateCivilTax() {
        System.out.println("income " + income);

        income= calculateIncome(income);
        printSocialSecurityTaxes();
        calculateOtherTaxes(income);
        System.out.println("Health security tax: 9% = "
                + df00.format(primaryHealthTax) + " 7,75% = " + df00.format(secondaryHealthTax));

        taxFreeIncome = 0;

        deductibleExpensesTax = (income * 20) / 100;
        printDeductibleExpensesTaxes();

        double taxedIncome = income - deductibleExpensesTax;
        double taxedIncome0 = Double.parseDouble(df.format(taxedIncome));
        System.out.println("income to be taxed = " + taxedIncome+ " rounded = " + df.format(taxedIncome0));
        calculateTax(taxedIncome0);
        System.out.println("Advance tax 18 % = " + advanceTax);
        System.out.println("Already paid tax = "  + df00.format(taxPaid));
        calculateAdvanceTax();
        advanceTaxPaid0 = Double.parseDouble(df.format(advanceTaxPaid));
        System.out.println("Advance tax  = "
                + df00.format(advanceTaxPaid) + " rounded = "
                + df.format(advanceTaxPaid0));
         netIncome = income
                - ((socialSecurityTax + socialSecurityHealthTax + socialSecuritySicknessTax) + primaryHealthTax + advanceTaxPaid0);
        System.out.println();
        System.out
                .println("Net income = "
                        + df00.format(netIncome));
    }
}
