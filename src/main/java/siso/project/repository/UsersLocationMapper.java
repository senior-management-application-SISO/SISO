package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import siso.project.domain.UsersLocation;
import siso.project.repository.dto.UsersLocationDto;

import java.util.Optional;

@Mapper
public interface UsersLocationMapper {
    //저장
    void save(UsersLocation usersLocation);

    Optional<UsersLocation> selectUserLocationByLocationId(Long id);

    void update(@Param("id") Long id, @Param("usersLocationDto") UsersLocationDto usersLocationDto);
}