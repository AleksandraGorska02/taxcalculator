import java.util.HashMap;

public abstract class TaxCalculation {
    protected HashMap<String, Object> taxData = new HashMap<>();
    protected double income;

    public TaxCalculation(double income) {
        this.income = income;
    }

    public final void calculate() {

        // to ensure order of calculations
        calculateSocialSecurityTaxes();
        calculateHealthTaxes();
        calculateDeductibleExpensesTax();
        calculateAdvanceTax();
        calculateNetIncome();
    }

    public abstract void calculateSocialSecurityTaxes();

    public abstract void calculateHealthTaxes();

    public abstract void calculateDeductibleExpensesTax();

    public abstract void calculateAdvanceTax();

    public abstract void calculateNetIncome();

}
