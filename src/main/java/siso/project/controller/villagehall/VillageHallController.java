package siso.project.controller.villagehall;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import siso.project.domain.Admin;
import siso.project.domain.VillageHall;
import siso.project.repository.VillageHallMapper;
import siso.project.service.VillageHallService;
import siso.project.web.SessionConst;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/villageHall")
public class VillageHallController {

    private final VillageHallService villageHallService;
    private final VillageHallMapper villageHallMapper;


    @GetMapping("/{villageHallId}")
    public String villageHallInfo(@PathVariable long villageHallId, Model model) {
        VillageHall villageHall = VillageHall.builder()
                .id(villageHallId).build();
        List<VillageHall> select = villageHallMapper.select(villageHall);
        model.addAttribute("villageHall", select.get(0));
        return "villageHall/villageHallPopupForm";
    }

    // 게시글 삭제
    @PostMapping("/post/delete.do")
    public String deletePost(@RequestParam final Long id) {
        System.out.println("id = " + id);
        return "redirect:/post/list.do";
    }

}