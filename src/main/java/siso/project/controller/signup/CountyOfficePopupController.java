package siso.project.controller.signup;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import siso.project.domain.Admin;
import siso.project.domain.CountyOffice;
import siso.project.repository.CountyOfficeMapper;
import siso.project.repository.dto.CountyOfficeDto;
import siso.project.service.CountyOfficeService;
import siso.project.service.SignUpService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/countyOffice")
public class CountyOfficePopupController {

    private final CountyOfficeService countyOfficeService;

    @GetMapping("/list")
    public String selectCountyOffice(@ModelAttribute("countyOfficeSearch") CountyOffice countyOfficeSearch, Model model) {
        List<CountyOffice> countyOffices = countyOfficeService.selectCountyOffices(countyOfficeSearch);
        model.addAttribute("countyOfficeList", countyOffices);
        return "admins/countyOfficeListForm";
    }

    @PostMapping("/list")
    public String save(@Valid @ModelAttribute("countyOffice") CountyOfficeForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admins/countyOfficeListForm";
        }

        return "redirect:/";
    }
}
