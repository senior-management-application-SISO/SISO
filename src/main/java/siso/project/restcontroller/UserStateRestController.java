package siso.project.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import siso.project.domain.Users;
import siso.project.repository.vo.UserDetailInfoVO;
import siso.project.repository.vo.UserHallStateVO;
import siso.project.repository.vo.UserStateVO;
import siso.project.service.UserService;
import siso.project.service.UserStateService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restapi")
public class UserStateRestController {

    private final UserStateService userStateService;
    private final UserService userService;

    //마을회관 Id로 해당 마을회관에 있는 사람 조회)
    @GetMapping("/hallstate/{hallId}")
    public List<UserHallStateVO> selectHallState(@PathVariable Long hallId){
        return userStateService.selectVillageHall(hallId);
    }

    //유저 아이디로 출석체크
    @GetMapping("/userstate/{userId}")
    public void attendanceState(@PathVariable Long userId) {
        userStateService.updateUserState(userId);
    }

    //팀 아이디로 소속 사람들 출석 현황 조회
    @GetMapping("/userstate/team/{teamId}")
    public List<UserStateVO> findUserStateByTeamId(@PathVariable Long teamId) {
        return userService.findUserStateByTeamId(teamId);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
