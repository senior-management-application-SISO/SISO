package siso.project.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import siso.project.domain.Admin;
import siso.project.domain.Teams;
import siso.project.domain.Users;
import siso.project.domain.VillageHall;
import siso.project.repository.dto.TeamsDto;
import siso.project.service.AdminService;
import siso.project.service.TeamService;
import siso.project.service.UserService;
import siso.project.service.VillageHallService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restapi")
public class SignUpRestController {

    private final UserService userService;
    private final TeamService teamService;
    private final AdminService adminService;
    private final VillageHallService villageHallService;

    //1. 회원가입 전 소속 조회
    @GetMapping("/team/{teamName}/{adminId}")
    public List<Teams> selectTeam(@PathVariable String teamName, @PathVariable Long adminId) {
        TeamsDto findTeam = TeamsDto.builder()
                .teamName(teamName)
                .build();

        return teamService.teamSelect(adminId, findTeam);
    }


    //2. 회원가입 전 관리자 조회
    @GetMapping(value = {"/admin/{adminName}/{adminPhoneNumber}", "/admin/{adminName}"})
    public List<Admin> selectAdmin(@PathVariable(required = false) String adminName, @PathVariable(required = false) String adminPhoneNumber) {
        Admin selectAdmin = Admin.builder()
                .adminName(adminName)
                .adminPhoneNumber(adminPhoneNumber)
                .build();

        return adminService.adminListSelect(selectAdmin);
    }


    //3. 회원가입 전 마을회관 조회
    @GetMapping(value= {"/villagehall/{name}/{address}", "/villagehall/{name}"})
    public List<VillageHall> selectVillageHall(@PathVariable(required = false) String name, @PathVariable(required = false) String address) {
        VillageHall villageHall = VillageHall.builder()
                .hallName(name)
                .address(address)
                .build();
        return villageHallService.villageHallSelect(null, villageHall);
    }


    //회원가입
    @PostMapping("/user")
    public String saveUser(@ModelAttribute Users users) {
        userService.userSave(users);
        return "ok";
    }





}
