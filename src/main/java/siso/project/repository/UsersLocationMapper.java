package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import siso.project.domain.UsersLocation;

@Mapper
public interface UsersLocationMapper {
    //저장
    void save(UsersLocation usersLocation);
}