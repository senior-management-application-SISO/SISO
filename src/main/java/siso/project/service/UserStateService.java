package siso.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siso.project.domain.Users;
import siso.project.domain.UsersState;
import siso.project.repository.UsersStateMapper;
import siso.project.repository.vo.UserHallStateVO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserStateService {

    private final UsersStateMapper usersStateMapper;

    //마을회관 Id로 해당 마을회관에 있는 사람 조회)
    public List<UserHallStateVO> selectVillageHall(Long hallId) {
        LocalDate date = LocalDate.now();
        return usersStateMapper.selectHallState(date, hallId);
    }

    public void saveUserState(Users user){
        UsersState usersState = UsersState.builder()
                .date(LocalDateTime.now())
                .attendanceState(true)
                .hallState(false)
                .usersId(user.getId())
                .build();

        usersStateMapper.save(usersState);
    }
}
