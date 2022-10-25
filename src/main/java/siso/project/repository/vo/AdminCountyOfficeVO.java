package siso.project.repository.vo;

import lombok.Data;

@Data
public class AdminCountyOfficeVO {

    //admin
    private Long id;

    private String adminName;

    private String adminId;

    private String adminPassword;
    private String adminPhoneNumber;

    private Long countyOfficeId;


    //CountyOffice
    private String officeName;


}
