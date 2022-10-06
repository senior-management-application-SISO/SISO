package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import siso.project.domain.Users;

@Mapper
public interface UsersMapper {

    //저장
    void save(Users users);
}
