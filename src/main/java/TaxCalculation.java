public abstract class TaxCalculation {

    protected abstract void calculateSocialSecurityTaxes();
    protected abstract void calculateHealthTaxes();
    protected abstract void calculateDeductibleExpenses();
    protected abstract void calculateAdvanceTax();
    protected abstract void calculateNetIncome();
}
