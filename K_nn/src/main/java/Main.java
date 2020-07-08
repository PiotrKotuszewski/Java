import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scanner;

    public static void main(String arg[]) throws IOException {
        int k;
        String line;
        Reader inputData = new FileReader("C:\\Users\\piotr\\Desktop\\NAI\\NAI01_S15120\\src\\main\\resources\\train-set.csv");
        List<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(inputData).getRecords();

        while (true) {
            System.out.println(
                    "Wybierz opcje:\n" + "Wprowadz dane: 1\n" + "Test pliku z danymi: 2\n" + "Zakoncz dzialanie programu: 3 ");

            scanner = new Scanner(System.in);
            line = scanner.nextLine();

            if (line.equals("1")) {
                System.out.println("Podaj k: ");
                k = scanner.nextInt();
                CSVRecord sample = scanRecord(records.get(0).toMap().keySet());

                System.out.println(KNN.testOne(k, records, sample) + "\n");
            } else if (line.equals("2")) {
                System.out.println("Podaj k: ");
                k = scanner.nextInt();
                Reader inputSamples = new FileReader("C:\\Users\\piotr\\Desktop\\NAI\\NAI01_S15120\\src\\main\\resources\\test-set.csv");
                List<CSVRecord> samples = CSVFormat.EXCEL.withHeader().parse(inputSamples).getRecords();

                double percent = KNN.test(k, records, samples);
                int correct = (int)(samples.size() * percent / 100);
                System.out.println("Percentage efficiency: " + percent + "%, correct classifications: " +
                        correct + "/" + samples.size() + "\n");
            } else if (line.equals("3")){
                System.exit(0);
            }
        }
    }

    private static CSVRecord scanRecord(Set<String> header) {
        List<Double> sample = new ArrayList<>();

        for (String field : header) {
            if (field.equals("nr") || field.equals("Species"))
                sample.add(1.0);
            else {
                System.out.println("Podaj " + field + ": ");
                sample.add(scanner.nextDouble());
            }
        }

        CSVRecord csvr = null;

        try {
            csvr = CSVParser.parse(sample.stream().map(a -> a.toString()).collect(Collectors.joining(",")),
                    CSVFormat.EXCEL.withHeader(header.toArray(new String[header.size()]))).getRecords().get(0);
        } catch(IOException e){}

        return csvr;
    }
}
