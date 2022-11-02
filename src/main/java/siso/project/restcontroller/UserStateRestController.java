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

    @GetMapping("/hallstate/{hallId}")
    public List<UserHallStateVO> selectHallState(@PathVariable Long hallId){
        return userStateService.selectVillageHall(hallId);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
