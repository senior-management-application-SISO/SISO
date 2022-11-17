package siso.project.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import siso.project.domain.Admin;
import siso.project.domain.Teams;
import siso.project.domain.Users;
import siso.project.domain.VillageHall;
import siso.project.repository.dto.TeamsDto;
import siso.project.repository.vo.AdminCountyOfficeVO;
import siso.project.service.AdminService;
import siso.project.service.TeamService;
import siso.project.service.UserService;
import siso.project.service.VillageHallService;
import siso.project.service.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restapi")
public class SignUpRestController {

    private final UserService userService;
    private final TeamService teamService;
    private final AdminService adminService;
    private final VillageHallService villageHallService;
    private final UserStateService userStateService;

    //1. 회원가입 전 소속 조회
    @GetMapping(value = {"/team/{adminId}/{teamName}", "/team/{adminId}"})
    public List<Teams> selectTeam(@PathVariable(required = false) String teamName, @PathVariable(required = false) Long adminId) {
        TeamsDto findTeam = TeamsDto.builder()
                .teamName(teamName)
                .build();

        return teamService.teamSelect(adminId, findTeam);
    }

    @GetMapping(value = {"/signup/valid/{id}"})
    public Users validId(@PathVariable long id) {
        return userService.findById(id);
    }

    //2. 회원가입 전 관리자 조회
    @GetMapping(value = {"/admin/{adminName}/{adminPhoneNumber}", "/admin/{adminName}"})
    public List<AdminCountyOfficeVO> selectAdmin(@PathVariable(required = false) String adminName, @PathVariable(required = false) String adminPhoneNumber) {
        Admin selectAdmin = Admin.builder()
                .adminName(adminName)
                .adminPhoneNumber(adminPhoneNumber)
                .build();

        List<Admin> admins = adminService.adminListSelect(selectAdmin);

        List<AdminCountyOfficeVO> adminCountyOfficeVOList = new ArrayList<>();

        for (Admin admin : admins) {
            adminCountyOfficeVOList.add(adminService.adminOfficeNameSelect(admin.getId()));
        }

        return adminCountyOfficeVOList;
    }

    //3. 회원가입 전 마을회관 조회
    @GetMapping(value = {"/villagehall/{adminId}/{name}", "/villagehall/{adminId}"})
    public List<VillageHall> selectVillageHall(@PathVariable(required = false) String name, @PathVariable(required = false) Long adminId) {
        VillageHall villageHall = VillageHall.builder()
                .hallName(name)
                .build();
        return villageHallService.villageHallSelect(adminId, villageHall);
    }

    //회원가입
    @PostMapping("/user")
    public String saveUser(@ModelAttribute Users users) {
        userService.userSave(users);
        userStateService.saveUserState(users);
        return String.valueOf(users.getId());
    }
}
