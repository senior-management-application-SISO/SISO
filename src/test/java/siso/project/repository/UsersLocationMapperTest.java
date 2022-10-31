package siso.project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import siso.project.domain.UsersLocation;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@Rollback(value = true)
public class UsersLocationMapperTest {
    @Autowired
    UsersLocationMapper usersLocationMapper;

    @Test
    void save() {
        UsersLocation usersLocation = UsersLocation.builder()
                .lat(1111)
                .lon(2222)
                .time(LocalDateTime.now())
                .build();

        usersLocationMapper.save(usersLocation);
    }
}
