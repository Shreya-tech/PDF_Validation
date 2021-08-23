package utils;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ExcelReader {

    public static ExcelModel ReadCSV(String path, List<String> properties) {
        String line = "";
        String[] values = new String[0];

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                values = line.split(",");

                // info from row=2
                if (!values[0].equalsIgnoreCase("Customer Name")) {
                    properties.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ExcelModel(properties);
    }

}

