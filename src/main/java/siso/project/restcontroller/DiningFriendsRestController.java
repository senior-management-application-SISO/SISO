package siso.project.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import siso.project.domain.DiningFriends;
import siso.project.service.DiningFriendsService;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restapi/dining-friends")
public class DiningFriendsRestController {

    private final DiningFriendsService diningFriendsService;

    //파티 생성
    @PostMapping("/save")
    public String create(@ModelAttribute DiningFriends diningFriends) {
        diningFriendsService.create(diningFriends);
        return "ok";
    }

    //자신이 소속(team)된 파티 조회
    @GetMapping("/select/{teamId}")
    public List<DiningFriends> select (@PathVariable Long teamId) {
        return diningFriendsService.select(teamId);
    }

    //파티 참가
   // GetMapping("/")

}
