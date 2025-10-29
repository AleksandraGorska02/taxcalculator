import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class TaxCalculation {
    protected LinkedHashMap<String, Object> taxData = new LinkedHashMap<>();
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
    public LinkedHashMap<String, Object> getDataToPrint() {
        return taxData;
    }
}
