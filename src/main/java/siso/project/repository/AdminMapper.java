package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import siso.project.domain.Admin;
import siso.project.domain.Teams;
import siso.project.repository.dto.AdminDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface AdminMapper {
    void save(Admin admin);

    List<Admin> select(Admin admin);

    Optional<Admin> findByLoginId(String loginId);

    void update(@Param("id") Long id, @Param("admin") AdminDto adminDto);

    void delete(Long id);
}

