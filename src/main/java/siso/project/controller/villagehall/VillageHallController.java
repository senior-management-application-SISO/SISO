package siso.project.controller.villagehall;

import com.google.code.geocoder.model.LatLng;
import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import siso.project.controller.signup.SignUpForm;
import siso.project.domain.Admin;
import siso.project.domain.Users;
import siso.project.domain.VillageHall;
import siso.project.etc.GeoCoder;
import siso.project.repository.dto.VillageHallDto;
import siso.project.service.VillageHallService;
import siso.project.web.SessionConst;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static siso.project.etc.Qr.getQRCodeImage;

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
    public String villageHallInfo(@PathVariable long villageHallId, Model model) throws IOException, WriterException {
        VillageHall villageHall = VillageHall.builder()
                .id(villageHallId)
                .build();
        List<VillageHall> select = villageHallService.villageHallSelect(null, villageHall);
        model.addAttribute("villageHall", select.get(0));

        String img = getQRCodeImage("localhost:8080/villagehall/qrcheck?villageHallId=" + villageHallId, 400, 400);
        model.addAttribute("img", img);

        return "villagehall/villageHallPopupForm";
    }

    @GetMapping("/qrcheck")
    public String villageHallInfo(@RequestParam final Long villageHallId, @RequestParam final Long userId, Model model) {
        villageHallService.villageHallQrCheck(villageHallId, userId);

        model.addAttribute("qrCheckedTime", LocalDateTime.now());

        return "villagehall/qrchecked";
    }

    @PostMapping("/{villageHallId}")
    public String updateVillageHallInfo(@PathVariable long villageHallId, @Valid @ModelAttribute("villageHall") VillageHallForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "villagehall/villageHallPopupForm";
        }

        GeoCoder geoCoder = new GeoCoder();
        LatLng latLng = geoCoder.geoCoding(form.getAddress());

        System.out.println("latLng = " + latLng);

        VillageHallDto villageHallDto = VillageHallDto.builder()
                .hallName(form.getHallName())
                .address(form.getAddress())
                .build();

        villageHallService.villageHallUpdate(villageHallId, villageHallDto);

        return "redirect:/villagehall/" + villageHallId;
    }

    @GetMapping("/delete")
    public void deletePost(@RequestParam final Long id) {
        villageHallService.villageHallDelete(id);
    }

    @GetMapping("/save")
    public String villageHallFormView(Model model) {
        model.addAttribute("villageHall", VillageHall.builder().build());
        return "villagehall/addVillageHallForm";
    }

    @PostMapping("/save")
    public String villageHallSave(@SessionAttribute(name = SessionConst.LOGIN_ADMIN, required = false) Admin loginAdmin, @Valid @ModelAttribute("villageHall") VillageHallForm form, BindingResult bindingResult) {

        VillageHall villageHall = VillageHall.builder()
                .hallName(form.getHallName())
                .address(form.getAddress())
                .build();

        // ID 중복 검사
        List<VillageHall> villageHalls = villageHallService.villageHallSelect(loginAdmin.getId(), villageHall);
        if (villageHalls.size() != 0) {
            bindingResult.reject("villageHall", new Object[]{form.getHallName()}, null);
        }

        if (bindingResult.hasErrors()) {
            return "villagehall/addVillageHallForm";
        }

        villageHallService.villageHallSave(loginAdmin.getId(), villageHall);
        return "redirect:/villagehall";
    }

}
