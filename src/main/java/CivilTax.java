import java.util.HashMap;

public class CivilTax extends  TaxCalculation {
    private double socialSecurityTax;
    private double socialSecurityHealthTax;
    private double sickSecurityTax;
    private double primaryHealthTax;
    private double secondaryHealthTax;
    private double deductibleExpensesTax;
    private double advanceTax;
    private double advanceTaxPaidadvanceTax;
    private double taxFreeIncome;
    private double advanceTaxPaid;
    private double netIncome;
    public CivilTax(double income) {
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
        deductibleExpensesTax = (income * 20) / 100;
        income = income - deductibleExpensesTax;

    }

    @Override
    public void calculateAdvanceTax() {
        advanceTax = (income * 18) / 100;
        advanceTaxPaidadvanceTax = advanceTax - secondaryHealthTax - taxFreeIncome;
    }

    @Override
    public void calculateNetIncome() {
        netIncome=((socialSecurityTax + socialSecurityHealthTax + sickSecurityTax) + primaryHealthTax + advanceTaxPaid);

    }


    public void prepareTaxData() {
        taxData.put("Social Security Tax", socialSecurityTax);
        taxData.put("Social Security Health Tax", socialSecurityHealthTax);
        taxData.put("Sickness Security Tax", sickSecurityTax);
        taxData.put("Primary Health Tax", primaryHealthTax);
        taxData.put("Secondary Health Tax", secondaryHealthTax);
        taxData.put("Deductible Expenses Tax", deductibleExpensesTax);
        taxData.put("Advance Tax", advanceTax);
        taxData.put("Advance Tax Paid", advanceTaxPaidadvanceTax);
        taxData.put("Net Income", netIncome);
    }
}
