package siso.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siso.project.domain.Users;
import siso.project.repository.UsersMapper;
import siso.project.repository.dto.UsersDto;
import siso.project.repository.vo.UserDetailInfoVO;
import siso.project.repository.vo.UserInfoStateVO;
import siso.project.repository.vo.UserInfoTeamStateVO;
import siso.project.repository.vo.UserStateVO;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersMapper usersMapper;

    //조회
    public List<Users> findUserList(Long loginAdminId, UsersDto cond) {
        return usersMapper.select(loginAdminId, cond);
    }

    //전체 유저 출력(아이디, 이름, 주소)
    public List<Users> SelectUserList(UsersDto usersDto) {
        return usersMapper.selectAllUser(usersDto);
    }

    //조인 조회
    public List<UserInfoTeamStateVO> findUserListVO(Long loginAdminId, UsersDto cond) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DATE, -3);
//        Date date = new Date(calendar.getTimeInMillis());

        return usersMapper.findUserInfoTeamState(loginAdminId, cond, null);
    }

    //소속 팀의 출석 현황 조회
    public List<UserStateVO> findUserStateByTeamId(Long teamId) {
        return usersMapper.findUserStateByTeamId(teamId);
    }

    public Users findByUserId(String id) {
        return usersMapper.findByUserId(id).get();
    }

    public UserDetailInfoVO findUserDetailInfo(Long userId) {
        return usersMapper.findUserDetailInfo(userId).get();
    }

    public void updateVillageHall(Long id, Long villageHallId) {
        usersMapper.updateVillageHall(id, villageHallId);
    }

    public void updateTeams(Long id, Long teamId) {
        usersMapper.updateTeams(id, teamId);
    }

    //유저 관리자 등록
    public void addUserAdmin(Long id, Long adminId) {
        usersMapper.addUserAdmin(id, adminId);
    }

    public void deleteUserTeamAndAdmin(Long id, Long teamId, Long adminId) {
        usersMapper.userTeamDelete(id, teamId);
        usersMapper.userAdminDelete(id, adminId);
    }

    //회원가입
    public Users userSave(Users users) {
        usersMapper.save(users);
        return users;
    }

    //로그인 가능한 회원인지 조회
    public Users selectIdPassword(UsersDto usersDto) {
        Users users = usersMapper.selectIdPassword(usersDto);
        if (!Objects.isNull(users)) {    //로그인 가능하면
            return users;
        }
        return null;
    }

    //유저 정보 업데이트
    public void userUpdate(Long id, UsersDto usersDto) {
        usersMapper.update(id, usersDto);
    }

    //팀id로 유저 정보와 상태 가져오기
    public List<UserInfoStateVO> selectUserListByTeamId(long teamId) {
        return usersMapper.selectUserInfoStateByTeamId(teamId);
    }
}
