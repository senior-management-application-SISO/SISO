package siso.project.controller.signup;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import siso.project.domain.Admin;
import siso.project.domain.Users;
import siso.project.service.SignUpService;

import javax.validation.Valid;
import java.util.List;

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

        // ID 중복 검사
        if (form.getAdminId() != null && form.getAdminId() != "") {
            List<Admin> foundAdmin = signUpService.selectAdmins(form.getAdminId());
            List<Users> foundUser  = signUpService.selectUsers(form.getAdminId());
            if (foundAdmin.size() != 0 || foundUser.size() != 0) {
                bindingResult.reject("idValidation", new Object[]{form.getAdminId()}, null);
            }
        }


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
