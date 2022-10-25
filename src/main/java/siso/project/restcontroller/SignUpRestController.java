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
public class SignUpRestController {

    private final UserService userService;

    //1. 회원가입 전 소속 조회


    //2. 회원가입 전 관리자 조회


    //3. 회원가입 전 마을회관 조회


    //회원가입
    @PostMapping("/user")
    public String saveUser(@ModelAttribute Users users) {
        userService.userSave(users);
        return "ok";
    }





}
