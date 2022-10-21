package siso.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siso.project.domain.Teams;
import siso.project.domain.VillageHall;
import siso.project.repository.VillageHallMapper;
import siso.project.repository.dto.TeamsDto;
import siso.project.repository.dto.VillageHallDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VillageHallService {
    private final VillageHallMapper villageHallMapper;

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

    public void villageHallDelete(Long id) {
        villageHallMapper.delete(id);
    }
}
