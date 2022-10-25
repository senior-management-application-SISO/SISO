package siso.project.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import siso.project.domain.Users;
import siso.project.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restapi")
public class UserRestController {

    private final UserService userService;

//    @PostMapping("/user")
//    public String saveUser(@ModelAttribute Users users) {
//        userService.userSave(users);
//        return "ok";
//    }





}
