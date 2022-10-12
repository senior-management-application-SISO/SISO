package siso.project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import siso.project.domain.Admin;
import siso.project.domain.CountyOffice;
import siso.project.repository.dto.AdminDto;
import siso.project.repository.dto.CountyOfficeDto;

import java.util.List;


@SpringBootTest
@Transactional
class CountyOfficeMapperTest {

    @Autowired
    CountyOfficeMapper countyOfficeMapper;


    @Test
    void save() {
        CountyOffice countyOffice = CountyOffice.builder()
                .officeName("woo")
                .officeCity("seoul")
                .officeCounty("tokyo")
                .build();

        countyOfficeMapper.save(countyOffice);
    }

    @Test
    void idSelect() {
        List<CountyOffice> woo = countyOfficeMapper.select(4L, null, null, null, null, null);
        System.out.println("woo = " + woo);
    }

    @Test
    void nameAndNumberSelect() {
        List<CountyOffice> woo = countyOfficeMapper.select(null, "woo", "seoul", null,null, null);
        System.out.println("woo = " + woo);
    }


    @Test
    void infoUpdate() {
        List<CountyOffice> woo = countyOfficeMapper.select(4L, null, null, null,null, null);
        Long id = Long.parseLong(woo.get(0).getId().toString());

        System.out.println("id = " + id);

        CountyOfficeDto countyOfficeDto = CountyOfficeDto.builder()
                .officeName("hyuk")
                .officeCity("tokyo")
                .build();

        countyOfficeMapper.update(id, countyOfficeDto);
    }

    @Test
    void delete() {
        List<CountyOffice> woo = countyOfficeMapper.select(4L, null, null, null,null, null);
        Long id = Long.parseLong(woo.get(0).getId().toString());

        countyOfficeMapper.delete(id);
    }
}