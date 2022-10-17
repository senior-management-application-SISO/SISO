package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import siso.project.domain.CountyOffice;
import siso.project.repository.dto.CountyOfficeDto;

import java.util.List;

@Mapper
public interface CountyOfficeMapper {
    void save(CountyOffice countyOffice);

    List<CountyOffice> select(CountyOffice countyOffice);

    List<CountyOffice> findAll();

    void update(@Param("id") Long id, @Param("countyOfficeDto") CountyOfficeDto countyOfficeDto);

    void delete(Long id);
}
