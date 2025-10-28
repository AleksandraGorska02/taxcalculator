public class EmploymentTax extends TaxCalculation {

    private double socialSecurityTax;
    private double socialSecurityHealthTax;
    private double primaryHealthTax;
    private double secondaryHealthTax;
    private double deductibleExpensesTax;
    private double advanceTax;
    private double taxFreeIncome;
    private double taxPaid;
    private double advanceTaxPaid;
    private double netIncome;

    public EmploymentTax(double income) {
        super(income);
    }

    @Override
    public void calculateSocialSecurityTaxes() {

        socialSecurityTax = (income * 9.76) / 100;
        socialSecurityHealthTax = (income * 1.5) / 100;
        double sickSecurityTax = (income * 2.45) / 100;
        income = (income - socialSecurityTax - socialSecurityHealthTax - sickSecurityTax);
    }

    @Override
    public void calculateHealthTaxes() {
        primaryHealthTax = (income * 9) / 100;
        secondaryHealthTax = (income * 7.75) / 100;

    }

    @Override
    public void calculateDeductibleExpensesTax() {
        deductibleExpensesTax = 111.25;
        income = income - deductibleExpensesTax;
    }

    @Override
    public void calculateAdvanceTax() {

        advanceTax = (income * 18) / 100;
        taxFreeIncome = 46.33;
        taxPaid = advanceTax - taxFreeIncome;
        advanceTaxPaid = advanceTax - secondaryHealthTax - taxFreeIncome;

    }

    @Override
    public void calculateNetIncome() {
        netIncome = income - primaryHealthTax - advanceTaxPaid;
    }

}
