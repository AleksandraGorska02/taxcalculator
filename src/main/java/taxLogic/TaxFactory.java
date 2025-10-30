package taxLogic;

public class TaxFactory {

    public static TaxCalculation createTaxCalculation(char contractType, double income) {
        switch (Character.toUpperCase(contractType)) {
            case 'E':
                return new EmploymentTax(income);
            case 'C':
                return new CivilTax(income);
            default:
                throw new IllegalArgumentException("Unknown type of contract: " + contractType);
        }
    }
}
