package siso.project.repository.dto;

import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AdminDto {
    private String adminName;
    private String adminId;
    private String adminPassword;
    private String adminPhoneNumber;

    //외래키
    private Long countyOfficeId;


    @Builder
    public AdminDto(String adminName, String adminId, String adminPassword, String adminPhoneNumber, Long countyOfficeId) {
        this.adminName = adminName;
        this.adminId = adminId;
        this.adminPassword = adminPassword;
        this.adminPhoneNumber = adminPhoneNumber;
        this.countyOfficeId = countyOfficeId;
    }
}
