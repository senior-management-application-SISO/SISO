package siso.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siso.project.domain.Users;
import siso.project.repository.UsersMapper;
import siso.project.repository.dto.UsersDto;
import siso.project.repository.vo.UserDetailInfoVO;
import siso.project.repository.vo.UserInfoTeamStateVO;

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
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -3);
        Date date = new Date(calendar.getTimeInMillis());

        return usersMapper.findUserInfoTeamState(loginAdminId, cond, date);
    }

    public UserDetailInfoVO findUserDetailInfo(Long userId) {
        return usersMapper.findUserDetailInfo(userId).get();
    }

    public void updateVillageHall(Long id, Long villageHallId) {
        usersMapper.updateVillageHall(id, villageHallId);
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
    public void userSave(Users users) {
        usersMapper.save(users);
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
}
