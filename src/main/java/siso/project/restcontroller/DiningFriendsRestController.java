package siso.project.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import siso.project.domain.DiningFriends;
import siso.project.domain.DiningFriendsUsers;
import siso.project.repository.vo.DiningFriendsUsersVO;
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

    //파티 삭제
    @PostMapping("/delete")
    public String delete(@ModelAttribute DiningFriends diningFriends){
        diningFriendsService.delete(diningFriends);
        return "ok";
    }

    //자신이 소속(team)된 파티 조회
    @GetMapping("/select/{teamId}")
    public List<DiningFriends> select (@PathVariable Long teamId) {
        return diningFriendsService.select(teamId);
    }

    //특정 파티의 참가자 정보 조회
    @GetMapping("/select/detail/{diningFriendId}")
    public List<DiningFriendsUsersVO> detailSelect (@PathVariable Long diningFriendId) {
        return diningFriendsService.detailSelect(diningFriendId);
    }

    //파티 참가
    @PostMapping("/save/dining-friends-users")
    public void saveDiningFriendsUsers(@ModelAttribute DiningFriendsUsers diningFriendsUsers) {
        diningFriendsService.saveDiningFriendsUsers(diningFriendsUsers);
    }

    //파티 탈퇴
    @PostMapping("/delete/dining-friends-users")
    public void deleteDiningFriendsUsers(@ModelAttribute DiningFriendsUsers diningFriendsUsers) {
        diningFriendsService.deleteDiningFriendsUsers(diningFriendsUsers);
    }
}
