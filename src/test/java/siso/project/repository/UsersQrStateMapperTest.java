package siso.project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import siso.project.domain.UsersQrState;
import siso.project.repository.dto.UsersQrStateDto;
import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
@Transactional
@Rollback(value = false)
class UsersQrStateMapperTest {

    @Autowired
    UsersQrStateMapper usersQrStateMapper;


    @Test
    public void save() {
        LocalDateTime localDateTime = LocalDateTime.of(2022, 10, 12, 14, 00, 00);

        UsersQrState usersQrState = UsersQrState.builder()
                .date(localDateTime)
                .attendanceState(true)
                .hallState(true)
                .usersId(1L)
                .build();

        usersQrStateMapper.save(usersQrState);
    }

    @Test
    void update() {
        LocalDateTime localDateTime = LocalDateTime.of(2022, 10, 12, 14, 00, 00);

        UsersQrStateDto usersQrStateDto = UsersQrStateDto.builder()
                .date(localDateTime)
                .attendanceState(false)
                .hallState(false)
                .usersId(1L)
                .build();

        usersQrStateMapper.update(1L, usersQrStateDto);
    }

    @Test
    void delete() {
        Long id = 1L;

        usersQrStateMapper.delete(id);
    }

    @Test
    void select() {
        LocalDateTime localDateTime = LocalDateTime.of(2022, 10, 12, 14, 00, 00);

        UsersQrStateDto usersQrStateDto = UsersQrStateDto.builder()
                .date(localDateTime)
                .attendanceState(true)
                .hallState(true)
                .usersId(1L)
                .build();

        List<UsersQrState> usersQrStates = usersQrStateMapper.select(usersQrStateDto);
        System.out.println(usersQrStates);
    }


}