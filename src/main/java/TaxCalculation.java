import java.util.HashMap;

public abstract class TaxCalculation {
    protected HashMap<String, Object> taxData = new HashMap<>();
    protected double income;

    public TaxCalculation(double income) {
        this.income = income;
    }

    public final void calculate(double income) {

        // to ensure order of calculations
        calculateSocialSecurityTaxes(income);
        calculateHealthTaxes(income);
        calculateDeductibleExpensesTax(income);
        calculateAdvanceTax(income);
        calculateNetIncome(income);
    }

    public abstract void calculateSocialSecurityTaxes(double income);

    public abstract void calculateHealthTaxes(double income);

    public abstract void calculateDeductibleExpensesTax(double income);

    public abstract void calculateAdvanceTax(double income);

    public abstract void calculateNetIncome(double income);

}
