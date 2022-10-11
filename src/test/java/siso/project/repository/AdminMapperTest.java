package siso.project.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import siso.project.domain.Admin;
import siso.project.repository.dto.AdminDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class AdminMapperTest {

    @Autowired
    AdminMapper adminMapper;

    @Test
    void save() {
        Admin admin = Admin.builder()
                .adminName("woo")
                .adminId("id")
                .adminPhoneNumber("pw")
                .adminPhoneNumber("010-11")
                .build();

        adminMapper.save(admin);
    }

    @Test
    void idSelect() {
        List<Admin> woo = adminMapper.select(11L, null, null, null);
        assertThat(woo.get(0).getAdminName().equals("woo"));
    }

    @Test
    void nameAndNumberSelect() {
        List<Admin> woo = adminMapper.select(null, "woo", null, "010-11");
        assertThat(woo.get(0).getAdminName().equals("woo"));
    }


    @Test
    void infoUpdate() {
        List<Admin> woo = adminMapper.select(null, "woo", null, "010-11");
        Long id = Long.parseLong(woo.get(0).getId().toString());

        AdminDto adminDto = new AdminDto("woo", null, "asd", "010-11", null);

        adminMapper.update(id, adminDto);
    }

    @Test
    void delete() {
        List<Admin> woo = adminMapper.select(null, "woo", null, "010-11");
        Long id = Long.parseLong(woo.get(0).getId().toString());

        adminMapper.delete(id);
    }
}