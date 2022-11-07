package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import siso.project.domain.Users;
import siso.project.repository.dto.UsersDto;
import siso.project.repository.vo.UserInfoTeamStateVO;
import siso.project.repository.vo.UserDetailInfoVO;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Mapper
public interface UsersMapper {

    //저장
    void save(Users users);

    //업데이트
    void update(@Param("id") Long id, @Param("updateParam") UsersDto updateDto);

    void addUserAdmin (@Param("id") Long id, @Param("adminId") Long adminId);

    void userTeamDelete(@Param("id") Long id, @Param("userTeamId") Long userTeamId);

    void userAdminDelete(@Param("id") Long id, @Param("userAdminId") Long userAdminId);

    //마을회관 업데이트
    void updateVillageHall(@Param("id") Long id, @Param("villageHallId") Long villageHallId);

    //팀 업데이트
    void updateTeams(@Param("id") Long id, @Param("teamId") Long teamId);

    //삭제
    void delete(Long id);

    //Id로 멤버 조회
    Optional<Users> findById(Long id);

    //팀, 출석 여부 조회
    List<UserInfoTeamStateVO> findUserInfoTeamState(@Param("adminId")Long adminId, @Param("searchParam") UsersDto usersDto, @Param("date")Date date);

    //유저 모든 정보
    Optional<UserDetailInfoVO> findUserDetailInfo(Long userId);

    //전제 조회
    List<Users> select(@Param("adminId") Long loginAdminId, @Param("searchParam") UsersDto usersDto);

    List<Users> selectAllUser(UsersDto usersDto);

    //아이디, 비밀번호 조회
    Users selectIdPassword(UsersDto usersDto);
}

