package siso.project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import siso.project.domain.VillageHall;
import siso.project.repository.dto.VillageHallDto;

import java.util.List;


@SpringBootTest
@Transactional
@Rollback(value = false)
class VillageHallMapperTest {

    @Autowired
    VillageHallMapper villageHallMapper;
    @Autowired
    TeamsMapper teamsMapper;

    @Test
    void save() {
        VillageHall villageHall = new VillageHall("WooSong", 1111, 2222, "자양동");

        villageHallMapper.save(villageHall);
    }

    @Test
    void select() {
        List<VillageHall> list = villageHallMapper.select(1L, null);
        System.out.println("마을회관 이름 = " + list.get(0).getHallName());
    }

    @Test
    void update() {
        List<VillageHall> list = villageHallMapper.select(1L, null);
        Long villageHallId = list.get(0).getId();

        VillageHallDto updateParam = new VillageHallDto("Bank", 2222, 3333, "은행동");
        villageHallMapper.update(villageHallId, updateParam);
    }

    @Test
    void delete() {
        Long id = 13L;
        villageHallMapper.delete(id);
    }
}