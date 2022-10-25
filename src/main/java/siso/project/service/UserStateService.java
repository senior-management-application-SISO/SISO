package siso.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siso.project.repository.UsersStateMapper;
import siso.project.repository.vo.UserHallStateVO;

import java.time.LocalDate;
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
}
