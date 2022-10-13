package siso.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siso.project.domain.Admin;
import siso.project.repository.AdminMapper;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final AdminMapper adminMapper;

    //회원 가입
    public void SignUp(Admin admin) {
        adminMapper.save(admin);
    }
}
