package taxLogic;

import java.util.LinkedHashMap;

public abstract class TaxCalculation {
    protected LinkedHashMap<String, Object> taxData = new LinkedHashMap<>();

    public double income;

    public double socialSecurityTax;
    public double socialSecurityHealthTax;
    public double sickSecurityTax;
    public double primaryHealthTax;
    public double secondaryHealthTax;
    public double deductibleExpensesTax;
    public double taxedIncome;
    public double advanceTax;

    public double taxFreeIncome;
    public double advanceTaxPaid;
    public double netIncome;
    public double taxPaid = 0;

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
