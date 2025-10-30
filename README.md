# taxcalculator
TaxCalculator - a kata for a Clean Code exercise


1. naming:<br/>
Change the names of the variables and methods to make them more meaningful and easier to understand.<br />
   <br />
2. format:<br/>
Format code to improve readability, including proper indentation and spacing.
<br />
<br />
3. extract printing method<br/>
Extracting printing logic into a separate function
<br /><br />
   
4. add basic folder structure:<br/>
Organize the code into a basic folder structure and prepare for tests.


```
src/main/java/
src/test/java/
```

<br />
<br />

5. Add tests:<br/>
Add tests to verify the correctness of refactored code.
<br />
<br />

6. separation of classes:<br/>
I chose to divide it into three classes: inputHandler for reading income and contract type, Printer for printing data at the end, and TaxCalculation for performing calculations.
<br />
<br />There is a separate class for each contract type: CivilTax and EmploymentTax. Both classes implement methods from the TaxCalculation class. The “template method pattern” design pattern is used here. Additionally, the TaxCalculation class has a taxData field responsible for collecting data to be passed to the Printer class. The data is passed using HashMap, and individual implementations of the TaxCalculation class pass only the necessary data to it. <br />
Additionally, the TaxCalculation class has a calculate() method because for two contract types, the methods responsible for calculations are performed in the same order.<br/><br/>
At the beginning, all variables for performing calculations were in the CivilTax and EmploymentTax classes in order to see if each contract type uses all variables. <br /><br/>

7. Methods implementation:<br/>
In this step, the logic responsible for calculation was transferred to five separate methods:
 ```
   calculateSocialSecurityTaxes();
   calculateHealthTaxes();
   calculateDeductibleExpensesTax();
   calculateAdvanceTax();
   calculateNetIncome();
   ```
In this step, I noticed that, probably due to copying errors, two variables are not used which, according to the comments at the ininitialization of variables, should be used. I took the liberty of making a small change to the logic so as not to transfer these errors to the new classes (the meaning of the calculations is preserved).

8. Fill hashMap with data:<br/>
In this step, the logic for filling in the hashMap was created. At first, I thought about a new function, something like prepareDataToPrint, but after writing it, the data looked unclear, so I decided that after the calculations, each function would fill in the data. This increases the length of each function but improves readability.

