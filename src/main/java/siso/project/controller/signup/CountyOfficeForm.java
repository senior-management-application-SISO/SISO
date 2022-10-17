package siso.project.controller.signup;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CountyOfficeForm {

    @NotEmpty
    private String officeName;
    @NotEmpty
    private String officeCity;
    @NotEmpty
    private String officeCounty;
    @NotEmpty
    private String officeAddress;
}
