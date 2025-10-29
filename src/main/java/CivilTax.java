import java.util.HashMap;

public class CivilTax extends  TaxCalculation {
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
    public CivilTax(double income) {
        super(income);
    }

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
        deductibleExpensesTax = (income * 20) / 100;
        taxData.put("Tax deductible expenses", deductibleExpensesTax);
        taxedIncome = income - deductibleExpensesTax;

    }

    @Override
    public void calculateAdvanceTax() {
        taxData.put("income to be taxed = ", taxedIncome);
        advanceTax = (taxedIncome * 18) / 100;
        taxData.put("Advance tax 18 % = ", advanceTax);
        advanceTaxPaid = advanceTax - secondaryHealthTax - taxFreeIncome;
        taxData.put("Already paid tax = ", taxPaid);
        taxData.put("Advance tax ", advanceTaxPaid);
    }

    @Override
    public void calculateNetIncome() {
        netIncome= income
                - ((socialSecurityTax + socialSecurityHealthTax + sickSecurityTax) + primaryHealthTax + advanceTaxPaid);
        taxData.put("Net income ", netIncome);
        System.out.println("===================== "+income);
        System.out.println("Income " + income);
        System.out.println("Social Security Tax " + socialSecurityTax);
        System.out.println("Social Security Health Tax " + socialSecurityHealthTax);
        System.out.println("Sick Security Tax " + sickSecurityTax);
        System.out.println("Primary Health Tax " + primaryHealthTax);
        System.out.println("Advance Tax Paid " + advanceTaxPaid);
        System.out.println("===================== "+income);

    }



}
