package siso.project.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import siso.project.domain.Users;
import siso.project.domain.UsersState;
import siso.project.repository.dto.UsersQrStateDto;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@SpringBootTest
@Transactional
class UsersStateMapperTest {

    @Autowired
    UsersStateMapper usersStateMapper;

    @Autowired
    UsersMapper usersMapper;


    @Test
    @DisplayName("저장")
    public void save() {
        //given
        Users users = Users.builder()
                .userName("joe")
                .userId("id")
                .password("password")
                .dateOfBirth(Date.valueOf("2022-10-07"))
                .address("address")
                .phoneNumber("010")
                .alone(false)
                .build();
        usersMapper.save(users);

        LocalDateTime localDateTime = LocalDateTime.of(2022, 10, 12, 14, 0, 0);
        UsersState usersState = UsersState.builder()
                .date(localDateTime)
                .attendanceState(true)
                .hallState(true)
                .usersId(users.getId())
                .build();

        //when
        usersStateMapper.save(usersState);

        //then
        UsersState findUsersState = usersStateMapper.findById(usersState.getId()).get();
        assertThat(findUsersState.getId()).isEqualTo(usersState.getId());
    }

    @Test
    @DisplayName("수정")
    void update() {
        //given
        Users users = Users.builder()
                .userName("joe")
                .userId("id")
                .password("password")
                .dateOfBirth(Date.valueOf("2022-10-07"))
                .address("address")
                .phoneNumber("010")
                .alone(false)
                .build();
        usersMapper.save(users);

        LocalDateTime localDateTime = LocalDateTime.of(2022, 10, 12, 14, 0, 0);
        UsersState usersState = UsersState.builder()
                .date(localDateTime)
                .attendanceState(true)
                .hallState(true)
                .usersId(users.getId())
                .build();
        usersStateMapper.save(usersState);

        LocalDateTime updateLocalDateTime = LocalDateTime.of(2023, 8, 1, 14, 0, 0);
        UsersQrStateDto usersQrStateDto = UsersQrStateDto.builder()
                .date(updateLocalDateTime)
                .attendanceState(false)
                .hallState(false)
                .usersId(users.getId())
                .build();

        //when
        usersStateMapper.update(usersState.getId(), usersQrStateDto);

        //then
        UsersState findUserQrState = usersStateMapper.findById(usersState.getId()).get();
        assertThat(findUserQrState.getAttendanceState()).isFalse();
        assertThat(findUserQrState.getHallState()).isFalse();
    }

    @Test
    @DisplayName("삭제")
    void delete() {
        //given
        Users users = Users.builder()
                .userName("joe")
                .userId("id")
                .password("password")
                .dateOfBirth(Date.valueOf("2022-10-07"))
                .address("address")
                .phoneNumber("010")
                .alone(false)
                .build();
        usersMapper.save(users);

        LocalDateTime localDateTime = LocalDateTime.of(2022, 10, 12, 14, 0, 0);
        UsersState usersState = UsersState.builder()
                .date(localDateTime)
                .attendanceState(true)
                .hallState(true)
                .usersId(users.getId())
                .build();
        usersStateMapper.save(usersState);

        //when
        usersStateMapper.delete(usersState.getId());

        //then
        assertThatThrownBy(() -> usersStateMapper.findById(usersState.getId())
                .orElseThrow(() -> new NoSuchElementException()))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("attendanceState, hallState, UserId를 통한 조회")
    void select() {
        //given
        Users users = Users.builder()
                .userName("joe")
                .userId("id")
                .password("password")
                .dateOfBirth(Date.valueOf("2022-10-07"))
                .address("address")
                .phoneNumber("010")
                .alone(false)
                .build();
        usersMapper.save(users);

        LocalDateTime localDateTime = LocalDateTime.of(2022, 10, 12, 14, 0, 0);
        UsersState usersState = UsersState.builder()
                .date(localDateTime)
                .attendanceState(true)
                .hallState(true)
                .usersId(users.getId())
                .build();
        usersStateMapper.save(usersState);

        //when
        UsersQrStateDto usersQrStateDto = UsersQrStateDto.builder()
                .date(localDateTime)
                .attendanceState(true)
                .hallState(true)
                .usersId(users.getId())
                .build();

        List<UsersState> findUsersStates = usersStateMapper.select(usersQrStateDto);

        //then
        assertThat(findUsersStates.get(0).getAttendanceState()).isTrue();
        assertThat(findUsersStates.get(0).getHallState()).isTrue();
        assertThat(findUsersStates.get(0).getUsersId()).isEqualTo(users.getId());
    }

    @Test
    @DisplayName("단건 조회")
    void findById() {
        //given
        Users users = Users.builder()
                .userName("joe")
                .userId("id")
                .password("password")
                .dateOfBirth(Date.valueOf("2022-10-07"))
                .address("address")
                .phoneNumber("010")
                .alone(false)
                .build();
        usersMapper.save(users);

        LocalDateTime localDateTime = LocalDateTime.of(2022, 10, 12, 14, 00, 00);
        UsersState usersState = UsersState.builder()
                .date(localDateTime)
                .attendanceState(true)
                .hallState(true)
                .usersId(users.getId())
                .build();
        usersStateMapper.save(usersState);

        //when
        UsersState findUsersState = usersStateMapper.findById(usersState.getId()).get();

        //then
        assertThat(findUsersState.getAttendanceState()).isTrue();
        assertThat(findUsersState.getHallState()).isTrue();
        assertThat(findUsersState.getId()).isEqualTo(usersState.getId());
    }


}