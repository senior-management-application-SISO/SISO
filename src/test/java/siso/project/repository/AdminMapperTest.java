package siso.project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import siso.project.domain.Admin;
import siso.project.domain.CountyOffice;
import siso.project.repository.dto.AdminDto;
import java.util.List;


import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@SpringBootTest
@Transactional
@Rollback(value = false)
class AdminMapperTest {

    @Autowired
    AdminMapper adminMapper;

    @Test
    void save() {
        //given
        Admin admin = Admin.builder()
                .adminName("woo")
                .adminId("11")
                .adminPassword("11")
                .adminPhoneNumber("010")
                .build();

        //expected
        adminMapper.save(admin);
    }

    @Test
    void idSelect() {
        //given
        Admin admin = Admin.builder()
                .adminName("woo")
                .adminId("id")
                .adminPassword("pw")
                .adminPhoneNumber("010-11")
                .build();
        adminMapper.save(admin);

        //when
        Admin selectAdmin = Admin.builder()
                .adminName("woo")
                .adminId("id")
                .build();

        List<Admin> woo = adminMapper.select(selectAdmin);

        //then
        assertThat(woo.get(0).getId()).isEqualTo(admin.getId());
    }

    @Test
    void infoUpdate() {
        //given
        Admin admin = Admin.builder()
                .adminName("woo")
                .adminId("id")
                .adminPassword("pw")
                .adminPhoneNumber("010")
                .build();
        adminMapper.save(admin);

        //when
        AdminDto adminDto = new AdminDto("koo", null, "asd", "010-11", null);
        adminMapper.update(admin.getId(), adminDto);

        //then
        Admin selectAdmin = Admin.builder()
                .adminName("koo")
                .build();
        List<Admin> koo = adminMapper.select(selectAdmin);
        assertThat(admin.getId()).isEqualTo(koo.get(0).getId());
    }

    @Test
    void delete() {
        //given
        Admin admin = Admin.builder()
                .adminName("woo")
                .adminId("id")
                .adminPassword("pw")
                .adminPhoneNumber("010")
                .build();
        adminMapper.save(admin);

        //when
        adminMapper.delete(admin.getId());

        //then
        Admin selectAdmin = Admin.builder()
                .adminName("woo")
                .build();

        List<Admin> select = adminMapper.select(selectAdmin);

        assertThatThrownBy(() -> select.get(0)).isInstanceOf(IndexOutOfBoundsException.class);

    }

}