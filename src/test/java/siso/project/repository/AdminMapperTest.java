package siso.project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import siso.project.domain.Admin;
import siso.project.repository.dto.AdminDto;
import java.util.List;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
@Rollback(value = false)
class AdminMapperTest {

    @Autowired
    AdminMapper adminMapper;

    @Test
    void save() {
        Admin admin = Admin.builder()
                .adminName("woo")
                .adminId("id")
                .adminPassword("pw")
                .adminPhoneNumber("pw")
                .adminPhoneNumber("010-11")
                .build();

        adminMapper.save(admin);
    }

    @Test
    void idSelect() {
        Admin admin = Admin.builder()
                .adminName("woo")
                .adminId("id")
                .adminPhoneNumber("pw")
                .adminPhoneNumber("010-11")
                .build();

        adminMapper.save(admin);

        Admin selectAdmin = Admin.builder()
                .adminName("woo")
                .adminId("id")
                .build();

        List<Admin> woo = adminMapper.select(selectAdmin);
        assertThat(woo.get(0).getId()).isEqualTo(admin.getId());
    }

    @Test
    void infoUpdate() {
        Admin admin = Admin.builder()
                .adminName("woo")
                .adminId("id")
                .adminPhoneNumber("pw")
                .adminPhoneNumber("010-11")
                .build();

        adminMapper.save(admin);

        AdminDto adminDto = new AdminDto("koo", null, "asd", "010-11", null);

        adminMapper.update(admin.getId(), adminDto);
    }

    @Test
    void delete() {
        Admin admin = Admin.builder()
                .adminName("woo")
                .adminId("id")
                .adminPhoneNumber("pw")
                .adminPhoneNumber("010-11")
                .build();

        adminMapper.save(admin);

        adminMapper.delete(admin.getId());
    }
}