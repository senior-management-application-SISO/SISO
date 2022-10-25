package siso.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siso.project.domain.Users;
import siso.project.domain.UsersState;
import siso.project.domain.VillageHall;
import siso.project.repository.UsersStateMapper;
import siso.project.repository.VillageHallMapper;
import siso.project.repository.dto.UsersDto;
import siso.project.repository.dto.UsersQrStateDto;
import siso.project.repository.dto.VillageHallDto;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VillageHallService {
    private final VillageHallMapper villageHallMapper;
    private final UserService userService;
    private final UsersStateMapper usersStateMapper;

    public List<VillageHall> villageHallSelect(Long loginAdminId, VillageHall villageHall) {
        return villageHallMapper.select(loginAdminId, villageHall);
    }

    public void villageHallSave(Long loginAdminId, VillageHall villageHall) {
        VillageHall saveVillageHall = VillageHall.builder()
                .hallName(villageHall.getHallName())
                .address(villageHall.getAddress())
                .adminId(loginAdminId)
                .build();
        villageHallMapper.save(saveVillageHall);
    }

    public void villageHallDelete(Long villageHallId) {
        UsersDto usersDto = UsersDto.builder()
                .villageHallId(villageHallId)
                .build();
        List<Users> userList = userService.findUserList(null, usersDto);

        for (Users users : userList) {
            userService.updateVillageHall(users.getId(), null);
        }

        villageHallMapper.delete(villageHallId);
    }

    public void villageHallUpdate(Long id, VillageHallDto villageHallDto) {
        villageHallMapper.update(id, villageHallDto);
    }

    public void villageHallQrCheck(Long villageHallId, Long userId) {
        UsersQrStateDto usersQrStateDto = UsersQrStateDto.builder()
                .usersId(userId).build();
        List<UsersState> states = usersStateMapper.select(usersQrStateDto);

        UsersQrStateDto updateDto;

        if (states.get(0).getHallState().equals(false)) {
            updateDto = UsersQrStateDto.builder()
                    .date(LocalDateTime.now())
                    .hallState(true)
                    .attendanceState(true).build();
            usersStateMapper.update(states.get(0).getId(), updateDto);
        } else {
            updateDto = UsersQrStateDto.builder()
                    .date(LocalDateTime.now())
                    .hallState(false)
                    .attendanceState(true).build();
            usersStateMapper.update(states.get(0).getId(), updateDto);
        }
    }
}
