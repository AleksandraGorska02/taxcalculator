
import org.junit.jupiter.api.Test;
import taxLogic.CivilTax;
import taxLogic.EmploymentTax;

import static org.junit.jupiter.api.Assertions.*;

public class TaxCalculatorTest {



    @Test
    void testCalculateSocialSecurity() {
        EmploymentTax taxCalculator  = new EmploymentTax(10000);
        taxCalculator.calculateSocialSecurityTaxes();
        
        assertEquals(976.0, taxCalculator.socialSecurityTax);
        assertEquals(150.0, taxCalculator.socialSecurityHealthTax);
    }

    @Test
    void testCalculateHealthTaxes() {
        EmploymentTax taxCalculator  = new EmploymentTax(8000);
        taxCalculator.calculateHealthTaxes();
        assertEquals(720.0, taxCalculator.primaryHealthTax);
        assertEquals(620.0, taxCalculator.secondaryHealthTax);
    }


    @Test
    void testEmploymentTaxFlow() {
        EmploymentTax taxCalculator  = new EmploymentTax(10000);
   taxCalculator.calculate();


        assertEquals(976.0, taxCalculator.socialSecurityTax,"Social security tax mismatch");
        assertEquals(150.0, taxCalculator.socialSecurityHealthTax, "Health social security tax mismatch");
        assertEquals(245.0, taxCalculator.sickSecurityTax,  "Sickness social security tax mismatch");
        assertEquals(776.61, taxCalculator.primaryHealthTax,  "Primary health tax mismatch");
        assertEquals(668.7475, taxCalculator.secondaryHealthTax, "Secondary health tax mismatch");
        assertEquals(818.1175, taxCalculator.advanceTaxPaid,  "Advance tax paid mismatch");
    }

    @Test
    void testCivilTaxFlow() {
        CivilTax taxCalculator  = new CivilTax(10000);
        taxCalculator.calculate();

        assertEquals(976.0, taxCalculator.socialSecurityTax,  "Social security tax mismatch");
        assertEquals(150.0, taxCalculator.socialSecurityHealthTax, "Health social security tax mismatch");
        assertEquals(245.0, taxCalculator.sickSecurityTax,  "Sickness social security tax mismatch");
        assertEquals(776.61, taxCalculator.primaryHealthTax, "Primary health tax mismatch");
        assertEquals(668.7475, taxCalculator.secondaryHealthTax,  "Secondary health tax mismatch");
        assertEquals(1725.8, taxCalculator.deductibleExpensesTax,  "Deductible expenses mismatch");
    }



    @Test
    void testCalculateEmploymentTaxWithZeroIncome() {
        EmploymentTax taxCalculator  = new EmploymentTax(0);
 taxCalculator.calculate();

        assertEquals(0.0, taxCalculator.socialSecurityTax, "Social security tax should be zero");
        assertEquals(0.0, taxCalculator.socialSecurityHealthTax, "Health social security tax should be zero");
        assertEquals(0.0, taxCalculator.sickSecurityTax, "Sickness social security tax should be zero");
        assertEquals(0.0, taxCalculator.primaryHealthTax, "Primary health tax should be zero");
        assertEquals(0.0, taxCalculator.secondaryHealthTax, "Secondary health tax should be zero");
        assertEquals(-66.35499999999999, taxCalculator.advanceTaxPaid, "Advance tax paid should be zero");
    }
    @Test
    void testCalculateCivilTaxWithZeroIncome() {
        CivilTax taxCalculator  = new CivilTax(0);
        taxCalculator.calculate();


        assertEquals(0.0, taxCalculator.socialSecurityTax, "Social security tax should be zero");
        assertEquals(0.0, taxCalculator.socialSecurityHealthTax, "Health social security tax should be zero");
        assertEquals(0.0, taxCalculator.sickSecurityTax, "Sickness social security tax should be zero");
        assertEquals(0.0, taxCalculator.primaryHealthTax, "Primary health tax should be zero");
        assertEquals(0.0, taxCalculator.secondaryHealthTax, "Secondary health tax should be zero");
        assertEquals(0.0, taxCalculator.deductibleExpensesTax, "Deductible expenses should remain unchanged");
    }

    @Test
    void testCalculateIncomeWithNegativeSocialSecurity() {
        EmploymentTax taxCalculator  = new EmploymentTax(-5000);
        taxCalculator.calculate();

        assertEquals(-4314.5, taxCalculator.income, "Income calculation with negative income failed");
        assertEquals(-488.0, taxCalculator.socialSecurityTax, "Social security tax calculation with negative income failed");
        assertEquals(-75.0, taxCalculator.socialSecurityHealthTax, "Health social security tax calculation with negative income failed");
    }
    @Test
    void testCalculateHealthTaxesWithNegativeIncome() {
        EmploymentTax taxCalculator  = new EmploymentTax(-8000);
        taxCalculator.calculate();
        assertEquals(-621.288, taxCalculator.primaryHealthTax, "Primary health tax calculation with negative income failed");
        assertEquals(-534.9979999999999, taxCalculator.secondaryHealthTax, "Secondary health tax calculation with negative income failed");

    }
    @Test
    void testCalculateNetIncome() {
        EmploymentTax taxCalculator  = new EmploymentTax(15000);
        taxCalculator.calculate();
        assertEquals(9196.73125, taxCalculator.netIncome, "Net income calculation failed");
    }

