package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import siso.project.domain.Admin;
import siso.project.domain.Teams;
import siso.project.repository.dto.AdminDto;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {
    void save(Admin admin);

    List<Admin> select(@Param("id") Long id, @Param("name") String name, @Param("adminId") String adminId, @Param("phoneNumber") String phoneNumber);

    void update(@Param("id") Long id, @Param("admin") AdminDto adminDto);

    void delete(Long id);
}

