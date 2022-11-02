package siso.project.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import siso.project.domain.Admin;
import siso.project.domain.Users;
import siso.project.repository.dto.UsersDto;
import siso.project.repository.vo.AdminCountyOfficeVO;
import siso.project.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restapi")
public class UpdateUserInfoRestController {
    private final UserService userService;

    @PostMapping("/updateuser/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute UsersDto usersDto) {
        userService.userUpdate(id, usersDto);
        return "ok";
    }
}
