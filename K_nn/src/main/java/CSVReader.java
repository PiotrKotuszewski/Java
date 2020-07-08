import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class CSVReader {
    private static Map<Integer, List<String>> m_result = new LinkedHashMap<>();

    static Map<Integer,List<String>> getReaderCSV(Path path) {
        int index = 0;

        String readLine;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(path)))
        ) {
            while ((readLine = bufferedReader.readLine()) != null) {
                String[] splitReadLine = Parser(readLine);
                List<String> list = new ArrayList<>(Arrays.asList(splitReadLine));
                m_result.put(index++, list);
            }
        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }


        return m_result;
    }
    static String[] Parser(String line){

        String[] splitLine = line.split("(?!\\B\"[^\"]*),(?![^\"]*\"\\B)");
        //i=0
        for (int i = 1 ; i < splitLine.length ; i++){

            if (splitLine[i].startsWith("\"")){
                StringBuilder builder = new StringBuilder(splitLine[i]);
                builder.deleteCharAt(0);
                builder.deleteCharAt(splitLine[i].length()-2);
                splitLine[i] = builder.toString();

                splitLine[i] = splitLine[i].replaceAll("\"\"","\"");
            }
        }
        return splitLine;
    }
    public List<String> returnCapital(int i){

        return m_result.get(i);
    }
}
