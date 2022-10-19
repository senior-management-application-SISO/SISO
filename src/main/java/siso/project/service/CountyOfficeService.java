package siso.project.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import siso.project.domain.CountyOffice;
import siso.project.etc.CsvParser;
import siso.project.repository.CountyOfficeMapper;
import siso.project.repository.dto.CountyOfficeDto;

import java.net.URL;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CountyOfficeService {
    private final CountyOfficeMapper countyOfficeMapper;

    public void saveCountyOffices() {
        try {
            String[] line = null;
            URL resource = getClass().getClassLoader().getResource("county_office_list.csv");
            CsvParser csvParser = new CsvParser(resource.getFile());
            csvParser.nextRead();
            while ((line = csvParser.nextRead()) != null) {
                CountyOffice countyOffice = new CountyOffice(null, line[3], line[1], line[2].replace(" ", ""), line[5]);
                countyOfficeMapper.save(countyOffice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CountyOffice> selectCountyOffices(CountyOffice countyOffice) {
        return countyOfficeMapper.select(countyOffice);
    }

    public void updateCountyOffice(Long id, CountyOfficeDto CountyOfficeDto) {
        countyOfficeMapper.update(id, CountyOfficeDto);
    }

    public void deleteCountyOffices(Long id) {
        countyOfficeMapper.delete(id);
    }
}
