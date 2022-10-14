package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import siso.project.domain.Users;
import siso.project.domain.UsersQrState;
import siso.project.repository.dto.UsersDto;
import siso.project.repository.dto.UsersQrStateDto;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UsersQrStateMapper {

    //저장
    void save(UsersQrState usersQrState);

    //업데이트
    void update(@Param("id") Long id, @Param("updateParam") UsersQrStateDto usersQrStateDto);

    //삭제
    void delete(Long id);

    //검색
    List<UsersQrState> select(UsersQrStateDto usersQrStateDto);


    //단건조회
    Optional<UsersQrState> findById(Long id);
}
