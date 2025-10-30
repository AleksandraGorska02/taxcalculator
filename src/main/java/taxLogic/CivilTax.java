package taxLogic;

public class CivilTax extends TaxCalculation {


    public static final double SOCIAL_SECURITY_TAX_PERCENTAGE = 9.76;
    public static final double SOCIAL_SECURITY_HEALTH_TAX_PERCENTAGE = 1.5;
    public static final double SICK_SECURITY_TAX_PERCENTAGE = 2.45;
    public static final int PRIMARY_HEALTH_TAX_PERCENTAGE = 9;
    public static final double SECONDARY_HEALTH_TAX_PERCENTAGE = 7.75;
    public static final int ADVANCE_TAX_PERCENTAGE = 18;
    public static final int DEDUCTIBLE_EXPENSES_TAX_PERCENTAGE = 20;

    public CivilTax(double income) {
        super(income);
    }

    @Override
    public void calculateSocialSecurityTaxes() {
        socialSecurityTax = (income * SOCIAL_SECURITY_TAX_PERCENTAGE) / 100;
        socialSecurityHealthTax = (income * SOCIAL_SECURITY_HEALTH_TAX_PERCENTAGE) / 100;
        sickSecurityTax = (income * SICK_SECURITY_TAX_PERCENTAGE) / 100;

        putSocialSecurityTax();

        // Basis for health tax
        income = income - socialSecurityTax - socialSecurityHealthTax - sickSecurityTax;
        putBasicIncome();
    }

    private void putBasicIncome() {
        taxData.put("Income basis for health social security", income);
    }

    private void putSocialSecurityTax() {
        taxData.put("Income", income);
        taxData.put("Social security tax", socialSecurityTax);
        taxData.put("Health social security tax", socialSecurityHealthTax);
        taxData.put("Sickness social security tax", sickSecurityTax);
    }

    @Override
    public void calculateHealthTaxes() {
        primaryHealthTax = (income * PRIMARY_HEALTH_TAX_PERCENTAGE) / 100;
        secondaryHealthTax = (income * SECONDARY_HEALTH_TAX_PERCENTAGE) / 100;

        putHealthTax();
    }

    private void putHealthTax() {
        taxData.put("Health social security tax 9%", primaryHealthTax);
        taxData.put("Health social security tax 7.75%", secondaryHealthTax);
    }


    @Override
    public void calculateDeductibleExpensesTax() {
        deductibleExpensesTax = (income * DEDUCTIBLE_EXPENSES_TAX_PERCENTAGE) / 100;

        taxedIncome = income - deductibleExpensesTax;
        putTaxedIncome();
    }

    private void putTaxedIncome() {
        taxData.put("Tax deductible expenses", deductibleExpensesTax);
    }

    @Override
    public void calculateAdvanceTax() {

        advanceTax = (taxedIncome * ADVANCE_TAX_PERCENTAGE) / 100;
        advanceTaxPaid = advanceTax - secondaryHealthTax - taxFreeIncome;

        putAdvanceTax();
    }

    private void putAdvanceTax() {
        taxData.put("income to be taxed = ", taxedIncome);
        taxData.put("Advance tax 18 % = ", advanceTax);
        taxData.put("Already paid tax = ", taxPaid);
        taxData.put("Advance tax ", advanceTaxPaid);
    }

    @Override
    public void calculateNetIncome() {
        netIncome= income
                - ((socialSecurityTax + socialSecurityHealthTax + sickSecurityTax) + primaryHealthTax + advanceTaxPaid);
        putNetIncome();


    }

    private void putNetIncome() {
        taxData.put("Net income ", netIncome);
    }


}
