package siso.project.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import siso.project.domain.Users;
import siso.project.repository.dto.UsersDto;
import siso.project.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restapi")
public class LoginRestController {

    private final UserService userService;

    @PostMapping("/login")
    public Users login(@ModelAttribute UsersDto usersDto) {
        return userService.selectIdPassword(usersDto);
    }
}
