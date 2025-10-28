import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputHandler {

    public static double getIncome() {
        double income = 0;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.print("Enter income: ");
            income = Double.parseDouble(br.readLine());
        } catch (Exception ex) {
            System.out.println("Incorrect income input");
            System.err.println(ex);
            System.exit(1);
        }
        return income;
    }

    public static char getContractType() {
        char contractType = ' ';
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.print("Contract Type: (E)mployment, (C)ivil: ");
            contractType = br.readLine().charAt(0);

            if (contractType != 'E' && contractType != 'C') {
                System.out.println("Unknown type of contract!");
                System.exit(1);
            }

        } catch (Exception ex) {
            System.out.println("Incorrect contract type input");
            System.err.println(ex);
            System.exit(1);
        }
        return contractType;
    }
}
