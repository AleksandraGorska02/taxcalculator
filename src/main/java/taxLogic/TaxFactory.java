package taxLogic;

public class TaxFactory {

    public static TaxCalculation createTaxCalculation(ContractType contractType, double income) {
        return switch (contractType) {
            case EMPLOYMENT -> new EmploymentTax(income);
            case CIVIL -> new CivilTax(income);
        };
    }
}
