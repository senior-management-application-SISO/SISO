package siso.project.controller.team;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import siso.project.controller.signup.SignUpForm;
import siso.project.domain.Admin;
import siso.project.domain.Teams;
import siso.project.domain.VillageHall;
import siso.project.repository.dto.TeamsDto;
import siso.project.repository.dto.UsersDto;
import siso.project.service.TeamService;
import siso.project.web.SessionConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("teams")
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public String teams(@SessionAttribute(name = SessionConst.LOGIN_ADMIN, required = false) Admin loginAdmin, @ModelAttribute("teamSearch") TeamsDto cond, Model model) {
        List<Teams> teams = teamService.teamSelect(loginAdmin.getId(), cond);
        model.addAttribute("teams", teams);
        return "teams/teams";
    }

    @GetMapping("/save")
    public String teamsFormView(Model model) {
        model.addAttribute("teams", Teams.builder().build());
        return "teams/addTeamForm";
    }

    @PostMapping("/save")
    public String teamsSave(@SessionAttribute(name = SessionConst.LOGIN_ADMIN, required = false) Admin loginAdmin, @Valid @ModelAttribute("teams") TeamsForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "teams/addTeamForm";
        }

        Teams teams = Teams.builder()
                .teamName(form.getTeamName())
                .teamAddress(form.getTeamAddress())
                .build();

        teamService.teamSave(loginAdmin.getId(), teams);
        return "redirect:/teams";
    }

    @GetMapping("/{teamId}")
    public String teamEditForm(@PathVariable Long teamId, Model model) {
        Teams team = teamService.findById(teamId);
        model.addAttribute("teams", team);

        return "teams/editTeamForm";
    }

    @PostMapping("/{teamId}")
    public String teamEdit(@PathVariable Long teamId, @Valid @ModelAttribute("teams") TeamsForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "teams/editTeamForm";
        }

        TeamsDto teamsDto = TeamsDto.builder()
                .teamName(form.getTeamName())
                .teamAddress(form.getTeamAddress())
                .build();

        teamService.teamUpdate(teamId, teamsDto);

        return "redirect:/teams/" + teamId;
    }

    @GetMapping("/delete")
    public void teamDelete(@RequestParam final Long id) {
        teamService.teamDelete(id);
    }

    @GetMapping("/list")
    public String selectTeams(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute(SessionConst.LOGIN_ADMIN);

        TeamsDto selectTeam = TeamsDto.builder()
                .adminId(admin.getId())
                .build();

        List<Teams> Teams = teamService.teamSelect(admin.getId(), selectTeam);
        model.addAttribute("teamsList", Teams);
        return "teams/teamsListForm";
    }
}
