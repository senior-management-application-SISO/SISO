package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import siso.project.domain.UsersState;
import siso.project.repository.dto.UsersQrStateDto;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UsersStateMapper {

    //저장
    void save(UsersState usersState);

    //업데이트
    void update(@Param("id") Long id, @Param("updateParam") UsersQrStateDto usersQrStateDto);

    //삭제
    void delete(Long id);

    //검색
    List<UsersState> select(UsersQrStateDto usersQrStateDto);

    //단건조회
    Optional<UsersState> findById(Long id);
}
