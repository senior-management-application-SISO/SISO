package siso.project.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import siso.project.domain.DiningFriends;
import siso.project.service.DiningFriendsService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restapi")
public class DiningFriendsRestController {

    private final DiningFriendsService diningFriendsService;

    //파티 생성
    @PostMapping("/dining-friends")
    public void create(@ModelAttribute DiningFriends diningFriends) {
        diningFriendsService.create(diningFriends);
    }

    //

}
