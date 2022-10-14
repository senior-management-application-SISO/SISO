package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import siso.project.domain.VillageHall;
import siso.project.repository.dto.VillageHallDto;

import java.util.List;

@Mapper
public interface VillageHallMapper {

    //저장
    void save(VillageHall villageHall);

    List<VillageHall> select(VillageHall villageHall);

    //업데이트
    void update(@Param("id") Long id, @Param("updateParam") VillageHallDto updateDto);

    void delete(Long id);

}
