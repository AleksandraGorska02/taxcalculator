import java.util.HashMap;

public class CivilTax extends  TaxCalculation {

    public CivilTax(double income) {
        super(income);
    }

    @Override
    public void calculateSocialSecurityTaxes(double income) {
        // Implementation for civil tax social security calculations
    }

    @Override
    public void calculateHealthTaxes(double income) {
        // Implementation for civil tax health tax calculations
    }

    @Override
    public void calculateDeductibleExpensesTax(double income) {
        // Implementation for civil tax deductible expenses calculations
    }

    @Override
    public void calculateAdvanceTax(double income) {
        // Implementation for civil tax advance tax calculations
    }

    @Override
    public void calculateNetIncome(double income) {
        // Implementation for civil tax net income calculations
    }

}
