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

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersMapper usersMapper;

    //조회
    public List<Users> findUserList(Long loginAdminId, UsersDto cond) {
        return usersMapper.select(loginAdminId, cond);
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


    public void deleteUserTeamAndAdmin(Long id, Long teamId, Long adminId) {
        usersMapper.userTeamDelete(id, teamId);
        usersMapper.userAdminDelete(id, adminId);
    }
}
