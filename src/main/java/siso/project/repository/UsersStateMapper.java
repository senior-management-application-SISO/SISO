package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import siso.project.domain.UsersState;
import siso.project.repository.dto.UsersQrStateDto;
import siso.project.repository.vo.UserHallStateVO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Mapper
public interface UsersStateMapper {

    //저장
    void save(UsersState usersState);

    //업데이트
    void update(@Param("id") Long id, @Param("updateParam") UsersQrStateDto usersQrStateDto);

    //userId로 업데이트
    void updateByUserId(@Param("id") Long userId, @Param("updateParam") UsersQrStateDto usersQrStateDto);

    //삭제
    void delete(Long id);

    //검색
    List<UsersState> select(UsersQrStateDto usersQrStateDto);

    //단건조회
    Optional<UsersState> findById(Long id);

    //마을회관 조회 (오늘날짜, 유저가 가는 마을회관 아이디)
    List<UserHallStateVO> selectHallState(@Param("date") LocalDate date, @Param("hallId") Long hallId);
}
