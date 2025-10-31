
import taxLogic.ContractType;
import taxLogic.TaxCalculation;
import taxLogic.TaxFactory;
import utils.InputHandler;
import utils.Printer;

public class TaxCalculator {

    public static double income = 0;
    public static ContractType contractType ;

    public static void main(String[] args) {

        income = InputHandler.getIncome();
        contractType = InputHandler.getContractType();

        try {
            TaxCalculation taxCalc = TaxFactory.createTaxCalculation(contractType, income);
            taxCalc.calculate();
            Printer.print(taxCalc.getDataToPrint());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}