package siso.project.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import siso.project.domain.Admin;
import siso.project.domain.CountyOffice;
import siso.project.repository.dto.AdminDto;
import siso.project.repository.dto.CountyOfficeDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
@Rollback(value = true)
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
        CountyOffice countyOffice = CountyOffice.builder()
                .officeName("woo")
                .officeCity("seoul")
                .officeCounty("tokyo")
                .build();

        countyOfficeMapper.save(countyOffice);

        CountyOffice selectCountyOffice = CountyOffice.builder()
                .officeName("woo")
                .build();

        List<CountyOffice> woo = countyOfficeMapper.select(selectCountyOffice);
        assertThat(woo.get(0).getId()).isEqualTo(countyOffice.getId());
    }

    @Test
    void infoUpdate() {
        CountyOffice countyOffice = CountyOffice.builder()
                .officeName("woo")
                .officeCity("seoul")
                .officeCounty("tokyo")
                .build();

        countyOfficeMapper.save(countyOffice);

        CountyOfficeDto updateCountyOfficeDto = CountyOfficeDto.builder()
                .officeName("koo")
                .build();

        countyOfficeMapper.update(countyOffice.getId(), updateCountyOfficeDto);
    }

    @Test
    void delete() {
        CountyOffice countyOffice = CountyOffice.builder()
                .officeName("woo")
                .officeCity("seoul")
                .officeCounty("tokyo")
                .build();

        countyOfficeMapper.save(countyOffice);

        countyOfficeMapper.delete(countyOffice.getId());
    }
}