    @Test
    void testCalculateCivilNetIncome() {
        CivilTax taxCalculator  = new CivilTax(15000);
        taxCalculator.calculate();

        assertEquals(1464.0, taxCalculator.socialSecurityTax, "Social security tax mismatch");
        assertEquals(225.0, taxCalculator.socialSecurityHealthTax, "Health social security tax mismatch");
        assertEquals(367.5, taxCalculator.sickSecurityTax, "Sickness social security tax mismatch");
        assertEquals(1164.915, taxCalculator.primaryHealthTax, "Primary health tax mismatch");
        assertEquals(1003.12125, taxCalculator.secondaryHealthTax, "Secondary health tax mismatch");
        assertEquals(2588.7, taxCalculator.deductibleExpensesTax, "Deductible expenses mismatch");
        assertEquals(8861.34225,taxCalculator.netIncome);
    }

    @Test
    void testCalculateEmploymentNetIncome() {
        EmploymentTax taxCalculator  = new EmploymentTax(15000);
        taxCalculator.calculate();

        assertEquals(1464.0, taxCalculator.socialSecurityTax, "Social security tax mismatch");
        assertEquals(225.0, taxCalculator.socialSecurityHealthTax, "Health social security tax mismatch");
        assertEquals(367.5, taxCalculator.sickSecurityTax, "Sickness social security tax mismatch");
        assertEquals(1164.915, taxCalculator.primaryHealthTax, "Primary health tax mismatch");
        assertEquals(1003.12125, taxCalculator.secondaryHealthTax, "Secondary health tax mismatch");
        assertEquals(1260.3537499999998, taxCalculator.advanceTaxPaid, "Advance tax paid mismatch");
        assertEquals(9196.73125,taxCalculator.netIncome);
    }
    @Test
    void testCalculateEmploymentNetIncome_5000() {
        EmploymentTax taxCalculator  = new EmploymentTax(5000);
        taxCalculator.calculate();
        taxCalculator.income = 5000;
        assertEquals(488.0, taxCalculator.socialSecurityTax, "Social security tax mismatch");
        assertEquals(75.0, taxCalculator.socialSecurityHealthTax, "Health social security tax mismatch");
        assertEquals(122.5, taxCalculator.sickSecurityTax, "Sickness social security tax mismatch");
        assertEquals(388.305, taxCalculator.primaryHealthTax, "Primary health tax mismatch");
        assertEquals(334.37375, taxCalculator.secondaryHealthTax, "Secondary health tax mismatch");
        assertEquals(375.8812500000001, taxCalculator.advanceTaxPaid, "Advance tax paid mismatch");
        assertEquals(3109.81375, taxCalculator.netIncome, "Net income mismatch");
    }


    @Test
    void testCalculateCivilNetIncome_10000() {
        CivilTax taxCalculator  = new CivilTax(10000);
        taxCalculator.calculate();

        assertEquals(976.0, taxCalculator.socialSecurityTax, "Social security tax mismatch");
        assertEquals(150.0, taxCalculator.socialSecurityHealthTax, "Health social security tax mismatch");
        assertEquals(245.0, taxCalculator.sickSecurityTax, "Sickness social security tax mismatch");
        assertEquals(776.61, taxCalculator.primaryHealthTax, "Primary health tax mismatch");
        assertEquals(668.7475, taxCalculator.secondaryHealthTax, "Secondary health tax mismatch");
        assertEquals(1725.8, taxCalculator.deductibleExpensesTax, "Deductible expenses mismatch");
        assertEquals(5907.5615, taxCalculator.netIncome, "Net income mismatch");
    }
    @Test
    void testCalculateEmploymentNetIncome_10000() {
        EmploymentTax taxCalculator  = new EmploymentTax(10000);
        taxCalculator.calculate();

        assertEquals(976.0, taxCalculator.socialSecurityTax, "Social security tax mismatch");
        assertEquals(150.0, taxCalculator.socialSecurityHealthTax, "Health social security tax mismatch");
        assertEquals(245.0, taxCalculator.sickSecurityTax, "Sickness social security tax mismatch");
        assertEquals(776.61, taxCalculator.primaryHealthTax, "Primary health tax mismatch");
        assertEquals(668.7475, taxCalculator.secondaryHealthTax, "Secondary health tax mismatch");
        assertEquals(818.1175, taxCalculator.advanceTaxPaid, "Advance tax paid mismatch");
        assertEquals(6153.2725, taxCalculator.netIncome, "Net income mismatch");
    }
}
