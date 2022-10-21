package siso.project.controller.villagehall;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import siso.project.domain.Admin;
import siso.project.domain.VillageHall;
import siso.project.service.VillageHallService;
import siso.project.web.SessionConst;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/villagehall")
public class VillageHallController {

    private final VillageHallService villageHallService;

    @GetMapping
    public String villageHalls(@SessionAttribute(name = SessionConst.LOGIN_ADMIN, required = false) Admin loginAdmin, @ModelAttribute("villageHallSearch") VillageHall cond, Model model) {
        List<VillageHall> villageHalls = villageHallService.villageHallSelect(loginAdmin.getId(), cond);
        model.addAttribute("villageHalls", villageHalls);
        return "villagehall/villageHalls";
    }

    @GetMapping("/{villageHallId}")
    public String villageHallInfo(@PathVariable long villageHallId, Model model) {
        VillageHall villageHall = VillageHall.builder()
                .id(villageHallId)
                .build();
        List<VillageHall> select = villageHallService.villageHallSelect(null, villageHall);
        model.addAttribute("villageHall", select.get(0));
        return "villagehall/villageHallPopupForm";
    }

    // 게시글 삭제
    @PostMapping("/delete")
    public String deletePost(@RequestParam final Long id) {
        villageHallService.villageHallDelete(id);
        return "redirect:/villagehall";
    }

    @GetMapping("/save")
    public String villageHallFormView(Model model) {
        model.addAttribute("villageHall", VillageHall.builder().build());
        return "villagehall/addVillageHallForm";
    }

    @PostMapping("/save")
    public String villageHallSave(@SessionAttribute(name = SessionConst.LOGIN_ADMIN, required = false) Admin loginAdmin, @ModelAttribute VillageHall villageHall) {
        villageHallService.villageHallSave(loginAdmin.getId(), villageHall);
        return "redirect:/villagehall";
    }

}
