import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaxCalculatorTest {

    @BeforeEach
    void reset() {
        TaxCalculator.income = 0;
        TaxCalculator.contractType = ' ';
        TaxCalculator.socialSecurityTax = 0;
        TaxCalculator.socialSecurityHealthTax = 0;
        TaxCalculator.socialSecuritySicknessTax = 0;
        TaxCalculator.deductibleExpensesTax = 111.25;
        TaxCalculator.primaryHealthTax = 0;
        TaxCalculator.secondaryHealthTax = 0;
        TaxCalculator.advanceTaxPaidadvanceTax = 0;
        TaxCalculator.taxFreeIncome = 46.33;
        TaxCalculator.advanceTaxPaid0 = 0;
        TaxCalculator.advanceTax = 0;
        TaxCalculator.advanceTaxPaid = 0;
        TaxCalculator.taxPaid = 0;
    }

    @Test
    void testCalculateSocialSecurity() {
        double result = TaxCalculator.calculateSocialSecurity(10000);
        assertEquals(8629.0, result );
        assertEquals(976.0, TaxCalculator.socialSecurityTax);
        assertEquals(150.0, TaxCalculator.socialSecurityHealthTax);
    }

    @Test
    void testCalculateHealthTaxes() {
        TaxCalculator.calculateHealthTaxes(8000);
        assertEquals(720.0, TaxCalculator.primaryHealthTax);
        assertEquals(620.0, TaxCalculator.secondaryHealthTax);
    }

    @Test
    void testCalculateTax() {
        TaxCalculator.calculateTax(5000);
        assertEquals(900.0, TaxCalculator.advanceTax);
    }

    @Test
    void testEmploymentTaxFlow() {
        TaxCalculator.income = 10000;
        TaxCalculator.contractType = 'E';
        TaxCalculator.calculateEmploymentTax();

        assertEquals(976.0, TaxCalculator.socialSecurityTax,"Social security tax mismatch");
        assertEquals(150.0, TaxCalculator.socialSecurityHealthTax, "Health social security tax mismatch");
        assertEquals(245.0, TaxCalculator.socialSecuritySicknessTax,  "Sickness social security tax mismatch");
        assertEquals(776.61, TaxCalculator.primaryHealthTax,  "Primary health tax mismatch");
        assertEquals(668.7475, TaxCalculator.secondaryHealthTax, "Secondary health tax mismatch");
        assertEquals(818.0, TaxCalculator.advanceTaxPaid0,  "Advance tax paid mismatch");
    }

    @Test
    void testCivilTaxFlow() {
        TaxCalculator.income = 10000;
        TaxCalculator.contractType = 'C';
        TaxCalculator.calculateCivilTax();

        assertEquals(976.0, TaxCalculator.socialSecurityTax,  "Social security tax mismatch");
        assertEquals(150.0, TaxCalculator.socialSecurityHealthTax, "Health social security tax mismatch");
        assertEquals(245.0, TaxCalculator.socialSecuritySicknessTax,  "Sickness social security tax mismatch");
        assertEquals(776.61, TaxCalculator.primaryHealthTax, "Primary health tax mismatch");
        assertEquals(668.7475, TaxCalculator.secondaryHealthTax,  "Secondary health tax mismatch");
        assertEquals(1725.8, TaxCalculator.deductibleExpensesTax,  "Deductible expenses mismatch");
    }


    @Test
    void testCalculateAdvanceTax() {
        TaxCalculator.advanceTax = 2000;
        TaxCalculator.secondaryHealthTax = 500;
        TaxCalculator.taxFreeIncome = 100;

        TaxCalculator.calculateAdvanceTax();
        assertEquals(1400.0, TaxCalculator.advanceTaxPaid);
    }
    @Test
    void testCalculateEmploymentTaxWithZeroIncome() {
        TaxCalculator.income = 0;
        TaxCalculator.contractType = 'E';
        TaxCalculator.calculateEmploymentTax();

        assertEquals(0.0, TaxCalculator.socialSecurityTax, "Social security tax should be zero");
        assertEquals(0.0, TaxCalculator.socialSecurityHealthTax, "Health social security tax should be zero");
        assertEquals(0.0, TaxCalculator.socialSecuritySicknessTax, "Sickness social security tax should be zero");
        assertEquals(0.0, TaxCalculator.primaryHealthTax, "Primary health tax should be zero");
        assertEquals(0.0, TaxCalculator.secondaryHealthTax, "Secondary health tax should be zero");
        assertEquals(-66.0, TaxCalculator.advanceTaxPaid0, "Advance tax paid should be zero");
    }
    @Test
    void testCalculateCivilTaxWithZeroIncome() {
        TaxCalculator.income = 0;
        TaxCalculator.contractType = 'C';
        TaxCalculator.calculateCivilTax();

        assertEquals(0.0, TaxCalculator.socialSecurityTax, "Social security tax should be zero");
        assertEquals(0.0, TaxCalculator.socialSecurityHealthTax, "Health social security tax should be zero");
        assertEquals(0.0, TaxCalculator.socialSecuritySicknessTax, "Sickness social security tax should be zero");
        assertEquals(0.0, TaxCalculator.primaryHealthTax, "Primary health tax should be zero");
        assertEquals(0.0, TaxCalculator.secondaryHealthTax, "Secondary health tax should be zero");
        assertEquals(0.0, TaxCalculator.deductibleExpensesTax, "Deductible expenses should remain unchanged");
    }

    @Test
    void testCalculateIncomeWithNegativeSocialSecurity() {
        double result = TaxCalculator.calculateSocialSecurity(-5000);
        assertEquals(-4314.5, result, "Income calculation with negative income failed");
        assertEquals(-488.0, TaxCalculator.socialSecurityTax, "Social security tax calculation with negative income failed");
        assertEquals(-75.0, TaxCalculator.socialSecurityHealthTax, "Health social security tax calculation with negative income failed");
    }
    @Test
    void testCalculateHealthTaxesWithNegativeIncome() {
        TaxCalculator.calculateHealthTaxes(-8000);
        assertEquals(-720.0, TaxCalculator.primaryHealthTax, "Primary health tax calculation with negative income failed");
        assertEquals(-620.0, TaxCalculator.secondaryHealthTax, "Secondary health tax calculation with negative income failed");

    }
    @Test
    void testCalculateNetIncome() {
        double netIncome = TaxCalculator.calculateSocialSecurity(12000);
        assertEquals(10354.8, netIncome, "Net income calculation failed");
    }

    @Test
    void testCalculateCivilNetIncome() {
        TaxCalculator.income = 15000;
        TaxCalculator.contractType = 'C';
        TaxCalculator.calculateCivilTax();

        assertEquals(1464.0, TaxCalculator.socialSecurityTax, "Social security tax mismatch");
        assertEquals(225.0, TaxCalculator.socialSecurityHealthTax, "Health social security tax mismatch");
        assertEquals(367.5, TaxCalculator.socialSecuritySicknessTax, "Sickness social security tax mismatch");
        assertEquals(1164.915, TaxCalculator.primaryHealthTax, "Primary health tax mismatch");
        assertEquals(1003.12125, TaxCalculator.secondaryHealthTax, "Secondary health tax mismatch");
        assertEquals(2588.7, TaxCalculator.deductibleExpensesTax, "Deductible expenses mismatch");
        assertEquals(8861.085,TaxCalculator.netIncome);
    }

    @Test
    void testCalculateEmploymentNetIncome() {
        TaxCalculator.income = 15000;
        TaxCalculator.contractType = 'E';
        TaxCalculator.calculateEmploymentTax();

        assertEquals(1464.0, TaxCalculator.socialSecurityTax, "Social security tax mismatch");
        assertEquals(225.0, TaxCalculator.socialSecurityHealthTax, "Health social security tax mismatch");
        assertEquals(367.5, TaxCalculator.socialSecuritySicknessTax, "Sickness social security tax mismatch");
        assertEquals(1164.915, TaxCalculator.primaryHealthTax, "Primary health tax mismatch");
        assertEquals(1003.12125, TaxCalculator.secondaryHealthTax, "Secondary health tax mismatch");
        assertEquals(1260.0, TaxCalculator.advanceTaxPaid0, "Advance tax paid mismatch");
        assertEquals(8462.085,TaxCalculator.netIncome);
    }
    @Test
    void testCalculateEmploymentNetIncome_5000() {
        TaxCalculator.income = 5000;
        TaxCalculator.contractType = 'E';
        TaxCalculator.calculateEmploymentTax();

        assertEquals(488.0, TaxCalculator.socialSecurityTax, "Social security tax mismatch");
        assertEquals(75.0, TaxCalculator.socialSecurityHealthTax, "Health social security tax mismatch");
        assertEquals(122.5, TaxCalculator.socialSecuritySicknessTax, "Sickness social security tax mismatch");
        assertEquals(388.305, TaxCalculator.primaryHealthTax, "Primary health tax mismatch");
        assertEquals(334.37375, TaxCalculator.secondaryHealthTax, "Secondary health tax mismatch");
        assertEquals(376.0, TaxCalculator.advanceTaxPaid0, "Advance tax paid mismatch");
        assertEquals(2864.6949999999997, TaxCalculator.netIncome, "Net income mismatch");
    }


    @Test
    void testCalculateCivilNetIncome_10000() {
        TaxCalculator.income = 10000;
        TaxCalculator.contractType = 'C';
        TaxCalculator.calculateCivilTax();

        assertEquals(976.0, TaxCalculator.socialSecurityTax, "Social security tax mismatch");
        assertEquals(150.0, TaxCalculator.socialSecurityHealthTax, "Health social security tax mismatch");
        assertEquals(245.0, TaxCalculator.socialSecuritySicknessTax, "Sickness social security tax mismatch");
        assertEquals(776.61, TaxCalculator.primaryHealthTax, "Primary health tax mismatch");
        assertEquals(668.7475, TaxCalculator.secondaryHealthTax, "Secondary health tax mismatch");
        assertEquals(1725.8, TaxCalculator.deductibleExpensesTax, "Deductible expenses mismatch");
        assertEquals(5907.389999999999, TaxCalculator.netIncome, "Net income mismatch");
    }
    @Test
    void testCalculateEmploymentNetIncome_10000() {
        TaxCalculator.income = 10000;
        TaxCalculator.contractType = 'E';
        TaxCalculator.calculateEmploymentTax();

        assertEquals(976.0, TaxCalculator.socialSecurityTax, "Social security tax mismatch");
        assertEquals(150.0, TaxCalculator.socialSecurityHealthTax, "Health social security tax mismatch");
        assertEquals(245.0, TaxCalculator.socialSecuritySicknessTax, "Sickness social security tax mismatch");
        assertEquals(776.61, TaxCalculator.primaryHealthTax, "Primary health tax mismatch");
        assertEquals(668.7475, TaxCalculator.secondaryHealthTax, "Secondary health tax mismatch");
        assertEquals(818.0, TaxCalculator.advanceTaxPaid0, "Advance tax paid mismatch");
        assertEquals(5663.389999999999, TaxCalculator.netIncome, "Net income mismatch");
    }
}
