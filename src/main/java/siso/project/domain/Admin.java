package siso.project.domain;

import lombok.Data;

@Data
public class Admin {

    private Long id;

    private String adminName;
    private String adminId;
    private String adminPassword;
    private String adminPhoneNumber;

    //외래키
    private Long countyOfficeId;

    public Admin(String adminName, String adminId, String adminPassword, String adminPhoneNumber, Long countyOfficeId) {
        this.adminName = adminName;
        this.adminId = adminId;
        this.adminPassword = adminPassword;
        this.adminPhoneNumber = adminPhoneNumber;
        this.countyOfficeId = countyOfficeId;
    }

    public Admin(String adminName, String adminPassword, String adminPhoneNumber, Long countyOfficeId) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminPhoneNumber = adminPhoneNumber;
        this.countyOfficeId = countyOfficeId;
    }
}
