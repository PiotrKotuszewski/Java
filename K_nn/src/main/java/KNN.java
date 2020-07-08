import org.apache.commons.csv.CSVRecord;

import java.util.*;

public class KNN {
    private static int decisionIndex = 0;

    public static double test(int k, List<CSVRecord> data, List<CSVRecord> samples) {
        int trueDecisions = 0;

        for (CSVRecord sample : samples) {
            String guess = testOne(k, data, sample);

            if (guess.equals(sample.get(decisionIndex))) {
                trueDecisions++;
            }
        }

        // percentage
        return (double) trueDecisions / samples.size() * 100;
    }

    public static String testOne(int k, List<CSVRecord> data, CSVRecord sample) {
        List<Object[]> distances = new ArrayList<>();
        Map<String, Integer> decision = new HashMap<>();

        for (CSVRecord record : data) {
            double distance = 0;

            // assuming first column is "nr" we skip it
            for (int i = 1; i < record.size(); i++) {
                try {                    // if we cant cast string to double it is not numeric value

                    distance += Math.pow(Double.parseDouble(record.get(i)) - Double.parseDouble(sample.get(i)), 2);
                } catch (NumberFormatException e) {
                    // so its decision string
                    decisionIndex = i;
                }
            }
            distance = Math.sqrt(distance);

            distances.add(new Object[] { record.get(decisionIndex), distance });
        }

        System.out.println("BEFORE");
        System.out.println("AFTER");
        distances.sort((a, b) -> ((Double) a[1] > (Double) b[1]) ? 1 : -1);

        for (int k_i = 0; k_i < k && k_i < distances.size(); k_i++) {
            String key = (String) distances.get(k_i)[0];

            int val = decision.getOrDefault(key, 0);
            decision.put(key, val + 1);
        }

        String guess = "";
        int guessScore = 0;
        for (String key : decision.keySet()) {
            if (decision.get(key) > guessScore) {
                guess = key;
                guessScore = decision.get(key);
            }
        }

        return guess;
    }
}