import org.json.JSONObject;
import java.io.*;
import java.util.*;

public class ShamirSecretSharing {

    public static long decodeBase(String value, int base) {
        long result = 0;
        for (char digit : value.toCharArray()) {
            result = result * base + (Character.isDigit(digit) ? digit - '0' : digit - 'A' + 10);
        }
        return result;
    }

    public static double lagrangeInterpolation(List<Map.Entry<Integer, Long>> points) {
        double constant = 0.0;
        int k = points.size();

        for (int i = 0; i < k; ++i) {
            double term = points.get(i).getValue();
            for (int j = 0; j < k; ++j) {
                if (i != j) {
                    term *= (double) -points.get(j).getKey() / (points.get(i).getKey() - points.get(j).getKey());
                }
            }
            constant += term;
        }
        return constant;
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("testcase.json"));
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
            reader.close();

            JSONObject root = new JSONObject(jsonContent.toString());

            int n = root.getJSONObject("keys").getInt("n");
            int k = root.getJSONObject("keys").getInt("k");

            System.out.println("n = " + n + ", k = " + k);

            List<Map.Entry<Integer, Long>> points = new ArrayList<>();

            for (String key : root.keySet()) {
                if (key.equals("keys"))
                    continue;

                int x = Integer.parseInt(key);
                JSONObject pointData = root.getJSONObject(key);
                int base = Integer.parseInt(pointData.getString("base"));
                String value = pointData.getString("value");
                long y = decodeBase(value, base);

                points.add(new AbstractMap.SimpleEntry<>(x, y));
            }

            Collections.sort(points, Comparator.comparingInt(Map.Entry::getKey));

            for (Map.Entry<Integer, Long> point : points) {
                System.out.print("(" + point.getKey() + ", " + point.getValue() + ") ");
            }
            System.out.println();

            if (points.size() < k) {
                System.err.println("Error: Insufficient points to solve the polynomial.");
                return;
            }

            double constant = lagrangeInterpolation(points);
            System.out.println("The constant term (c) of the polynomial is: " + (long) constant);

        } catch (IOException | org.json.JSONException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
