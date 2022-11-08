package siso.project.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import siso.project.domain.UsersLocation;
import siso.project.repository.dto.UsersDto;
import siso.project.repository.dto.UsersLocationDto;
import siso.project.service.UsersLocationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restapi/userslocation")
public class UsersLocationRestController {
    private final UsersLocationService usersLocationService;

    @PostMapping("/save")
    public String saveUserLocation(@RequestParam Long userId, @ModelAttribute UsersLocation usersLocation) {
        usersLocationService.saveUserLocation(userId, usersLocation);
        return "ok";
    }

    @GetMapping("/selectbyuserid")
    public UsersLocation selectUserLocationByUserId(@RequestParam Long userId) {
        return usersLocationService.selectUserLocationByUsersId(userId);
    }

    @PostMapping("/update")
    public String upateUsersLocation(@RequestParam Long userId, @ModelAttribute UsersLocationDto usersLocationDto) {
        usersLocationService.updateUsersLocationByUsersId(userId, usersLocationDto);
        return "ok";
    }
}
