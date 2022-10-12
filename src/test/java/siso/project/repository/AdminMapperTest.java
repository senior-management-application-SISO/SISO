package siso.project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import siso.project.domain.Admin;
import siso.project.repository.dto.AdminDto;
import java.util.List;


@SpringBootTest
@Transactional
class AdminMapperTest {

    @Autowired
    AdminMapper adminMapper;


    @Test
    void save() {
        Admin admin = new Admin("woo", "id", "pw", "010-11", null);

        adminMapper.save(admin);
    }

    @Test
    void idSelect() {
        List<Admin> woo = adminMapper.select(1L, null, null);
        System.out.println("woo = " + woo);
    }

    @Test
    void nameAndNumberSelect() {
        List<Admin> woo = adminMapper.select(null, "woo", "010-11");
        System.out.println("woo = " + woo);
    }


    @Test
    void infoUpdate() {
        List<Admin> woo = adminMapper.select(null, "woo", "010-11");
        Long id = Long.parseLong(woo.get(0).getId().toString());

        System.out.println("id = " + id);

        AdminDto adminDto = new AdminDto("woo", null,"asd", "010-11", null);

        adminMapper.update(id, adminDto);
    }

    @Test
    void delete() {
        List<Admin> woo = adminMapper.select(null, "woo", "010-11");
        Long id = Long.parseLong(woo.get(0).getId().toString());

        adminMapper.delete(id);
    }
}