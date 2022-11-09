package siso.project.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import siso.project.domain.Users;
import siso.project.repository.vo.UserInfoStateVO;
import siso.project.repository.vo.UserInfoTeamStateVO;
import siso.project.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restapi/users")
public class UsersRestController {

    private final UserService userService;

    @GetMapping("/detail/byteamid/{teamId}")
    public List<UserInfoStateVO> selectUserListByTeamId(@PathVariable long teamId) {
        return userService.selectUserListByTeamId(teamId);
    }
}
