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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        DiningFriends diningFriends = getDiningFriends(memNumber, time, address, name, phoneNumber, member, memo, state, null, null);

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
        DiningFriends diningFriends = getDiningFriends(memNumber, time, address, name, phoneNumber, member, memo, state, null, null);
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
        DiningFriendsDto diningFriendsDto = getDiningFriendsDto(updateMemNumber, updateTime, updateAddress, updateName, updatePhoneNumber, updateMember, updateMemo, updateState, null, null);

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
        DiningFriends diningFriends = getDiningFriends(memNumber, time, address, name, phoneNumber, member, memo, state, null, null);
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
        DiningFriendsDto diningFriendsDto =
                DiningFriendsDto.builder()
                        .teamId(team.getId())
                        .usersId(user.getId())
                        .build();

        // 수정gigit
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
        DiningFriends diningFriends = getDiningFriends(memNumber, time, address, name, phoneNumber, member, memo, state, null, null);
        diningFriendsMapper.save(diningFriends);

        //삭제
        diningFriendsMapper.delete(diningFriends.getId());
    }

    @Test
    void findById() {
        Integer memNumber = 1;
        LocalTime time = LocalTime.of(0, 0, 0);
        String address = "address";
        String name = "name";
        String phoneNumber = "phoneNumber";
        String member = "member";
        String memo = "memo";
        Boolean state = true;
        DiningFriends diningFriend = getDiningFriends(memNumber, time, address, name, phoneNumber, member, memo, state, null, null);
        diningFriendsMapper.save(diningFriend);

        DiningFriends foundDiningFriend = diningFriendsMapper.findById(diningFriend.getId()).get();

        assertThat(diningFriend).isNotNull();
        assertThat(foundDiningFriend).isEqualTo(diningFriend);
    }

    @Test
    void select() {
        // 기존 DiningFriends 정보 save
        Integer memNumberA = 1;
        LocalTime timeA = LocalTime.of(0, 0, 0);
        String addressA = "addressA";
        String nameA = "nameA";
        String phoneNumberA = "phoneNumberA";
        String memberA = "memberA";
        String memoA = "memoA";
        Boolean stateA = true;
        DiningFriends diningFriendsA = getDiningFriends(memNumberA, timeA, addressA, nameA, phoneNumberA, memberA, memoA, stateA, null, null);
        diningFriendsMapper.save(diningFriendsA);
        Integer memNumberB = 2;
        LocalTime timeB = LocalTime.of(1, 1, 1);
        String addressB = "addressB";
        String nameB = "nameB";
        String phoneNumberB = "phoneNumberB";
        String memberB = "memberB";
        String memoB = "memoB";
        Boolean stateB = true;
        DiningFriends diningFriendsB = getDiningFriends(memNumberB, timeB, addressB, nameB, phoneNumberB, memberB, memoB, stateB, null, null);
        diningFriendsMapper.save(diningFriendsB);


        // 검색 A : diningFriendsDto.name - "name" / diningFriendsDto.phoneNumber - "phoneNumber"
        DiningFriendsDto diningFriendsDtoA = DiningFriendsDto.builder()
                .name("name")
                .phoneNumber("phoneNumber")
                .build();
        // 검색 B : diningFriendsDto.phoneNumber - "phoneNumberB"
        DiningFriendsDto diningFriendsDtoB = DiningFriendsDto.builder()
                .phoneNumber("phoneNumberB")
                .build();

        
        // 조회
        List<DiningFriends> diningFriendsResultA = diningFriendsMapper.select(diningFriendsDtoA);
        List<DiningFriends> diningFriendsResultB = diningFriendsMapper.select(diningFriendsDtoB);


        // 검증 result A
        assertThat(diningFriendsResultA.size()).isEqualTo(2);
        assertThat(diningFriendsResultA.get(0).getName()).isEqualTo(diningFriendsA.getName());
        assertThat(diningFriendsResultA.get(1).getPhoneNumber()).isEqualTo(diningFriendsB.getPhoneNumber());
        // 검증 result B
        assertThat(diningFriendsResultB.size()).isEqualTo(1);
        assertThat(diningFriendsResultB.get(0).getPhoneNumber()).isEqualTo(diningFriendsB.getPhoneNumber());
    }


    private static DiningFriends getDiningFriends(Integer memNumber, LocalTime time, String address, String name, String phoneNumber, String member, String memo, Boolean state, Long teamId, Long userId) {
        DiningFriends diningFriends = DiningFriends.builder()
                .memNumber(memNumber)
                .time(time)
                .address(address)
                .name(name)
                .phoneNumber(phoneNumber)
                .members(member)
                .memo(memo)
                .state(state)
                .teamId(teamId)
                .usersId(userId)
                .build();
        return diningFriends;
    }

    private static DiningFriendsDto getDiningFriendsDto(Integer updateMemNumber, LocalTime updateTime, String updateAddress, String updateName, String updatePhoneNumber, String updateMember, String updateMemo, Boolean updateState, Long teamId, Long userId) {
        DiningFriendsDto diningFriendsDto = DiningFriendsDto.builder()
                .memNumber(updateMemNumber)
                .time(updateTime)
                .address(updateAddress)
                .name(updateName)
                .phoneNumber(updatePhoneNumber)
                .members(updateMember)
                .memo(updateMemo)
                .state(updateState)
                .teamId(teamId)
                .usersId(userId)
                .build();
        return diningFriendsDto;
    }
}
