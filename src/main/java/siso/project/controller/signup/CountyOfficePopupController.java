package siso.project.controller.signup;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import siso.project.domain.Admin;
import siso.project.service.SignUpService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/countyOffice")
public class CountyOfficePopupController {

    private final SignUpService signUpService;

    @GetMapping("/list")
    public String selectCountyOffice(@ModelAttribute("countyOffice") CountyOfficeForm form) {
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
