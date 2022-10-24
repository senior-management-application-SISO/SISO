package siso.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siso.project.domain.Admin;
import siso.project.domain.Users;
import siso.project.repository.AdminMapper;
import siso.project.repository.UsersMapper;
import siso.project.repository.dto.UsersDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final AdminMapper adminMapper;
    private final UsersMapper usersMapper;

    //회원 가입
    public void SignUp(Admin admin) {
        adminMapper.save(admin);
    }

    // 아이디 중복 검사 (Admin 조회)
    public List<Admin> selectAdmins(String adminId) {
        return adminMapper.select(new Admin(null, null, adminId, null, null));
    }

    // 아이디 중복 검사 (Users 조회)
    public List<Users> selectUsers(String adminId) {
        return usersMapper.select(null, new UsersDto(null, adminId, null, null, null, null, null, null, null, null, null));
    }

}
