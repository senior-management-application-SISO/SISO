package siso.project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import siso.project.domain.Teams;
import siso.project.domain.Users;
import siso.project.repository.dto.UsersDto;

import java.sql.Date;
import java.util.List;

@SpringBootTest
@Transactional
class UsersMapperTest {

    @Autowired
    UsersMapper usersMapper;
    @Autowired
    TeamsMapper teamsMapper;


    @Test
    void save() {
        String name = "joe";
        String userId = "id";
        String password = "password";
        Date date = Date.valueOf("2022-10-07");
        String address = "address";
        String phoneNumber = "010";
        boolean alone = false;

        Users users = Users.builder()
                .userName(name)
                .userId(userId)
                .password(password)
                .dateOfBirth(date)
                .address(address)
                .phoneNumber(phoneNumber)
                .alone(alone)
                .build();
        usersMapper.save(users);
    }

    @Test
    void defaultUpdate() {
        Long id = 1L;
        String name = "joe 수정";
        String userId = "id 수정";
        String password = "password 수정";
        Date date = Date.valueOf("2022-10-15");
        String address = "address 수정";
        String phoneNumber = "010 수정";
        boolean alone = true;

        UsersDto updateUsers = UsersDto.builder()
                .userName(name)
                .userId(userId)
                .password(password)
                .dateOfBirth(date)
                .address(address)
                .phoneNumber(phoneNumber)
                .alone(alone)
                .build();

        usersMapper.update(id, updateUsers);
    }


    @Test
    void infoUpdate() {
        Long id = 1L;

        Teams teams = Teams.builder()
                .teamName("teamName")
                .teamAddress("teamAddress")
                .build();

        teamsMapper.save(teams);

        UsersDto updateUsers = UsersDto.builder()
                .teamId(teams.getId())
                .build();

        usersMapper.update(id, updateUsers);
    }

    @Test
    void delete() {
        Long id = 1L;

        usersMapper.delete(id);
    }

    @Test
    void findById() {
        Long id = 1L;

        Users users = usersMapper.findById(id).get();

        System.out.println(users);
    }

    @Test
    void findAll() {
        String name = "joe";
        String phoneNumber = "010";


        UsersDto updateUsers = UsersDto.builder()
                .userName(name)
                .phoneNumber(phoneNumber)
                .build();

        List<Users> users = usersMapper.select(updateUsers);

        System.out.println("users: " + users);
    }
}