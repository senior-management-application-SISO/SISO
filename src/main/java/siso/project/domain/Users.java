package siso.project.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class Users {

    private Long id;

    private String userName;
    private String userId;
    private String password;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;
    private Boolean alone;

    //외래키
    private Long teamId;
    private Long usersLocationId;
    private Long adminId;
    private Long villageHallId;

    @Builder
    public Users(Long id, String userName, String userId, String password, Date dateOfBirth, String address, String phoneNumber, Boolean alone, Long teamId, Long usersLocationId, Long adminId, Long villageHallId) {
        this.id = id;
        this.userName = userName;
        this.userId = userId;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.alone = alone;
        this.teamId = teamId;
        this.usersLocationId = usersLocationId;
        this.adminId = adminId;
        this.villageHallId = villageHallId;
    }
}
