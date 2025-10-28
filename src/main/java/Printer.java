import java.text.DecimalFormat;
import java.util.HashMap;

public class Printer {
    public static DecimalFormat df00 = new DecimalFormat(".00");
    public static DecimalFormat df = new DecimalFormat("#");

    public static void print(HashMap<String, Object> data) {
        for (String key : data.keySet()) {
            System.out.println(key + " : " + df.format((double) data.get(key)));
        }
    }
}
