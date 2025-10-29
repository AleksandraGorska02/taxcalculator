import taxLogic.CivilTax;
import taxLogic.EmploymentTax;
import taxLogic.TaxCalculation;
import utils.InputHandler;
import utils.Printer;

public class TaxCalculator {

    public static double income = 0;
    public static char contractType = ' ';

    public static void main(String[] args) {

        income = InputHandler.getIncome();
        contractType = InputHandler.getContractType();


        if (contractType == 'E') {

            TaxCalculation taxCalc = new EmploymentTax(income);
            taxCalc.calculate();
            Printer.print(taxCalc.getDataToPrint());

        } else if (contractType == 'C') {

            TaxCalculation taxCalc = new CivilTax(income);
            taxCalc.calculate();
            Printer.print(taxCalc.getDataToPrint());

        } else {
            System.out.println("Unknown type of contract!");
        }
    }
}