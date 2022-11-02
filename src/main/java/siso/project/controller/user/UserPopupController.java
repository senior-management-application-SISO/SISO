package siso.project.controller.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import siso.project.domain.Users;
import siso.project.repository.dto.UsersDto;
import siso.project.service.UserService;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserPopupController {

    private final UserService userService;

    @GetMapping("/list")
    public String selectUserList(@ModelAttribute("userList") UsersDto usersDto, Model model) {
        List<Users> users = userService.SelectUserList(usersDto);
        model.addAttribute("selectUsers", users);
        return "users/addUserPopupForm";
    }

    @GetMapping("/add/{userId}/{adminId}")
    public String addUserAdminId(@PathVariable String userId, @PathVariable String adminId) {
        Long UserId = Long.valueOf(userId);
        Long AdminId = Long.valueOf(adminId);
        log.info(UserId.toString() + " 어쩔 남윤찬 " + AdminId.toString());
        userService.addUserAdmin(UserId, AdminId);

        return "redirect:/";
    }
}