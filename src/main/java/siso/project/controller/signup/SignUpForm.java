package siso.project.controller.signup;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class SignUpForm {

    @NotEmpty
    private String adminName;

    @NotEmpty
    private String adminId;

    @NotEmpty
    private String adminPassword;

    @NotEmpty
    private String adminPhoneNumber;

    @NotNull
    private Long countyOfficeId;
}
