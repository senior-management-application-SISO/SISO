package siso.project.controller.user;

import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import siso.project.domain.Admin;
import siso.project.domain.Users;
import siso.project.repository.dto.UsersDto;
import siso.project.repository.vo.UserDetailInfoVO;
import siso.project.repository.vo.UserInfoTeamStateVO;
import siso.project.service.UserService;
import siso.project.web.SessionConst;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public String members(@SessionAttribute(name = SessionConst.LOGIN_ADMIN, required = false) Admin loginAdmin, @ModelAttribute("userSearch") UsersDto cond, Model model) {
        List<UserInfoTeamStateVO> users = userService.findUserListVO(loginAdmin.getId(), cond);
        model.addAttribute("users", users);
        return "users/users";
    }

    @GetMapping("/{userId}")
    public String users(@PathVariable long userId, Model model) throws IOException, WriterException {
        UserDetailInfoVO userDetailInfo = userService.findUserDetailInfo(userId);
        model.addAttribute("userDetailInfo", userDetailInfo);

        return "users/userPopupForm";
    }

    @GetMapping("/delete")
    public void deleteUserTeamAndAdmin(@RequestParam final Long id, Long teamId, Long adminId) {
        userService.deleteUserTeamAndAdmin(id, teamId, adminId);
    }
}