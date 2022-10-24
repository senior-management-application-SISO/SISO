package siso.project.controller.team;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import siso.project.controller.signup.SignUpForm;
import siso.project.domain.Admin;
import siso.project.domain.Teams;
import siso.project.repository.dto.TeamsDto;
import siso.project.repository.dto.UsersDto;
import siso.project.service.TeamService;
import siso.project.web.SessionConst;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/teams")
    public String teams(@SessionAttribute(name = SessionConst.LOGIN_ADMIN, required = false) Admin loginAdmin, @ModelAttribute("teamSearch") TeamsDto cond, Model model) {
        List<Teams> teams = teamService.teamSelect(loginAdmin.getId(), cond);
        model.addAttribute("teams", teams);
        return "teams/teams";
    }

    @GetMapping("/teams/save")
    public String teamsFormView(Model model) {
        model.addAttribute("teams", Teams.builder().build());
        return "teams/addTeamForm";
    }

    @PostMapping("/teams/save")
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

    @GetMapping("/teams/{teamId}")
    public String teamEditForm(@PathVariable Long teamId, Model model) {
        Teams team = teamService.findById(teamId);
        model.addAttribute("teams", team);

        return "teams/editTeamForm";
    }

    @PostMapping("/teams/{teamId}")
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

}
