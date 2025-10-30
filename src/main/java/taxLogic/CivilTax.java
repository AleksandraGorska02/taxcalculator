package taxLogic;

public class CivilTax extends TaxCalculation {


    public CivilTax(double income) {
        super(income);
    }

    public void calculateSocialSecurityTaxes() {
        socialSecurityTax = (income * 9.76) / 100;
        socialSecurityHealthTax = (income * 1.5) / 100;
        sickSecurityTax = (income * 2.45) / 100;

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
        primaryHealthTax = (income * 9) / 100;
        secondaryHealthTax = (income * 7.75) / 100;

        putHealthTax();
    }

    private void putHealthTax() {
        taxData.put("Health social security tax 9%", primaryHealthTax);
        taxData.put("Health social security tax 7.75%", secondaryHealthTax);
    }


    @Override
    public void calculateDeductibleExpensesTax() {
        deductibleExpensesTax = (income * 20) / 100;

        taxedIncome = income - deductibleExpensesTax;
        putTaxedIncome();
    }

    private void putTaxedIncome() {
        taxData.put("Tax deductible expenses", deductibleExpensesTax);
    }

    @Override
    public void calculateAdvanceTax() {

        advanceTax = (taxedIncome * 18) / 100;
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
