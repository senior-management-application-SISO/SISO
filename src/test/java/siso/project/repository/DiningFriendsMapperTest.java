package siso.project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import siso.project.domain.DiningFriends;
import siso.project.domain.Teams;
import siso.project.domain.Users;
import siso.project.repository.dto.DiningFriendsDto;

import java.sql.Date;
import java.time.LocalTime;

@SpringBootTest
@Transactional
public class DiningFriendsMapperTest {

    @Autowired
    DiningFriendsMapper diningFriendsMapper;
    @Autowired
    TeamsMapper teamsMapper;
    @Autowired
    UsersMapper usersMapper;

    @Test
    void saveWithoutForeignKey() {
        Integer memNumber = 1;
        LocalTime time = LocalTime.of(0, 0, 0);
        String address = "address";
        String name = "name";
        String phoneNumber = "phoneNumber";
        String member = "member";
        String memo = "memo";
        Boolean state = true;
        DiningFriends diningFriends = DiningFriends.builder()
                .memNumber(memNumber)
                .time(time)
                .address(address)
                .name(name)
                .phoneNumber(phoneNumber)
                .members(member)
                .memo(memo)
                .state(state)
                .build();

        diningFriendsMapper.save(diningFriends);
    }


    @Test
    void updateWithoutForeignKey() {
        // 기존 DiningFriends 정보 save
        Integer memNumber = 1;
        LocalTime time = LocalTime.of(0, 0, 0);
        String address = "address";
        String name = "name";
        String phoneNumber = "phoneNumber";
        String member = "member";
        String memo = "memo";
        Boolean state = true;
        DiningFriends diningFriends = DiningFriends.builder()
                .memNumber(memNumber)
                .time(time)
                .address(address)
                .name(name)
                .phoneNumber(phoneNumber)
                .members(member)
                .memo(memo)
                .state(state)
                .build();
        diningFriendsMapper.save(diningFriends);

        // update DiningFriends 정보 update
        Integer updateMemNumber = 2;
        LocalTime updateTime = LocalTime.of(1, 1, 1);
        String updateAddress = "updateAddress";
        String updateName = "updateName";
        String updatePhoneNumber = "updatePhoneNumber";
        String updateMember = "updateMember";
        String updateMemo = "updateMemo";
        Boolean updateState = false;
        DiningFriendsDto diningFriendsDto = DiningFriendsDto.builder()
                .memNumber(updateMemNumber)
                .time(updateTime)
                .address(updateAddress)
                .name(updateName)
                .phoneNumber(updatePhoneNumber)
                .members(updateMember)
                .memo(updateMemo)
                .state(updateState)
                .teamId(null)
                .usersId(null)
                .build();

        diningFriendsMapper.update(diningFriends.getId(), diningFriendsDto);
    }

    @Test
    void updateForeignKeys() {
        // 기존 DiningFriends 정보
        Integer memNumber = 1;
        LocalTime time = LocalTime.of(0, 0, 0);
        String address = "address";
        String name = "name";
        String phoneNumber = "phoneNumber";
        String member = "member";
        String memo = "memo";
        Boolean state = true;
        DiningFriends diningFriends = DiningFriends.builder()
                .memNumber(memNumber)
                .time(time)
                .address(address)
                .name(name)
                .phoneNumber(phoneNumber)
                .members(member)
                .memo(memo)
                .state(state)
                .build();
        diningFriendsMapper.save(diningFriends);

        // Users 생성
        Users user = Users.builder()
                .userName("userName")
                .userId("userId")
                .password("userPassword")
                .dateOfBirth(Date.valueOf("2022-10-01"))
                .address("userAddress")
                .phoneNumber("010-11")
                .build();
        usersMapper.save(user);

        // Teams 생성
        Teams team = Teams.builder()
                .teamName("teamA")
                .teamAddress("teamAddress")
                .build();

        teamsMapper.save(team);

        // DiningFriendsDto 정보
        DiningFriendsDto diningFriendsDto = DiningFriendsDto.builder()
                .teamId(team.getId())
                .usersId(user.getId())
                .build();

        // 수정
        diningFriendsMapper.update(diningFriends.getId(), diningFriendsDto);
    }

    @Test
    void delete() {
        // 기존 DiningFriends 정보
        Integer memNumber = 1;
        LocalTime time = LocalTime.of(0, 0, 0);
        String address = "address";
        String name = "name";
        String phoneNumber = "phoneNumber";
        String member = "member";
        String memo = "memo";
        Boolean state = true;
        DiningFriends diningFriends = DiningFriends.builder()
                .memNumber(memNumber)
                .time(time)
                .address(address)
                .name(name)
                .phoneNumber(phoneNumber)
                .members(member)
                .memo(memo)
                .state(state)
                .build();
        diningFriendsMapper.save(diningFriends);

        //삭제
        diningFriendsMapper.delete(diningFriends.getId());
    }
}
