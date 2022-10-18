package siso.project.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class UsersDto {

    private String userName;
    private String userId;
    private String password;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;
    private Boolean alone;

    private Long teamId;
    private Long adminId;
    private Long usersLocationId;
    private Long villageHallId;

    @Builder
    public UsersDto(String userName, String userId, String password, Date dateOfBirth, String address, String phoneNumber, Boolean alone, Long teamId, Long adminId, Long usersLocationId, Long villageHallId) {
        this.userName = userName;
        this.userId = userId;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.alone = alone;
        this.teamId = teamId;
        this.adminId = adminId;
        this.usersLocationId = usersLocationId;
        this.villageHallId = villageHallId;
    }
}
