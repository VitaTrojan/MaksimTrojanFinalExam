package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataGetter {

    public static List<String> getTestData(String filename) throws IOException {
        List<String> records = new ArrayList<String>();
        String record;

        BufferedReader file = new BufferedReader(new FileReader(filename));

        while ((record = file.readLine()) != null) {
            records.add(record);
        }
        file.close();
        return records;
    }
}
