package siso.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siso.project.domain.Admin;
import siso.project.repository.AdminMapper;
import siso.project.repository.dto.AdminDto;
import siso.project.repository.vo.AdminCountyOfficeVO;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminMapper adminMapper;

    public Admin adminSelect(Admin admin) {
        return adminMapper.findByLoginId(admin.getAdminId()).get();
    }

    public void adminUpdate(Long id, AdminDto adminDto) {
        adminMapper.update(id, adminDto);
    }

    public AdminCountyOfficeVO adminOfficeNameSelect(Long id) {
        return adminMapper.selectAdminOfficeName(id);
    }
}
