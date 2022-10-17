package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import siso.project.domain.Users;
import siso.project.repository.dto.UsersDto;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UsersMapper {

    //저장
    void save(Users users);

    //업데이트
    void update(@Param("id") Long id, @Param("updateParam") UsersDto updateDto);

    //삭제
    void delete(Long id);

    //Id로 멤버 조회
    Optional<Users> findById(Long id);

    //전제 조회
    List<Users> select(@Param("adminId") Long loginAdminId, @Param("searchParam") UsersDto usersDto);

}

