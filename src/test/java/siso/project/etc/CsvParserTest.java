package siso.project.etc;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class CsvParserTest {

    @Test
    void listTest() throws IOException {
        String[] line = null;
        URL resource = getClass().getClassLoader().getResource("county_office_list.csv");
        CsvParser csvParser = new CsvParser(resource.getFile());
        while ((line = csvParser.nextRead()) != null) {
            for (String a : line) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}