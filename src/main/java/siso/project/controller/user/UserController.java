package siso.project.controller.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import siso.project.domain.Admin;
import siso.project.domain.Users;
import siso.project.repository.dto.UsersDto;
import siso.project.repository.vo.UserInfoTeamStateVO;
import siso.project.service.UserService;
import siso.project.web.SessionConst;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String members(@SessionAttribute(name = SessionConst.LOGIN_ADMIN, required = false) Admin loginAdmin, @ModelAttribute("userSearch") UsersDto cond, Model model) {
        List<UserInfoTeamStateVO> users = userService.findUserListVO(loginAdmin.getId(), cond);
        model.addAttribute("users", users);
        return "users/users";
    }
}
