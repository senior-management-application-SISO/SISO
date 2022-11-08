package siso.project.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import siso.project.repository.vo.UserHallStateVO;
import siso.project.service.UserStateService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restapi")
public class UserStateRestController {

    private final UserStateService userStateService;

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

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
