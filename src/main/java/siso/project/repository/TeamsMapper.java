package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import siso.project.domain.Teams;
import siso.project.repository.dto.TeamsDto;

@Mapper
public interface TeamsMapper {

    // 저장
    void save(Teams team);

    // 업데이트
    void update(@Param("id") Long id, @Param("updateParam") TeamsDto updateDto);

    //삭제
    void delete(Long id);
}
