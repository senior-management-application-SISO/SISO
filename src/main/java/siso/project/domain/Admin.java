package siso.project.domain;


import lombok.Builder;
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



    @Builder
    public Admin(Long id, String adminName, String adminId, String adminPassword, String adminPhoneNumber, Long countyOfficeId) {
        this.id = id;
        this.adminName = adminName;
        this.adminId = adminId;
        this.adminPassword = adminPassword;
        this.adminPhoneNumber = adminPhoneNumber;
        this.countyOfficeId = countyOfficeId;
    }

    public Admin(Long id, String adminName, String adminId, String adminPhoneNumber, Long countyOfficeId) {
        this.id = id;
        this.adminName = adminName;
        this.adminId = adminId;
        this.adminPhoneNumber = adminPhoneNumber;
        this.countyOfficeId = countyOfficeId;
    }
}
