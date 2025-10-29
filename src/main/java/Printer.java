import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Printer {
    public static DecimalFormat df00 = new DecimalFormat(".00");
    public static DecimalFormat df = new DecimalFormat("#");

    public static void print(LinkedHashMap<String, Object> data) {
        for (String key : data.keySet()) {
            System.out.println(key + " : " + df00.format((double) data.get(key)));
        }
    }
}
