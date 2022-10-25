package siso.project.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import siso.project.domain.Admin;
import siso.project.domain.Teams;
import siso.project.repository.dto.AdminDto;
import siso.project.repository.dto.TeamsDto;
import siso.project.repository.vo.AdminCountyOfficeVO;
import siso.project.service.AdminService;
import siso.project.web.SessionConst;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/admin")
    public String adminSelect(@SessionAttribute(name = SessionConst.LOGIN_ADMIN, required = false) Admin loginAdmin, Model model) {
        AdminCountyOfficeVO admin = adminService.adminOfficeNameSelect(loginAdmin.getId());
        model.addAttribute("admin", admin);

        return "admins/adminView";
    }

    @GetMapping("/admin/edit")
    public String adminEditForm(@SessionAttribute(name = SessionConst.LOGIN_ADMIN, required = false) Admin loginAdmin, Model model) {
        AdminCountyOfficeVO admin = adminService.adminOfficeNameSelect(loginAdmin.getId());
        model.addAttribute("admin", admin);

        return "admins/editAdminForm";
    }

    @PostMapping("/admin/edit")
    public String adminEdit(@SessionAttribute(name = SessionConst.LOGIN_ADMIN, required = false) Admin loginAdmin, @ModelAttribute AdminDto adminDto) {
        adminService.adminUpdate(loginAdmin.getId(), adminDto);

        return "redirect:/admin";
    }

}
