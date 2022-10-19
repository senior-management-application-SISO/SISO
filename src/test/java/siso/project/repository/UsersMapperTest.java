package siso.project.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import siso.project.domain.Admin;
import siso.project.domain.CountyOffice;
import siso.project.domain.Teams;
import siso.project.domain.Users;
import siso.project.repository.dto.UsersDto;
import siso.project.repository.vo.UserInfoTeamStateVO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
@Rollback(value = false)
class UsersMapperTest {

    @Autowired
    UsersMapper usersMapper;
    @Autowired
    TeamsMapper teamsMapper;
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    CountyOfficeMapper countyOfficeMapper;


    @Test
    @DisplayName("저장")
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
                .teamId(5L)
                .adminId(4L)
                .build();

        //when
        usersMapper.save(users);

        //then
//        Users findUser = usersMapper.findById(users.getId()).get();
//        assertThat(findUser.getUserId()).isEqualTo("id");
//        assertThat(findUser.getPassword()).isEqualTo("password");
//        assertThat(findUser.getUserName()).isEqualTo("joe");
    }

    @Test
    @DisplayName("기본정보 업데이트")
    void defaultUpdate() {
        //given
        Users users = Users.builder()
                .userName("joe")
                .userId("qwe")
                .password("password")
                .dateOfBirth(Date.valueOf("2022-10-07"))
                .address("address")
                .phoneNumber("010")
                .alone(false)
                .teamId(3L)
                .adminId(2L)
                .build();
        usersMapper.save(users);

        //when
        UsersDto updateUsers = UsersDto.builder()
                .userName("joe 수정")
                .userId("id 수정")
                .password("password 수정")
                .dateOfBirth(Date.valueOf("2022-10-15"))
                .address("address 수정")
                .phoneNumber("010 수정")
                .alone(true)
                .build();
        usersMapper.update(users.getId(), updateUsers);

        //then
        Users findUser = usersMapper.findById(users.getId()).get();
        assertThat(findUser.getUserName()).isEqualTo("joe 수정");
        assertThat(findUser.getUserId()).isEqualTo("id 수정");
        assertThat(findUser.getPassword()).isEqualTo("password 수정");
    }


    @Test
    @DisplayName("외래키(teamId, adminId) 업데이트")
    void infoUpdate() {
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

        CountyOffice countyOffice = CountyOffice.builder()
                .officeName("name")
                .officeCity("city")
                .officeCounty("county")
                .officeAddress("address")
                .build();
        countyOfficeMapper.save(countyOffice);

        Admin admin = Admin.builder()
                .adminName("admin")
                .adminId("adminId")
                .adminPassword("adminPassword")
                .adminPhoneNumber("010")
                .countyOfficeId(countyOffice.getId())
                .build();
        adminMapper.save(admin);

        Teams teams = Teams.builder()
                .teamName("teamName")
                .teamAddress("teamAddress")
                .adminId(admin.getId())
                .build();
        teamsMapper.save(teams);

        //when
        UsersDto updateUsers = UsersDto.builder()
                .teamId(teams.getId())
                .adminId(admin.getId())
                .build();
        usersMapper.update(users.getId(), updateUsers);

        //then
        Users findUser = usersMapper.findById(users.getId()).get();
        assertThat(findUser.getTeamId()).isEqualTo(teams.getId());
        assertThat(findUser.getAdminId()).isEqualTo(admin.getId());
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

        //when
        usersMapper.delete(users.getId());

        //then-1
        //삭제했으므로 조회가 안되서 'NoSuchElementException' 에러가 발생 해야 한다.
        assertThatThrownBy(() -> usersMapper.findById(users.getId())
                .orElseThrow(() -> new NoSuchElementException()))
                .isInstanceOf(NoSuchElementException.class);

        //then-2
        Users findUser = usersMapper.findById(users.getId()).orElse(null);
        assertThat(findUser).isNull();
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

        //when
        Users findUser = usersMapper.findById(users.getId()).get();

        //then
        assertThat(findUser.getUserName()).isEqualTo("joe");
        assertThat(findUser.getUserId()).isEqualTo("id");
        assertThat(findUser.getPassword()).isEqualTo("password");
        assertThat(findUser.getDateOfBirth()).isEqualTo(Date.valueOf("2022-10-07"));
        assertThat(findUser.getAddress()).isEqualTo("address");
        assertThat(findUser.getPhoneNumber()).isEqualTo("010");
        assertThat(findUser.getAlone()).isFalse();
    }

    @Test
    @DisplayName("유저 정보, 팀, 현황 조회")
    void findUserInfoStateTeam(){
        UsersDto searchDto = UsersDto.builder()
                .userName("joe")
                .phoneNumber("010")
                .build();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -3);

        Date date =new Date(calendar.getTimeInMillis());

        List<UserInfoTeamStateVO> userInfoStateTeam = usersMapper.findUserInfoTeamState(1L, searchDto, date);
        for (UserInfoTeamStateVO userInfoTeamStateVO : userInfoStateTeam) {
            System.out.println(">>>>>>>>userInfoTeamStateVO = " + userInfoTeamStateVO);
        }
    }

    @Test
    @DisplayName("이름 또는 번호로 유저 조회")
    void findAll() {
        //given
        Admin admin = Admin.builder()
                .adminName("woo")
                .adminId("id")
                .adminPassword("pw")
                .adminPhoneNumber("010")
                .build();
        adminMapper.save(admin);

        Users users = Users.builder()
                .userName("joe")
                .userId("id")
                .password("password")
                .dateOfBirth(Date.valueOf("2022-10-07"))
                .address("address")
                .phoneNumber("010")
                .adminId(admin.getId())
                .alone(false)
                .build();
        usersMapper.save(users);

        //when
        String name = "joe";
        String phoneNumber = "010";

        UsersDto selectUsers = UsersDto.builder()
                .userName(name)
                .phoneNumber(phoneNumber)
                .build();

        List<Users> findUsers = usersMapper.select(admin.getId(), selectUsers);

        //then
        assertThat(findUsers.get(0).getUserName()).isEqualTo("joe");
        assertThat(findUsers.get(0).getPhoneNumber()).isEqualTo("010");
    }

}