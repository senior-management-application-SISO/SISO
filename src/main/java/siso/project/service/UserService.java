package siso.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siso.project.domain.Users;
import siso.project.repository.UsersMapper;
import siso.project.repository.dto.UsersDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersMapper usersMapper;

    //조회
    public List<Users> findUserList(Long loginAdminId, UsersDto cond) {
        return usersMapper.select(loginAdminId, cond);
    }
}
