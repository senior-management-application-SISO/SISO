package siso.project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import siso.project.domain.DiningFriends;
import siso.project.domain.DiningFriendsUsers;
import siso.project.domain.Teams;
import siso.project.domain.Users;
import siso.project.repository.vo.DiningFriendsUsersVO;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@Transactional
@Rollback(value = true)
class DiningFriendsUsersMapperTest {

    @Autowired
    UsersMapper usersMapper;
    @Autowired
    DiningFriendsUsersMapper diningFriendsUsersMapper;

    @Autowired
    DiningFriendsMapper diningFriendsMapper;
    @Autowired
    TeamsMapper teamsMapper;

    @Test
    void save() {
        //given
        Users users = Users.builder()
                .userName("joe")
                .userId("qwe")
                .password("password")
                .dateOfBirth(Date.valueOf("2022-10-07"))
                .address("address")
                .phoneNumber("010")
                .alone(false)
                .build();
        usersMapper.save(users);

        DiningFriends diningFriends = DiningFriends.builder()
                .memNumber(2)
                .currentNumber(0)
                .time(LocalDateTime.of(2022, 11, 01, 0, 0, 0))
                .address("address")
                .name("name")
                .memo("memo")
                .state(true)
                .build();
        diningFriendsMapper.save(diningFriends);

        //when
        DiningFriendsUsers diningFriendsUsers = DiningFriendsUsers.builder()
                .usersId(users.getId())
                .diningFriendsId(diningFriends.getId())
                .build();

        diningFriendsUsersMapper.save(diningFriendsUsers);
    }

    @Test
    void delete() {
        //given
        Users users = Users.builder()
                .userName("joe")
                .userId("qwe")
                .password("password")
                .dateOfBirth(Date.valueOf("2022-10-07"))
                .address("address")
                .phoneNumber("010")
                .alone(false)
                .build();
        usersMapper.save(users);

        DiningFriends diningFriends = DiningFriends.builder()
                .memNumber(2)
                .currentNumber(0)
                .time(LocalDateTime.of(2022, 11, 01, 0, 0, 0))
                .address("address")
                .name("name")
                .memo("memo")
                .state(true)
                .build();
        diningFriendsMapper.save(diningFriends);

        //when
        DiningFriendsUsers diningFriendsUsers = DiningFriendsUsers.builder()
                .usersId(users.getId())
                .diningFriendsId(diningFriends.getId())
                .build();

        diningFriendsUsersMapper.save(diningFriendsUsers);


        diningFriendsUsersMapper.delete(diningFriendsUsers.getId());
    }

    @Test
    void detailSelect() {
        //given
        Users users = Users.builder()
                .userName("joe")
                .userId("qwe")
                .password("password")
                .dateOfBirth(Date.valueOf("2022-10-07"))
                .address("address")
                .phoneNumber("010")
                .alone(false)
                .build();
        usersMapper.save(users);

        DiningFriends diningFriends = DiningFriends.builder()
                .memNumber(2)
                .currentNumber(0)
                .time(LocalDateTime.of(2022, 11, 01, 0, 0, 0))
                .address("address")
                .name("name")
                .memo("memo")
                .state(true)
                .build();
        diningFriendsMapper.save(diningFriends);

        //when
        DiningFriendsUsers diningFriendsUsers = DiningFriendsUsers.builder()
                .usersId(users.getId())
                .diningFriendsId(diningFriends.getId())
                .build();

        diningFriendsUsersMapper.save(diningFriendsUsers);

        List<DiningFriendsUsersVO> diningFriendsUsersVOS = diningFriendsUsersMapper.selectDiningFriendsUsers(diningFriends.getId());
        System.out.println("diningFriendsUsersVOS = " + diningFriendsUsersVOS);
    }





}