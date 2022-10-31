package siso.project.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import siso.project.domain.Admin;
import siso.project.domain.CountyOffice;
import siso.project.repository.dto.AdminDto;
import siso.project.repository.dto.CountyOfficeDto;
import siso.project.service.CountyOfficeService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@SpringBootTest
@Transactional
@Rollback(value = true)
class CountyOfficeMapperTest {

    @Autowired
    CountyOfficeMapper countyOfficeMapper;
    @Autowired
    CountyOfficeService countyOfficeService;

    @Test
    @DisplayName("동사무소 저장")
    void save() {
        countyOfficeService.saveCountyOffices();

//        //given
//        CountyOffice countyOffice = CountyOffice.builder()
//                .officeName("woo")
//                .officeCity("seoul")
//                .officeCounty("tokyo")
//                .build();
//
//        //expected
//        countyOfficeMapper.save(countyOffice);
    }

    @Test
    @DisplayName("동사무소 조회")
    void idSelect() {
        //given
        CountyOffice countyOffice = CountyOffice.builder()
                .officeName("woo")
                .officeCity("seoul")
                .officeCounty("tokyo")
                .build();
        countyOfficeMapper.save(countyOffice);

        //when
        CountyOffice selectCountyOffice = CountyOffice.builder()
                .officeName("woo")
                .officeCity("seoul")
                .officeCounty("tokyo")
                .build();
        List<CountyOffice> woo = countyOfficeMapper.select(selectCountyOffice);

        //then
        assertThat(woo.get(0).getId()).isEqualTo(countyOffice.getId());
    }

    @Test
    @DisplayName("동사무소 조회")
    void findAll(){
        List<CountyOffice> countyOffices = countyOfficeMapper.findAll();
//        System.out.println("countyOffices = " + countyOffices);
    }

    @Test
    @DisplayName("동사무소 업데이트")
    void infoUpdate() {
        //given
        CountyOffice countyOffice = CountyOffice.builder()
                .officeName("woo")
                .officeCity("seoul")
                .officeCounty("tokyo")
                .build();
        countyOfficeMapper.save(countyOffice);

        //when
        CountyOfficeDto updateCountyOfficeDto = CountyOfficeDto.builder()
                .officeName("koo")
                .build();
         countyOfficeMapper.update(countyOffice.getId(), updateCountyOfficeDto);

        //then
        CountyOffice selectCountyOffice = CountyOffice.builder()
                .officeName("koo")
                .officeCity("seoul")
                .officeCounty("tokyo")
                .build();
        List<CountyOffice> findCountyOffice = countyOfficeMapper.select(selectCountyOffice);
        assertThat(findCountyOffice.get(0).getOfficeName()).isEqualTo("koo");

    }

    @Test
    @DisplayName("동사무소 삭제")
    void delete() {
        //given
        CountyOffice countyOffice = CountyOffice.builder()
                .officeName("woo")
                .officeCity("seoul")
                .officeCounty("tokyo")
                .build();
        countyOfficeMapper.save(countyOffice);

        //when
        countyOfficeMapper.delete(countyOffice.getId());

        //then
        CountyOffice selectCountyOffice = CountyOffice.builder()
                .officeName("woo")
                .build();
        List<CountyOffice> findCountyOffice = countyOfficeMapper.select(selectCountyOffice);
        assertThatThrownBy(() -> findCountyOffice.get(0)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}