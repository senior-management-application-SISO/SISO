package siso.project.controller.villagehall;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import siso.project.domain.Admin;
import siso.project.domain.Teams;
import siso.project.domain.VillageHall;
import siso.project.repository.dto.TeamsDto;
import siso.project.service.VillageHallService;
import siso.project.web.SessionConst;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class VillageHallController {

    private final VillageHallService villageHallService;

    @GetMapping("/villagehall")
    public String villageHalls(@SessionAttribute(name = SessionConst.LOGIN_ADMIN, required = false) Admin loginAdmin, @ModelAttribute("villageHallSearch") VillageHall cond, Model model) {
        List<VillageHall> villageHalls = villageHallService.villageHallSelect(loginAdmin.getId(), cond);
        model.addAttribute("villageHalls", villageHalls);
        return "villagehall/villageHalls";
    }

    @GetMapping("/villagehall/save")
    public String villageHallFormView(Model model) {
        model.addAttribute("villageHall", VillageHall.builder().build());
        return "villagehall/addVillageHallForm";
    }

    @PostMapping("/villagehall/save")
    public String villageHallSave(@SessionAttribute(name = SessionConst.LOGIN_ADMIN, required = false) Admin loginAdmin, @ModelAttribute VillageHall villageHall) {
        villageHallService.villageHallSave(loginAdmin.getId(), villageHall);
        return "redirect:/villagehall";
    }

}
