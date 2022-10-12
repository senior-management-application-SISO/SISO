package siso.project.etc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import siso.project.service.CountyOfficeService;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class CsvParserTest {

    @Autowired
    CountyOfficeService countyOfficeService;

    @Test
    void listTest() throws IOException {
        String[] line = null;
        URL resource = getClass().getClassLoader().getResource("county_office_list.csv");
        CsvParser csvParser = new CsvParser(resource.getFile());
        csvParser.nextRead();
        while ((line = csvParser.nextRead()) != null) {
            for (String a : line) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    @Test
    void saveCountyOfficeTest(){
        countyOfficeService.saveCountyOffices();
    }
}