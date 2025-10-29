import java.text.DecimalFormat;

public class EmploymentTax extends TaxCalculation {

    private double socialSecurityTax;
    private double socialSecurityHealthTax;
    private double sickSecurityTax;
    private double primaryHealthTax;
    private double secondaryHealthTax;
    private double taxedIncome;
    private double deductibleExpensesTax;
    private double advanceTax;
    private double taxFreeIncome;
    private double taxPaid;
    private double advanceTaxPaid;
    private double netIncome;

    private final DecimalFormat df = new DecimalFormat("#");
    private final DecimalFormat df00 = new DecimalFormat(".00");

    public EmploymentTax(double income) {
        super(income);
    }

    @Override
    public void calculateSocialSecurityTaxes() {
        socialSecurityTax = (income * 9.76) / 100;
        socialSecurityHealthTax = (income * 1.5) / 100;
        sickSecurityTax = (income * 2.45) / 100;

        taxData.put("Income", income);
        taxData.put("Social security tax", socialSecurityTax);
        taxData.put("Health social security tax", socialSecurityHealthTax);
        taxData.put("Sickness social security tax", sickSecurityTax);

        // Basis for health tax
        income = income - socialSecurityTax - socialSecurityHealthTax - sickSecurityTax;
        taxData.put("Income basis for health social security", income);
    }

    @Override
    public void calculateHealthTaxes() {
        primaryHealthTax = (income * 9) / 100;
        secondaryHealthTax = (income * 7.75) / 100;

        taxData.put("Health social security tax 9%", primaryHealthTax);
        taxData.put("Health social security tax 7.75%", secondaryHealthTax);
    }

    @Override
    public void calculateDeductibleExpensesTax() {
        deductibleExpensesTax = 111.25;
        taxedIncome = income - deductibleExpensesTax;

        taxData.put("Taxed income", taxedIncome);
    }

    @Override
    public void calculateAdvanceTax() {
        advanceTax = (taxedIncome * 18) / 100;
        taxFreeIncome = 46.33;
        taxPaid = advanceTax - taxFreeIncome;
        advanceTaxPaid = advanceTax - secondaryHealthTax - taxFreeIncome;

        taxData.put("Advance tax 18%", advanceTax);
        taxData.put("Tax free income", taxFreeIncome);
        taxData.put("Reduced tax", taxPaid);
        taxData.put("Advance tax paid", advanceTaxPaid);
    }

    @Override
    public void calculateNetIncome() {

        netIncome = income - ((socialSecurityTax + socialSecurityHealthTax) + primaryHealthTax);
        //delete + advanceTaxPaid because it is not deducted from income in original calculation
        //delete sickSecurityTax because it is not deducted from income in original calculation
        taxData.put("Net income", netIncome);
    }
}
