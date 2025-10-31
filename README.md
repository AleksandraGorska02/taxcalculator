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

<br />

9. Refactor<br/>
Now I changed the tests to work with the new classes, removed unused code, and changed HashMap to LinkedHashMap to ensure the order in which information is displayed.
<br/>
After these refactorings, there were a lot of new files, so I created two new folders:
taxLogic, to which I moved TaxCalculation, CivilTax, and EmploymentTax,
and utils, where I moved InputHandler and Pirinter.
<br />
<br/>
10. After refactoring, I noticed that each of the implementing classes uses the same variables, so I moved their declaration to the TaxCalculation class. There is code duplication in the implementations of these classes (in two functions), but I decided to leave it as it is because it will make any potential future changes in calculations for different types easier.
    <br />
    <br/>
11. Cleanup<br/>
In this step, however, I decided to change the implementation of the calculation functions and separate the logic responsible for transferring data into separate functions implemented immediately after the calculation function. (Many small functions instead of one large one, as I had initially considered.) This way, the principle of single responsibility will be preserved.
    <br />
    <br/>
12. Final Cleanup<br/>

```
 if (contractType == 'E') {

            TaxCalculation taxCalc = new EmploymentTax(income);
            taxCalc.calculate();
            Printer.print(taxCalc.getDataToPrint());

        } else if (contractType == 'C') {

            TaxCalculation taxCalc = new CivilTax(income);
            taxCalc.calculate();
            Printer.print(taxCalc.getDataToPrint());

        } else {
            System.out.println("Unknown type of contract!");
        }
```

<br/>
I also thought about this piece of code, wondering whether it would be better to leave it as it is so as not to add new files, but in the end I decided to use the factory pattern here. This adds extra code but makes it easier to add new contract types/subtypes in the future.
<br/>
When extracting constants, I decided to place them in class implementations because when changes are made, it will be easier to adjust them for each contract independently.
<br />
I changed the way the contract is selected. Adding the ContractType enum allowed me to remove the selection using char.
