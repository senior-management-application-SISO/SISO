package siso.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siso.project.domain.Admin;
import siso.project.repository.AdminMapper;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final AdminMapper adminMapper;

    /**
     * @return null 로그인 실패
     */
    public Admin login(String loginId, String password) {
        return adminMapper.findByLoginId(loginId)
                .filter(m -> m.getAdminPassword().equals(password))
                .orElse(null);
    }
}
