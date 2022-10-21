package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import siso.project.domain.Teams;
import siso.project.repository.dto.TeamsDto;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TeamsMapper {

    // 저장
    void save(Teams team);

    // 업데이트
    void update(@Param("id") Long id, @Param("updateParam") TeamsDto updateDto);

    //삭제
    void delete(Long id);

    //단건 조회
    Optional<Teams> findById(Long id);

    // 전체 조회
    List<Teams> select(@Param("adminId") Long loginAdminId, @Param("searchParam")TeamsDto teamsDto);
}
