package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import siso.project.domain.CountyOffice;
import siso.project.repository.dto.CountyOfficeDto;

import java.util.List;

@Mapper
public interface CountyOfficeMapper {
    void save(CountyOffice countyOffice);

    List<CountyOffice> select(@Param("id") Long id, @Param("officeName") String officeName, @Param("officeCity") String officeCity, @Param("officeCounty") String officeCounty, @Param("officeAddress") String officeAddress, @Param("officePhoneNumber") String officePhoneNumber);

    void update(@Param("id") Long id, @Param("countyOfficeDto") CountyOfficeDto countyOfficeDto);

    void delete(Long id);
}
