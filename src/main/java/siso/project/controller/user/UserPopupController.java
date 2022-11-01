package siso.project.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import siso.project.domain.Users;
import siso.project.repository.dto.UsersDto;
import siso.project.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserPopupController {

    private final UserService userService;

    @GetMapping("/list")
    public String SelectUserList(@ModelAttribute("UserSearch") UsersDto usersDto, Model model) {
        List<Users> users = userService.SelectUserList(usersDto);
        model.addAttribute("selectUsers", users);
        return "users/addUserPopupForm";
    }

}
