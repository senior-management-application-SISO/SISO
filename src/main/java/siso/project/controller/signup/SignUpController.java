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
@RequestMapping("/admins")
public class SignUpController {

    private final SignUpService signUpService;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("admin") SignUpForm form) {
        return "admins/addAdminForm";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("admin") SignUpForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admins/addAdminForm";
        }

        Admin admin = Admin.builder()
                .adminId(form.getAdminId())
                .adminPassword(form.getAdminPassword())
                .adminName(form.getAdminName())
                .adminPhoneNumber(form.getAdminPhoneNumber())
                .countyOfficeId(form.getCountyOfficeId())
                .build();

        signUpService.SignUp(admin);

        return "redirect:/";
    }

}
