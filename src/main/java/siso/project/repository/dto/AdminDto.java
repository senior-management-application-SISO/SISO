package siso.project.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
    private String adminName;
    private String adminId;
    private String adminPassword;
    private String adminPhoneNumber;

    //외래키
    private Long countyOfficeId;

    public AdminDto(String adminName, String adminPassword, String adminPhoneNumber, Long countyOfficeId) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminPhoneNumber = adminPhoneNumber;
        this.countyOfficeId = countyOfficeId;
    }
}
