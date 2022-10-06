package siso.project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import siso.project.domain.Users;


@SpringBootTest
@Rollback(value = false)
class UsersMapperTest {

    @Autowired
    UsersMapper usersMapper;

    @Test
    void save() {
        String name = "joe";
        String userId = "id";
        String password = "password";
        String address = "address";
        String phoneNumber = "010";

        Users users = new Users(name, userId, password, address, phoneNumber);

        usersMapper.save(users);
    }


}