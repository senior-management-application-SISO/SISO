package siso.project.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import siso.project.domain.VillageHall;
import siso.project.repository.dto.VillageHallDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
@Rollback(value = true)
class VillageHallMapperTest {

    @Autowired
    VillageHallMapper villageHallMapper;
    @Autowired
    TeamsMapper teamsMapper;

    @Test
    void save() {
        //given
        VillageHall villageHall = VillageHall.builder().hallName("WooSong")
                .lat(1111)
                .lon(2222)
                .address("자양동")
                .build();

        //expected
        villageHallMapper.save(villageHall);
    }

    @Test
    void select() {
        //given
        VillageHall villageHall = VillageHall.builder()
                .hallName("WooSong")
                .lat(1111)
                .lon(2222)
                .address("자양동")
                .build();
        villageHallMapper.save(villageHall);

        //when
        VillageHall selectVillageHall = VillageHall.builder()
                .hallName("WooSong")
                .address("자양동")
                .build();
        List<VillageHall> list = villageHallMapper.select(selectVillageHall);

        //then
        assertThat(list.get(0).getId()).isEqualTo(villageHall.getId());
        assertThat(list.get(0).getHallName()).isEqualTo(villageHall.getHallName());
        assertThat(list.get(0).getAddress()).isEqualTo(villageHall.getAddress());
    }

    @Test
    void update() {
        //given
        VillageHall villageHall = VillageHall.builder()
                .hallName("WooSong")
                .lat(1111)
                .lon(2222)
                .address("자양동")
                .build();
        villageHallMapper.save(villageHall);

        //when
        VillageHallDto updateParam = VillageHallDto.builder()
                .hallName("Bank")
                .lat(2222)
                .lon(3333)
                .address("은행동")
                .build();
        villageHallMapper.update(villageHall.getId(), updateParam);

        //then
        VillageHall selectVillageHall = VillageHall.builder()
                .hallName("Bank")
                .address("은행동")
                .build();
        List<VillageHall> list = villageHallMapper.select(selectVillageHall);
        assertThat(list.get(0).getHallName()).isEqualTo(updateParam.getHallName());
        assertThat(list.get(0).getAddress()).isEqualTo(updateParam.getAddress());
        System.out.println(list.get(0));

    }

    @Test
    void delete() {
        //given
        VillageHall villageHall = VillageHall.builder()
                .hallName("WooSong")
                .lat(1111)
                .lon(2222)
                .address("자양동")
                .build();
        villageHallMapper.save(villageHall);

        //when
        villageHallMapper.delete(villageHall.getId());

        //then
        List<VillageHall> select = villageHallMapper.select(villageHall);
        Assertions.assertThatThrownBy(() -> select.get(0))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}